pipeline {
    agent any

    stages {
        stage('Checkout from GitHub') {
            steps {
                               git branch: 'mahdi', credentialsId: 'mahdidev', url: 'https://github.com/SeifEddineAmara/projet-devops.git'
            }
        }
        stage('Maven Clean') {
            steps {
                 def mavenHome = tool name: "Maven-3.8.6", type: "maven"
                 def mavenCMD = "${mavenHome}/bin/mvn"
                 sh "${mavenCMD} clean package"
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
