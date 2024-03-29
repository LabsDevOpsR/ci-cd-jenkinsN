pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}
pipelineJob('ride-managment-job') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/LabsDevOpsR/devopslab1.git'
                    }
                    branch 'master'
                }
            }
        }
        pipelineJob('park-management-docker-job') {
            definition {
                cpsScm {
                    scm {
                        git {
                            remote {
                                url 'https://github.com/LabsDevOpsR/devopslab1.git'
                            }
                            branch 'master'
                            scriptPath('Jenkinsfile-docker')
                        }
                    }
                }
            }
        }
    }
}
