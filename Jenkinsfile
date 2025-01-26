pipeline {
    agent any

    tools {
        maven "MAVEN_HOME"
    }

    stages {
      stage('Checkout') {
            steps {
                // Clone the repository
                git branch: 'master', url: 'https://github.com/Siddivinayak-k/WiproCapstoneProject.git'
            }
        }
        
        stage('Build and Test') {
          steps {
              // Run Maven command to test
              sh 'mvn clean test'
          }
        }
    }
    post {
        // If Maven was able to run the tests, even if some of the test
        // failed, record the test results and archive the jar file.
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
        }
    }
}
