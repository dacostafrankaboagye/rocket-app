pipeline {
	agent any

    environment {
		MY_ENV_VAR = 'ci for my rocket app'
    }

    stages {
		stage('Checkout') {
			steps {
				script {
					def gitRepoUrl = 'https://github.com/dacostafrankaboagye/rocket-app.git'

                    checkout([$class: 'GitSCM',
                        branches: [[name: '*/main']],
                        userRemoteConfigs: [[url: gitRepoUrl]],
                        extensions: [[$class: 'CleanBeforeCheckout'], [$class: 'CloneOption', noTags: false, shallow: true, depth: 1]]
                    ])
                }
            }
        }

        stage('Build') {
			steps {
				//sh './mvnw clean package'
				sh '''
               	ls
               	mvn clean package
               	echo "=============================="
                echo "============DONE WITH THE BUILD"
                '''
            }
        }

        stage('Test') {
			steps {
				sh '''
				echo "LISTING THE CONTENT OF THE DIR"
				ls
               	mvn test
               	echo "=============================="
				echo "=============DONE WIH THE TEST"
				'''
            }
        }

        stage('Deploy') {
			steps {
				sh 'echo "Value of ENV Variable is $MY_ENV_VAR"'
            }
        }
    }

    post {
		success {
			echo 'Pipeline succeeded!'
        }
        failure {
			echo 'Pipeline failed!'
        }
    }
}
