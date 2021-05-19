pipeline {
    agent any


    stages {
        stage('拉取代码') {
            steps {
               checkout([$class: 'GitSCM', branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: 'a6271225-f052-4eef-8204-fc9a7f9a40f6', url: 'https://github.com/ZZZCrocodile/webDome']]])
            }
        }

        stage('编译构建'){
            steps{
                sh 'mvn clean package'

            }
        }

         stage('部署'){
            steps{
                deploy adapters: [tomcat8(credentialsId: '95d34562-fd9d-4c48-88b7-69ea1a6b0281', path: '', url: 'http://129.211.172.55:8080/')], contextPath: null, war: 'target/*.war'
            }
        }
    }

    post{
        always{
            emailext(
                subject:'构建通知：${PROJECT_NAME} - Build # $ {BUILD_NUMBER} - ${BUILD_STATUS}!',
                body:'${FILE,path="email.html"}',
                to:''
            )
        }
    }
}
