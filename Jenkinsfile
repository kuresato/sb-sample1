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
        stage('Analyze') {
            steps {
                //script {
                //    def sonarqubeScannerHome = tool name: 'sonar-3.0.3', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                //    echo "${sonarqubeScannerHome}"
                //    sh "ls -la ${sonarqubeScannerHome}/bin"
                //    sh "${sonarqubeScannerHome}/bin/sonar-scanner --version"
                //}

                //sh 'mvn -Dsonar.host.url=${SONAR_URL} -Dmaven.test.failure.ignore=true clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar'
                sh 'mvn sonar:sonar'
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
