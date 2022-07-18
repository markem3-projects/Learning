pipeline {
    agent any
    
    stages {
        stage('Checkout repository') {
            steps {
                echo "Checking out..."
                git branch: 'develop',
                    credentialsId: '940dd96e-2ac5-44b4-8030-e561a9991a87',
                    url: 'https://github.com/Testers-of-JavaScript/JS-Testing-Capgemini.git'
            }
        }
        
    }
}
