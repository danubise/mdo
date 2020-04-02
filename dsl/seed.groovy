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

job('Email/CleanTrash'){
    scm {
        git(gitUrl, 'master')
    }
}