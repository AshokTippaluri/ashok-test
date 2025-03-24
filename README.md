# ashok-test

an repo for learning purpose
---------------------------------------------------------------------------------------------------------

Ashok's Git Learning Project

This repository contains different approaches to deploying a simple web application with MongoDB using:

Dockerfile (manual containerization)

Docker Compose (multi-container setup)

Kubernetes (container orchestration)


├── README.md                   # Project documentation  
├── withDockerCompose/          # Deployment using Docker Compose  
│   ├── Dockerfile              # Web app Dockerfile  
│   ├── Jenkinsfile             # Jenkins pipeline  
│   ├── docker-compose.yaml     # Docker Compose setup  
│   ├── index.js                # Simple Node.js web application  
│   ├── mongodb/                # MongoDB setup  
│   │   ├── Dockerfile          # MongoDB Dockerfile  
│   │   └── init.js             # MongoDB initialization script  
│   └── package.json            # Node.js dependencies  
├── withDockerfile/             # Deployment using Docker  
│   ├── (same structure as above)  
└── withk8/                     # Deployment using Kubernetes  
    ├── k8s/                    # Kubernetes YAML manifests  
    │   ├── mongodb-deployment.yaml  # MongoDB Deployment  
    │   ├── web-deployment.yaml      # Web app Deployment  
    │   ├── withk8mongoSF.yaml       # Stateful MongoDB Deployment  
    │   └── withk8ns.yaml            # Namespace setup  



