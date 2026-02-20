pipeline {
    agent any

    tools {
        maven 'Maven3'

    }

    environment {
            PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"

            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'amirdirin/week6_demotest1'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest'
        }

    stages {
        stage('checkout scm') {
             steps {
                 git 'https://github.com/ADirin/TestDemo_week6.git'
             }

        }

        stage ('build job: ') {
            steps {
                bat 'mvn clean install'

            }
        }

        stage('') {
            steps {
                bat 'mvn test'

            }
        }

        stage('code coverage') {
            steps {
               bat 'mvn jacoco:report'
            }
        }


        stage('Publish Test Results') {
             steps {
                junit '**/target/surefire-reports/*.xml'
             }
        }
        stage('Publish Coverage Report') {
              steps {
                 jacoco()
              }
        }
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG% .'
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}", usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    bat '''
                        docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                        docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%
                    '''
            }
        }

    }
}