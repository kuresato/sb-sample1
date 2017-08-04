pipeline {
    agent {
        node {
            label 'maven'
        }
    }
    tools {
        maven 'maven-3.5.0'
    }
    stages {
        stage('Preparation') {
            steps {
                echo 'preparation'
                // git branch: 'master', credentialsId: 'xxxx', url: 'https://xxxxxx/xxxxx/xxxx/xxxx.git'
                // git scm
            }
        }
       stage('Build') {
            steps {
                sh 'mvn -version'
                //sh 'mvn -s ${WORKSPACE}/.m2/settings.xml clean package'
                sh 'mvn clean package'
            }
       }
       stage('Results') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                archive 'target/*.jar'
            }
       }
    }
}
