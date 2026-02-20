pipeline {
    agent any

    tools {
        maven 'Maven3'

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


    }
}