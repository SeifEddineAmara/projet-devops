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
        stage('Unit Tests') {
            steps {
                echo 'Launching Unit Tests..'
                sh 'mvn test'
            }
        }
    }
}
