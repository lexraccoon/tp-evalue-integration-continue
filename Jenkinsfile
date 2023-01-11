pipeline {
    agent any
    tools {
        maven 'maven'
    }
    environment{
        imageName = "gosecuri"
        registryCredentials = "nexus"
        registry = "localhost:8085"
        dockerImage = ""
        
    }
    stages {
        stage('init') {
            steps {
                dir("/var/jenkins_home/workspace") {
                    sh 'rm -rf MSPR_APPLI'
                }
            }
        }
        stage('Recuperation des sources') {
            steps {
               git branch: 'main', url: 'https://github.com/lexraccoon/tp-evalue-integration-continue.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Execute') {
            steps {
                dir("target") {
                    sh 'java -jar goSecuri-1.0.jar'
                }
            }
        }
        stage('Test') {
            steps {
                dir("target") {
                    sh 'mv ../src .'
                    sh 'mv ../pom.xml .'
                    sh 'mvn test'
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        
        // Building Docker images
        stage('Building image') {
          steps{
            script {
                sh 'ls'
                dockerImage = docker.build imageName
            }
          }
        }

        // Uploading Docker images into Nexus Registry
        stage('Uploading to Nexus') {
         steps{  
             script {
                 docker.withRegistry( 'http://'+registry, registryCredentials ) {
                 dockerImage.push('latest')
              }
            }
          }
        }

        // Stopping Docker containers for cleaner Docker run
        stage('stop previous containers') {
            steps {
                sh 'docker ps -f name=myphpcontainer -q | xargs --no-run-if-empty docker container stop'
                sh 'docker container ls -a -fname=myphpcontainer -q | xargs -r docker container rm'
            }
        }

        stage('Docker Run') {
           steps{
                script {
                    sh 'docker run -d -p 80:80 --rm --name myphpcontainer ' + registry + imageName
                }
            }
        }   
    }
}
