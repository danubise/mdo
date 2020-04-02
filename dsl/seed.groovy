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