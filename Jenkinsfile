pipeline {
    agent any
    
    stages {
        stage('Checkout repository') {
            steps {
                echo "Checking out..."
                git branch: 'develop',
                    credentialsId: '62d49d29-e14f-4eaa-be09-39305222a01d',
                    url: 'https://github.com/Testers-of-JavaScript/JS-Testing-Capgemini.git'
            }
        }
        
    }
}
