def gitUrl = "https://github.com/danubise/mdo.git"

job('test-job') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        println("hello world")
    }
}

job('example') {
    logRotator(-1, 10)
    jdk('Java 8')
    scm {
        github('jenkinsci/job-dsl-plugin', 'master')
    }
    triggers {
        githubPush()
    }
    steps {
        gradle('clean build')
    }
    publishers {
        archiveArtifacts('job-dsl-plugin/build/libs/job-dsl.hpi')
    }
}

folder('Email') {
    displayName('Email server pipelines')
    description('All pipeline that need to execute on email server')
}

folder('voip') {
    displayName('voip server pipelines')
    description('All pipeline that need to execute on voip server')
}

job('Email/CleanTrash') {
    scm {
        git(gitUrl, 'master')
    }
    steps {
        shell('echo Hello World!')
        sshagent (credentials: ['sshkey']) {
            sh 'ssh -o StrictHostKeyChecking=no -l root 195.158.9.92 uname -a'
        }
    }
}