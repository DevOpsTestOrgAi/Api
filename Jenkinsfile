pipeline {
    agent any

    environment {
        registryName = "acr017h3w873rnwuqwuh/scraping-api"
        registryCredential = 'ACR'
        dockerImage = ''
        registryUrl = 'acr017h3w873rnwuqwuh.azurecr.io'
        mvnHome = tool name: 'maven', type: 'maven'
        mvnCMD = "${mvnHome}/bin/mvn "
  
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Clean workspace before checking out the code
                    deleteDir()

                    // Checkout the code from the specified Git repository and branch
                    checkout([$class: 'GitSCM',
                              branches: [[name: 'main']],
                              doGenerateSubmoduleConfigurations: false,
                              extensions: [[$class: 'CleanBeforeCheckout'], [$class: 'RelativeTargetDirectory', relativeTargetDir: 'Api']],
                              submoduleCfg: [],
                              userRemoteConfigs: [[url: 'https://github.com/DevOpsTestOrgAi/Api.git']]])
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    dir('Api') {
                         sh "${mvnCMD} clean install"
                    }
                }
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                script {
                    withSonarQubeEnv('Sonar') {
                        dir('Api'){
                        sh "${mvnCMD} sonar:sonar"
                        }
                    }
                    slackSend message: 'AI-Extension backend api  : sonar analysis completed  check http://20.228.254.202:9000/'
                }
            }
        }
       
        stage('Build Docker image') {
            steps {
                script {
                     dir('Api') {
                        // Assuming Dockerfile is present in the repository
                        dockerImage = docker.build(registryName, "-f Dockerfile .")
                    }
                }
            }
        }

        stage('Push Image to ACR ') {
            steps {
                script {
                    docker.withRegistry("http://${registryUrl}", registryCredential) {
                        dockerImage.push("latest")
                    }
                }
                slackSend message: 'AI-Extension backend api  : New Artifact was Pushed to ACR Repo'
            }
        }
    }
}
/*
node {
    def repourl = "${REGISTRY_URL}/${PROJECT_ID}/${ARTIFACT_REGISTRY}"
    def mvnHome = tool name: 'maven', type: 'maven'
    def mvnCMD = "${mvnHome}/bin/mvn "

    stage('Checkout'){
        git branch: 'main',
            credentialsId: 'git',
            url: 'https://github.com/medXPS/doctorService.git'
    }

    stage('Build and Push Image'){
            withCredentials([file(credentialsId: 'gcp', variable: 'GC_KEY')]){
            sh("gcloud auth activate-service-account --key-file=${GC_KEY}")
            sh 'gcloud auth configure-docker us-west4-docker.pkg.dev'
            sh "${mvnCMD} clean install jib:build -DREPO_URL=${REGISTRY_URL}/${PROJECT_ID}/${ARTIFACT_REGISTRY}"
        }
    }

    stage('Deploy') {
        sh "sed -i 's|IMAGE_URL|${repourl}|g' K8s/deployment.yaml"
        step([$class: 'KubernetesEngineBuilder',
            projectId: env.PROJECT_ID,
            clusterName: env.CLUSTER,
            location: env.ZONE,
            manifestPattern: 'K8s/deployment.yaml',
            credentialsId:env.PROJECT_ID,

        ])
    }
}
//my  jenkins file
*/