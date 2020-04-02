import hudson.model.*
import hudson.AbortException
import hudson.console.HyperlinkNote
import java.util.concurrent.CancellationException

println "hello world from groovy script"

shell('echo Hello World!')

pipeline {
    agent any
    stages {
        stage("pull-updates-to-dev"){
            steps {
                sshagent (credentials: ['sshkey']) {
                    sh 'ssh -o StrictHostKeyChecking=no -l root 195.158.9.92 uname -a'
                }
                sleep 2
            }
        }
    }
}
