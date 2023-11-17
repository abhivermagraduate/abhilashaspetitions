pipeline {
    agent any
    stages {
        stage ('GetProject') {
            steps {
git branch: 'main', url:
'https://github.com/abhivermagraduate/abhilashaspetitions.git'
            }
        }
        stage ('build') {
            steps {
                sh 'mvn clean:clean'
                sh 'mvn dependency:copy-dependencies'
                sh 'mvn compiler:compile'
            }
        }
stage ('Package') {
            steps {
                sh 'mvn package'
            }
        }

stage ('Archive') {
            steps {
            archiveArtifacts allowEmptyArchive: true,
                artifacts: '**/CT5171_abhilashaspetitions*.war'
            }
        }
 stage ('Deploy')
        {
            steps {
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker rm -f "myappcontainer" || true'
                sh 'docker run --name "myappcontainer" -p 9090:8080 --detach myapp:latest'
            }
        }
}
}
