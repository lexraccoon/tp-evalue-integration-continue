pipeline {
    agent any
    tools {
        maven 'maven'
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
               git branch: 'main', url: 'https://github.com/ziberty/GoSecuri.git'
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
        stage('Send') {
            steps {
                sh 'scp -i ~/.ssh/id_rsa -r /var/jenkins_home/workspace/MSPR_APPLI/web gosecuri@192.168.64.133:/var/www/gosecuri_web'
            }
        }
    }
}
