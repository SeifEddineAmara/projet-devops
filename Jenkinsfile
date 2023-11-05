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
        stage('Testing Maven') {
                    steps {
                        sh "mvn -version"
                    }
                }
    }
}
