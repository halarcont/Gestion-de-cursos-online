pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Construir la imagen Docker
                sh 'docker build -t mi-microservicio .'
            }
        }

        stage('Test'){
            steps{
                // Aquí podrías ejecutar pruebas
                sh 'echo "Pruebas pasadas"'
            }
        }

        stage('Deploy') {
            steps {
                // Desplegar el microservicio
                sh 'docker run -d -p 8080:8080 eureka-server'
            }
        }
    }
}
