# 오류 메세지
### 1. Lint found fatal errors while assembling a release target

`android {
    lintOptions {
        checkReleaseBuilds false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        abortOnError false
    }
}`

- 원인 : xml lint 오류

- 해결 : app/build/reports/lint-results-release-fatal.html 내용 참고

