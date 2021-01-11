# Hilt를 사용한 종속 항목 삽입
1. @HiltAndroidApp
- ```
  @HiltAndroidApp 
  class App : Application() {...} 
  ```
2. 필드 주입
- ```
  @AndroidEntryPoint
  class ExFragment : Fragment() {
    @Inject
    lateinit var exClass: ExClass
  ```
3. 생성자 주입
- ```
  class ExRepository @Inject constructor(private val exService: ExService)
  ```
4. ViewModel 주입
- ```
  class ExViewModel @ViewModelInject constructor(
    private val exRepository: ExRepository,
  )  
  ```
5. @Module, @InstallIn
   외부 라이브러리의 클래스와 같이 소유하지 않은 유형 생성자 주입
- ```
  @Module
  @InstallIn(ApplicationComponent::class)
  object ExModule {
  
  @Provides
  @Singleton
    fun provideExService(ex: Ex): ExService {
      
    }
  ```
- ```
   
  *중복 인스턴스 구분
  @Provides
  @Singleton
  @Named("external")
  fun provideExternalEx (ExClient: ExClient): ExternalEx {
    ...
  }  
  
  ->
  
  fun provideExService(@Named("external") externalEx: ExternalEx) {
    ...
  }    
  ```
6. @EntryPoint
   Hilt가 지원하지 않는 클래스에 필드 삽입
- ```
  @EntryPoint
  @InstallIn(ApplicationComponent::class)
  interface ExListener {
    fun exMethod(message: String)
  }
  
  ->
  
  @AndroidEntryPoint
  class ExFragment : Fragment() {
    val hiltEntryPoint = EntryPointAccessors.fromApplication(appContext, ExListener::class.java)
  }
   ```
