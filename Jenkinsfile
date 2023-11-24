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

// commented out to reduce build and deploy time.
// stage ('Archive') {
//           steps {
//            archiveArtifacts allowEmptyArchive: true,
//               artifacts: '**/abhilashaspetitions*.war'
//           }
//       }
        
  stage ('Approval')
        {
            steps {
            	input 'Please approve to proceed with deployment'
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
