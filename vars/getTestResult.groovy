@NonCPS
def call() {
    def testActions = currentBuild.rawBuild.getActions(hudson.tasks.junit.TestResultAction.class)

    if (testActions != null && testActions.size() > 0) {
        def totalCount = testActions.get(0).getTotalCount()
        def failCount = testActions.get(0).getFailCount()
        def skipCount = testActions.get(0).getSkipCount()
        def passCount = totalCount - failCount - skipCount

	[totalCount, failCount, skipCount]
    }
}
