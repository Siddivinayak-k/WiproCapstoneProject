pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven 3.9.9', type: 'maven'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Siddivinayak-k/WiproCapstoneProject.git'
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: 'Maven 3.9.9') {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'Test Report'
                ])
            }
        }

        stage('Deploy to Staging') {
            steps {
                sh './scripts/deploy-to-staging.sh'
            }
        }
    }

    post {
        success {
            mail to: 'your-email@example.com',
                subject: 'Build Successful',
                body: 'The build and deployment were successful!'
        }

        failure {
            mail to: 'your-email@example.com',
                subject: 'Build Failed',
                body: 'The build or deployment failed. Please check Jenkins for details.'
        }
    }
}
