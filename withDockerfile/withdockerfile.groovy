node {

    // Discard old builds, keeping only the last 5
    properties([
        buildDiscarder(logRotator(numToKeepStr: '5'))
    ])

    parameters([
            choice(name: 'ACTION', choices: ['build', 'destroy'], description: 'Select build or destroy operation')
    ])

    def ACTION = params.ACTION ?: 'build'
    def NETWORK_NAME = 'withDockerfile'
    def VOLUME_NAME = 'withDockerfile'
    def MONGO_IMAGE = 'mongodb'
    def NODEJS_IMAGE = 'nodejs'

    try {
        stage('Checkout') {
            git branch: 'main', url: 'https://github.com/AshokTippaluri/ashok-test.git'
        }

        if (ACTION == 'build') {
            stage('Build Docker Images') {
                sh """
                    docker build -t ${NODEJS_IMAGE} ./withDockerfile/
                    docker build -t ${MONGO_IMAGE} ./withDockerfile/mongodb/
                    docker images
                """
            }

            stage('Create Network and Volume') {
                sh """
                    docker network create ${NETWORK_NAME}
                    docker volume create ${VOLUME_NAME}
                    docker network ls
                    docker volume ls
                """
            }

            stage('Run Containers') {
                sh """
                    docker run -d --name mongodb \
                        --network ${NETWORK_NAME} \
                        -e MONGO_INITDB_ROOT_USERNAME=admin \
                        -e MONGO_INITDB_ROOT_PASSWORD=secret \
                        -v ${VOLUME_NAME}:/data/db \
                        -p 27017:27017 \
                        ${MONGO_IMAGE}
                    
                    docker run -d --name nodejs \
                        --network ${NETWORK_NAME} \
                        -e MONGO_URL="mongodb://admin:secret@mongodb:27017/mydb" \
                        -p 8085:8080 \
                        ${NODEJS_IMAGE}
                    
                    docker ps
                """
            }

            stage('Health Check') {
                sh """
                    curl -f http://localhost:8085/items || exit 1
                    docker exec nodejs ping -c 4 mongodb
                """
            }
        } else if (ACTION == 'destroy') {
            stage('Cleanup') {
                sh """
                    docker stop nodejs mongodb || true
                    docker rm nodejs mongodb || true
                    docker network rm ${NETWORK_NAME} || true
                    docker volume rm ${VOLUME_NAME} || true
                    docker ps -a
                    docker network ls
                    docker volume ls
                """
            }
        }
    } finally {
        stage('Post Cleanup') {
            sh 'docker system prune -a -f --volumes || true'
        }
    }
}
