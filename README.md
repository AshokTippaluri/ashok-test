# ashok-test

An repo for learning purpose
---------------------------------------------------------------------------------------------------------


# 🚀 Git Learning Project: Docker, Docker Compose & Kubernetes  

This project is part of my learning journey to understand containerization and deployment using Docker, Docker Compose, and Kubernetes. The goal is to explore how applications evolve from simple containerized setups to fully managed orchestration in Kubernetes.

Each approach includes a Node.js web application with MongoDB, starting with manual Dockerfile-based deployments, progressing to Docker Compose for multi-container management, and finally deploying in Kubernetes for scalability. Additionally, Jenkins integration is included to automate CI/CD pipelines.

This repository serves as a hands-on practice space for mastering DevOps concepts and improving deployment workflows. 🚀



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
    │   ├── withk8mongoSF.yaml       # Stateful MongoDB Deployment  working
    │   └── withk8ns.yaml            # Namespace setup  






With Docker compose



![image](https://github.com/user-attachments/assets/caf03772-3e25-42dd-a31e-aef4bcd8ef2b)


with dockerfile

![image](https://github.com/user-attachments/assets/06054109-a676-47ad-9e5a-13a1fa435684)


