pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/AshokTippaluri/ashok-test.git'
            }
        }
        
        stage('Cleanup Docker') {
            steps {
                script {
                    sh 'docker image prune -a -f'
                    sh 'docker system prune -a -f --volumes'
                }
            }
        }
        
        stage('Run Containers') {
            steps {
                script {
                    sh 'docker compose -f docker-compose.yaml up -d'
                }
            }
        }

        stage('Health Check') {
            steps {
                script {
                    sh 'curl -f http://localhost:8085/items || exit 1'
                }
            }
        }

        stage('Container Connectivity Check') {
            steps {
                script {
                    // Check if the web container can reach MongoDB internally
                    sh 'docker exec web ping -c 4 mongodb'
                    // Alternatively, test MongoDB connection from within the web container
                    sh 'docker exec web curl -f mongodb:27017 || echo "MongoDB connection failed"'
                }
            }
        }

        stage('Cleanup') {
            steps {
                script {
                    sh 'docker compose -f docker-compose.yaml down -v'
                }
            }
        }
    }
}
