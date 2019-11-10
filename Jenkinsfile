pipeline {
    agent any

    stages {
        stage ('Compile') {

            steps {
                    sh 'mvn clean compile'
            }
        }

        stage ('Testing') {

            steps {
                    sh 'mvn test'
            }
        }


        stage ('Deployment Stage') {
            steps {
                    sh 'mvn deploy'
            }
        }
    }
}