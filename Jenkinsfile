pipeline {
    agent any

    stages {
        stage('Checkout from GitHub') {
            steps {
                echo 'Pulling...'
                git branch: 'mahdi',
                    url: 'https://github.com/SeifEddineAmara/projet-devops.git'
            }
        }
        stage('Maven Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Artifact Construction') {
            steps {
                echo 'ARTIFACT Construction...'
                sh 'mvn package -Dmaven.test.skip=true -P test-coverage'
            }
        }

        stage('Unit Tests') {
            steps {
                echo 'Launching Unit Tests..'
                sh 'mvn test'
            }
        }

        stage('Maven SonarQube') {
            steps {
                // Add steps to run SonarQube analysis here
            }
        }

        stage('Publish To Nexus') {
            steps {
                // Add steps to publish artifacts to Nexus here
            }
        }

        stage('Building back Image') {
            steps {
                // Add steps to build a Docker image here
            }
        }

        stage('Building front Image') {
            steps {
                // Add steps to build a Docker image here
            }
        }

        stage('Deploy Docker Image') {
            steps {
                // Add steps to deploy the Docker image here
            }
        }

        stage('Docker Compose') {
            steps {
                // Add steps to build a Docker image here
            }
        }

        stage('Email Notification') {
            steps {
                // Add steps to send email notifications here
            }
        }
    }
}
