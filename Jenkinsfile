
    
pipeline{
    agent any
    stages{        
        
        
         
        stage ('Build and Test')
        {
            steps{
                    sh "mvn clean install"
            }
        }
         
        stage('Code Quality')
        {
             environment {
                scannerHome=tool 'sonar scanner'
            }
             steps{
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'Hemant_Sonar_Cred', usernameVariable: 'USER', passwordVariable: 'PASS']])
                 {
                     sh "mvn $USER:$PASS -Dsonar.host.url=http://18.224.155.110:9000"
                 }
             }
         }
          stage ('Uploading Artifact to Nexus'){
            steps{
             withCredentials([usernamePassword(credentialsId: 'sudipa_nexus', passwordVariable: 'pass', usernameVariable: 'user')])
             {
                 sh label: '', script: 'curl -u $user:$pass --upload-file target/xfs-0.0.1-SNAPSHOT.war http://18.224.155.110:8081/nexus/content/repositories/devopstraining/Backend_XFS/xfs-0.0.1-SNAPSHOT.war'
               }
          }
        }
        
      stage ('Deploying War File'){
             steps{
                  withCredentials([usernamePassword(credentialsId: 'tomcat_ashish', passwordVariable: 'pass', usernameVariable: 'userId')])
                  {
        
                     sh 'curl -u  $userId:$pass  http://ec2-13-232-255-41.ap-south-1.compute.amazonaws.com:8080/manager/text/undeploy?path=/Backend_XFS'
                     sh  'curl -u  $userId:$pass --upload-file target/xfs-0.0.1-SNAPSHOT.war  http://ec2-13-232-255-41.ap-south-1.compute.amazonaws.com:8080/manager/text/deploy?config=file:/var/lib/tomcat8/xfs-0.0.1-SNAPSHOT.war\\&path=/Backend_XFS'
                 }
             }
    
         }
    }
         post{
   success {
     sh 'curl -H "Content-Type: application/json" -X POST -d \'{"id":'${JOB_NAME}',"bNumber":'${BUILD_NUMBER}',"bUrl":'${BUILD_URL}',"buildStatus":"SUCCESS"}\'  http://ec2-13-232-255-41.ap-south-1.compute.amazonaws.com:8080/Backend_XFS/postKSR'
   }
         failure {
      sh 'curl -H "Content-Type: application/json" -X POST -d \'{"id":'${JOB_NAME}',"bNumber":'${BUILD_NUMBER}',"bUrl":'${BUILD_URL}',"buildStatus":"FAILURE"}\'  http://ec2-13-232-255-41.ap-south-1.compute.amazonaws.com:8080/Backend_XFS/postKSR'
    
         }
}

}
       
    


   
