![Logo](mwm-3-kotlin-1/presentation/logo-1.png)

#### <span style="text-transform: none">Kotlin - 2/2</span>

<span style="color:gray; font-size:0.6em;">Kotlin </span> <span style="color: #00B8D4; font-size:0.6em;">1.2.60</span>
<br/>
<span style="color:gray; font-size:0.5em;">17-08-2018</span>
<br/><br/>
<span style="color:gray; font-size:0.6em;">Github </span> <span style="color: #00B8D4; font-size:0.5em;">Mercandj/presentation</span>
<br/>
<span style="color:gray; font-size:0.4em;">Frédéric Torcheux. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">bowserf</span>
<br/>
<span style="color:gray; font-size:0.4em;">Jonathan Mercandalli. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">Mercandj</span>


Note:

- Version of kotlin is important, all result could change in next / previous version
- Find the presentation and source [here](https://github.com/Mercandj/presentation)

---

### Equality

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Equality</span>

```kotlin
a == b
```

```kotlin
a?.equals(b) ?: (b === null)
```

Note:

- if `a == null`, check is b is null
- Means you can compare strings with `==`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Equality</span> <span style="text-transform: none; font-size:0.8em;"> with string</span>

<br/>

```kotlin
fun equals(str1: String?, str2: String?) = str1 == str2
```

---

### Collection

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Collection</span> <span style="text-transform: none; font-size:0.8em;"> filtering</span>

```kotlin
val users = api.getUsers()
val activeUsersNames = items.filter { 
    it.active
}
adapter.setUsers(activeUsers)
```

---

### Nullity with let

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;"> with let</span>

<br/>

Java

```java
if (currentUser != null) {
    titleTextView.setText(currentUser.name)
    subtitleTextView.setText(currentUser.description)
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;"> with let</span>

<br/>

Koltin

```kotlin
currentUser?.let {
    titleTextView.text = it.name
    subtitleTextView.text = it.description
}
```

---

### Extension function

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Extension</span> <span style="text-transform: none; font-size:0.8em;"> function</span>

```kotlin
fun Activity.hideKeyboard(): Boolean {
    val view = currentFocus
    view?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) 
                as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(view.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS)
    }
    return false
}
```

---


### Lazy

Note:

- Feature that lazy create object at access time

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
private val downloadManagerInternal = DownloadModule().createDownloadManager(context)
```

Note:

- Instead of that

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
private val downloadManagerInternal by lazy {
    DownloadModule().createDownloadManager(context)
}
```

Note:

- Create a DownloadManager only once at the downloadManagerInternal access
- Next slide will show where this feature could be useful

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class ApplicationGraph(context: Context) {

    private val downloadManagerInternal = DownloadModule().createDownloadManager(context)

    companion object {

        @JvmStatic
        @SuppressLint("StaticFieldLeak")
        private var graph: ApplicationGraph? = null

        @JvmStatic
        fun initialize(context: Context) {
            if (graph == null) { graph = ApplicationGraph(context.applicationContext) }
        }

        @JvmStatic
        fun getDownloadManager() = graph!!.downloadManagerInternal
    }
}
```

Note:

- Here download manager created at init() call
- We want to lazy create the manage at the getter first call

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class ApplicationGraph(context: Context) {

    private val downloadManagerInternal by lazy {
        DownloadModule().createDownloadManager(context)
    }

    companion object {

        @JvmStatic
        @SuppressLint("StaticFieldLeak")
        private var graph: ApplicationGraph? = null

        @JvmStatic
        fun initialize(context: Context) {
            if (graph == null) { graph = ApplicationGraph(context.applicationContext) }
        }

        @JvmStatic
        fun getDownloadManager() = graph!!.downloadManagerInternal
    }
}
```

Note:

- Create a DownloadManager only once at the downloadManagerInternal access

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
private val downloadModuleInternal by lazy {
    DownloadModule()
}

private val downloadManagerInternal by lazy {
    downloadModuleInternal.createDownloadManager(context)
}

private val downloadStorageInternal by lazy {
    downloadModuleInternal.createDownloadStorage(context)
}
```

Note:

- lazy is thread safe by default to avoid that the lambda gets computed more than once

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity() {

    private val downloadManager by lazy(LazyThreadSafetyMode.NONE) { 
        ApplicationGraph.getDownloadManager()
    }

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<View>(R.id.activity_home_button).setOnClickListener {
            downloadManager.download()
        }	
    }
}
```

Note:

- Avoid synchronized

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class ApplicationGraph(context: Context) {

    private val downloadManagerLazyInternal = lazy { 
        DownloadModule().createDownloadManager(context)
    }

    companion object {

        @JvmStatic
        @SuppressLint("StaticFieldLeak")
        private var graph: ApplicationGraph? = null

        @JvmStatic
        fun initialize(context: Context) {
            if (graph == null) { graph = ApplicationGraph(context.applicationContext) }
        }

        @JvmStatic
        fun getDownloadManagerLazy() = graph!!.downloadManagerLazyInternal
    }
}
```

Note:

- No more `by lazy` here, instead `= lazy`
- Return is `Lazy<T>`
- `getDownloadManagerLazy(): Lazy<DownloadManager>`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity(), HomeActivityContract.Screen {

    private userAction = createUserAction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        findViewById<View>(R.id.activity_home_button).setOnClickListener {
            userAction.onButtonClicked()
        }   
    }

    private fun createUserAction(): HomeActivityContract.UserAction {
        val downloadManagerLazy = ApplicationGraph.getDownloadManagerLazy()
        return HomeActivityPresenter(this, downloadManagerLazy)    
    }
}
```

Note:

- 

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivityPresenter(
        private val screen: HomeActivityContract.Screen,
        private val downloadManagerLazy: Lazy<DownloadManager>
) : HomeActivityContract.UserAction {

    override fun onButtonClicked() {
        downloadManagerLazy.value.download()
    }
}
```

Note:

-  

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```java
/**
 * Represents a value with lazy initialization.
 *
 * To create an instance of [Lazy] use the [lazy] function.
 */
public interface Lazy<out T> {
    /**
     * Gets the lazily initialized value of the current Lazy instance.
     * Once the value was initialized it must not change during the rest of lifetime of this Lazy instance.
     */
    public val value: T

    /**
     * Returns `true` if a value for this Lazy instance has been already initialized, and `false` otherwise.
     * Once this function has returned `true` it stays `true` for the rest of lifetime of this Lazy instance.
     */
    public fun isInitialized(): Boolean
}

```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```java
private class SynchronizedLazyImpl<out T>(initializer: () -> T, lock: Any? = null) : Lazy<T>, Serializable {
    private var initializer: (() -> T)? = initializer
    @Volatile private var _value: Any? = UNINITIALIZED_VALUE
    private val lock = lock ?: this
    override val value: T
        get() {
            val _v1 = _value
            if (_v1 !== UNINITIALIZED_VALUE) {
                @Suppress("UNCHECKED_CAST")
                return _v1 as T
            }
            return synchronized(lock) {
                val _v2 = _value
                if (_v2 !== UNINITIALIZED_VALUE) {
                    @Suppress("UNCHECKED_CAST") (_v2 as T)
                } else {
                    val typedValue = initializer!!()
                    _value = typedValue
                    initializer = null
                    typedValue
                }
            }
        }
    override fun isInitialized(): Boolean = _value !== UNINITIALIZED_VALUE
    override fun toString(): String = if (isInitialized()) value.toString() else "Lazy value not initialized yet."
    private fun writeReplace(): Any = InitializedLazyImpl(value)
}
```

---


### Bind

Note:

- Bind R.id with the object ref

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> var</span>

```kotlin
class HomeActivity : AppCompatActivity(), HomeActivityContract.Screen {

    private var homeView: HomeView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeView = findViewById(R.id.activity_home_home_view)
    }

    override fun navigateToSettings() {
        homeView!!.navigateToSettings()
    }
}
```

Note:

- Not great
- 2 lines to add view (declaration + affectation)
- Nullity check

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> lateinit var</span>

```kotlin
class HomeActivity : AppCompatActivity(), HomeActivityContract.Screen {

    private lateinit var homeView: HomeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeView = findViewById(R.id.activity_home_home_view)
    }

    override fun navigateToSettings() {
        homeView.navigateToSettings()
    }
}
```

Note:

- Not great
- 2 lines to add view (declaration + affectation)
- No nullity check

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

```kotlin
private val homeView: HomeView by bind(R.id.activity_home_home_view)
```

Note:

-  

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

```kotlin
private fun <T : View> bind(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
}
```

Note:

- https://medium.com/@quiro91/improving-findviewbyid-with-kotlin-4cf2f8f779bb
- Exist the same things for the view but in View affectation could in a lot of time be done in the constructor

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

```kotlin
class HomeActivity : AppCompatActivity(), HomeActivityContract.Screen {

    private val homeView: HomeView by bind(R.id.activity_home_home_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun navigateToSettings() {
        homeView.navigateToSettings()
    }

    private fun <T : View> bind(@IdRes res: Int): Lazy<T> {
        @Suppress("UNCHECKED_CAST")
        return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
    }
}
```

Note:

-  

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

```kotlin
fun <T : View> Activity.bind(@IdRes res: Int): Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(res) }
}
```

Note:

- Extension function of `Activity` -> to-discuss

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

```kotlin
class HomeView : @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val view = View.inflate(context, R.layout.view_home, this)
    private val title: TextView = view.findViewById(R.id.view_home_title)
}
```

Note:

-  

---

### Coroutines

Note:

- Replace Threads, AsyncTasks...

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Coroutines</span> <span style="text-transform: none; font-size:0.8em;"> deps</span>


```gradle
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutines_version"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutines_version"
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Coroutines</span> <span style="text-transform: none; font-size:0.8em;"> use</span>


```kotlin
override fun requestPlaylists(playlistIds: List<String>) {
    launch(CommonPool) {
        val playlistsResult = playlistManager.getPlaylistsSync(playlistIds)
        launch(UI) {
            notifyListeners(playlistsResult)
        }
    }
}
```

---

### Kotlin 1.3-m1

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Kotlin 1.3-m1</span> <span style="text-transform: none; font-size:0.8em;"> when</span>

```kotlin
when (val response = executeRequest()) {
    is Success -> response.body
    is HttpError -> throw HttpException(response.status)
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Kotlin 1.3-m1</span> <span style="text-transform: none; font-size:0.8em;"> interface</span>

```kotlin
interface DownloadManager {
    companion object {
        @JvmField
        private val instance = DownloadManagerImpl()

        @JvmStatic
        fun getInstance(): DownloadManager = instance
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Sources</span>

- https://medium.com/@quiro91/improving-findviewbyid-with-kotlin-4cf2f8f779bb
- https://blog.jetbrains.com/kotlin/2018/07/see-whats-coming-in-kotlin-1-3-m1
- https://savvyapps.com/blog/kotlin-tips-android-development


