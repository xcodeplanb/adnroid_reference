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

### 1. compile_and_runtime_not_namespaced_r_class_jar ... because it is being used by another process

- 원인 : being used by another process

- 해결 : 윈도우 cmd -> taskkill /im java.exe /f
