pipeline {
    agent any 

    triggers {
        pollSCM('* * * * *')
    }

    // Got permission denied while trying to connect to the Docker daemon socket at unix.
    // sudo usermod -a -G docker jenkins
    // restart jenkins server ->  sudo service jenkins restart
    stages {
        
        stage('Maven Compile') {
            steps {
                echo '----------------- This is a compile phase ----------'
                sh 'mvn clean compile'
            }
        }
                
        stage('Maven Build') {
             steps {
                echo '----------------- This is a build phase ----------'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo '----------------- This is a build docker image phase ----------'
                sh '''
                    docker image build -t onestopmedishop-web .
                '''
            }
        }

        stage('Docker Deploy') {
            steps {
                echo '----------------- This is a docker deploment phase ----------'
                sh '''
                 (if  [ $(docker ps -a | grep onestopmedishop-web | cut -d " " -f1) ]; then \
                        echo $(docker rm -f onestopmedishop-web); \
                        echo "---------------- successfully removed onestopmedishop-web ----------------"
                     else \
                    echo OK; \
                 fi;);
            docker container run  --network onestopmedishop-web-network --restart always --name onestopmedishop-web -p 8081:8081 -d onestopmedishop-web
            '''
            }
        }
    }
}