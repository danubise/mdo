import hudson.model.*
import hudson.AbortException
import hudson.console.HyperlinkNote
import java.util.concurrent.CancellationException
import org.jenkinsci.plugins.workflow.steps.FlowInterruptedException
import hudson.AbortException
import hudson.model.*
import com.cloudbees.groovy.cps.NonCPS

println "hello world from groovy script"

//shell('echo Hello World!')
@NonCPS
def call(body) {
    pipeline {
        agent any
        stages {
            stage("pull-updates-to-dev") {
                steps {
                    sshagent(credentials: ['sshkey']) {
                        sh 'ssh -o StrictHostKeyChecking=no -l root 195.158.9.92 uname -a'
                    }
                    sleep 2
                }
            }
        }
    }
}
