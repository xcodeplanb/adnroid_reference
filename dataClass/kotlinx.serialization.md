# kotlinx.serialization

### 멀티플랫폼 지원

#### kotlinx.serialization 라이브러리는 자바 (JVM), 자바스크립트, 네이티브 (Kotlin/Native)와 같이 다양한 플랫폼을 지원합니다. 따라서. 직렬화 (Serialization)를 담당하는 코드를 각 플랫폼별로 따로 작성할 필요 없이 공용 라이브러리에 구현할 수 있습니다.

1. data class

- ```
  @Serializable
  data class Project(
      @SerializedName("name")
      val name: String,
      val owner: User, 
      val language: String = "Kotlin"
  )
  ```

[^]: kotlinx.serialization` 라이브러리를 사용하면 `inputString`내 JSON 문자열이 `language` 프로퍼티를 포함하고 있지 않음을 확인하고, `null` 대신 기본값을 대입합니다. 따라서 개발자가 의도한 대로 파싱이 수행되는 것을 확인할 수 있습니다

2. build.gradle (root)

- ```
  buildscript {
      repositories {
          ...
      }
      dependencies {
          classpath "org.jetbrains.kotlin:kotlin-serialization:1.4.10"
      }
  }
  
  plugins {
      id 'org.jetbrains.kotlin.plugin.serialization' version '1.4.10'
  }
  ```

3. build.gradle (app)

- ```
  apply plugin: 'kotlinx-serialization'
  ...
  implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1"
  implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
  ```

4. Retrofit

- ```
  Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(BASE_URL)
      .addConverterFactory(Json{
          coerceInputValues = true
      }.asConverterFactory("application/json".toMediaType()))
      .build()
  ```