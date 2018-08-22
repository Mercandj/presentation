![Logo](mwm-3-kotlin-1/presentation/logo-1.png)

#### <span style="text-transform: none">Kotlin - 2/2</span>

<span style="color:gray; font-size:0.6em;">Kotlin </span> <span style="color: #00B8D4; font-size:0.6em;">1.2.60</span>
<br/>
<span style="color:gray; font-size:0.5em;">22-08-2018</span>
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

### Let's rock again with Elvis!

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">If my reference is null, do...</span>

```kotlin
val length = if (b != null) b.length else -1
```

No ternary operator in Kotlin.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Elvis operator</span><span style="text-transform: none; font-size:0.8em;"> ?:</span>

```kotlin
val l = b?.length ?: -1
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Throw with</span><span style="text-transform: none; font-size:0.8em;"> ?:</span>

```kotlin
val l = b?.length ?: throw IllegalArgumentException("b should not be null")
```

---

### Lambda

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lambda</span>

```kotlin
public inline fun <T, R: Comparable<R>> Collection<T>.maxBy(selector: (T) -> R): T?
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">What is that ?</span>

```kotlin
selector: (T) -> R)
```

Note:

- `selector: (T) -> R` is called a function type. It's a function taking a parameter T and return a parameter R.
- Kotlin function are "first class function". We can put it in a variable, send it to a function or have a function returning a function.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">How to call </span> <span style="text-transform: none; font-size:0.8em;"> maxBy</span>
```kotlin
public inline fun <T, R: Comparable<R>> Collection<T>.maxBy(selector: (T) -> R): T?
```

```kotlin
class BookSelector: Function1<Book, Int> {
	override fun invoke(book: Book):Int{
		return book.pageCount
	}
}
val longestBook = library.maxBy(BookSelector())
```

Note:

- https://medium.com/google-developers/kotlin-demystified-understanding-shorthand-lamba-syntax-74724028dcc5
- There are several FunctionN interfaces use to generate lambda up to Function22 (for 22 parameters).

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lambda</span> <span style="text-transform: none; font-size:0.8em;"> easily</span>

```Java
val longestBook = library.maxBy({
    book -> book.pageCount
})
```

Note:

- It's the result of the last expression which is return. Don't use "return"

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lambda</span> <span style="text-transform: none; font-size:0.8em;"> more easily</span>

```Java
val longestBook = library.maxBy({
    it.pageCount
})
```

Note:

- Only one parameter, "it" is the implicit name of the parameter.
- We can remove the "->"

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lambda</span> <span style="text-transform: none; font-size:0.8em;"> even more easily</span>

```Java
val longestBook = library.maxBy{ it.pageCount }
```

Note:

- When lambda is the last parameter, even if there are several, we can move lambda out bracket.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lambda</span> <span style="text-transform: none; font-size:0.8em;"> overhead</span>

```Kotlin
fun highOrderFun(aLambda: () -> Unit) {
	a()
	aLambda()
	b()
}
```
Equivalent in Java :
```java
public void highOrderFun(Function aLambda) {
	a()
	aLambda.invoke()
	b()
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lambda</span> <span style="text-transform: none; font-size:0.8em;"> overhead</span>

```java
public void callingFunction() {
	highOrderFun(new Function() {
		@Override
		public void invoke() {...}
	});
}
```

Note:

- If we call "callingFunction" in a loop, we will create an object each time the function is called.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Inline</span> <span style="text-transform: none; font-size:0.8em;"> to save us</span>

```kotlin
inline fun highOrderFun(aLambda: () -> Unit){...}
fun callingFunction() {
  higherOrderFunction{ print("lambda logic") }
}
```
Equivalent to :
```java
public void callingFunction() {
  a()
  System.out.print("lambda logic")
  b()
}
```

Note:

- Like in C++.
- The code of "highOrderFun" is replace where it's called.
- More code but better performances.
- Can't access to private variables / methods.
- We can by using "internal" visibility and @PublishedApi annotation.

---

### Equality

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Equality</span>

<br/>

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

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Create</span><span style="text-transform: none; font-size:0.8em;"> a list</span>

```kotlin
val list = List<Int>() // don't compile !
```

Because List constructor is :

```kotlin
public inline fun <T> List(size: Int, init: (index: Int) -> T): List<T>
						= MutableList(size, init)
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Create</span><span style="text-transform: none; font-size:0.8em;"> a list</span>

```kotlin
val list = listOf<Int>()
val listWithValues = listOf(1, 2, 3)
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Add element</span><span style="text-transform: none; font-size:0.8em;"> to a list</span>

```kotlin
val list = listOf<Int>()
list.add(1) // don't compile !
```

List is mutable !

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Mutable list</span>

```kotlin
val mutableList = mutableListOf<Int>()
mutableList.add(1)
val mutablelistWithValues = mutableListOf(1, 2, 3)
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Arraylist</span>

```kotlin
val arrayList = arrayListOf(1, 2, 3)
val arrayList2 = ArrayList<Int>()
```

`mutableListOf` and `arrayListOf` return an ArrayList.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Map and Set</span> 

```kotlin
val map = mapOf("a" to 1, "b" to 2)
val mutableMap = mutableMapOf("a" to 1, "b" to 2)
	
val set = setOf<Int>()
val mutableSet = mutableSetOf<Int>()
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Collection</span> <span style="text-transform: none; font-size:0.8em;"> filtering</span>

<br/>

```kotlin
val users = api.getUsers()
val activeUsersNames = items.filter { 
    it.active
}
adapter.setUsers(activeUsers)
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Traversing</span> <span style="text-transform: none; font-size:0.8em;"> map/list</span>

<br/>

```kotlin
for ((k, v) in map) {
    println(“$k -> $v”)
}
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
activity.hideKeyboard()
```
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

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Extension</span> <span style="text-transform: none; font-size:0.8em;"> function</span>

```kotlin
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            it.snack("Snack message") {
                action("Action") { toast("Action clicked") }
            }
        }
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Extension</span> <span style="text-transform: none; font-size:0.8em;"> function</span>

```kotlin
inline fun View.snack(
       message: String,
       length: Int = Snackbar.LENGTH_LONG,
       f: Snackbar.() -> Unit) {
    val snack = Snackbar.make(this, message, length)
    snack.f()
    snack.show()
}

fun Snackbar.action(action: String, color: Int? = null, listener: (View) -> Unit) {
    setAction(action, listener)
    color?.let { setActionTextColor(color) }
}
```

---


### Lazy

Note:

- Feature that lazy create object at access time

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

<br/>

```kotlin
private val downloadManagerInternal = DownloadModule().createDownloadManager(context)
```

Note:

- Instead of that

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

<br/>

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

<br/>

```kotlin
private val homeView: HomeView by bind(R.id.activity_home_home_view)
```

Note:

-  

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

<br/>

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

<br/>

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

<br/>

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

### Delegates.observable

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Delegates</span> <span style="text-transform: none; font-size:0.8em;"> observable</span>

```kotlin
var nbTimeVariableChanged = 0
var observableData: String by Delegates.observable("default value") {
	property, oldValue, newValue ->
		nbTimeVariableChanged++
}
print("nb times variable value changed : $nbTimeVariableChanged") // print 0
observableData = "new value"
print("nb times variable value changed : $nbTimeVariableChanged") // print 1
```

---

### Delegates.vetoable

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Delegates</span> <span style="text-transform: none; font-size:0.8em;"> vetoable</span>

```kotlin
var vetoableData: Int by Delegates.vetoable(0){property, oldValue, newValue ->
	newValue > 0
}
```

Invalidate new value if it doesn't respect condition.

---

### Operator overloading

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Operator</span> <span style="text-transform: none; font-size:0.8em;"> overloading</span>

<br/>

```kotlin
val view = viewGroup[2]
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Operator</span> <span style="text-transform: none; font-size:0.8em;"> overloading</span>

<br/>

```kotlin
operator fun ViewGroup.get(pos: Int): View = getChildAt(pos)
```

```kotlin
val view = viewGroup[2]
```

---

<br/>

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Operator</span> <span style="text-transform: none; font-size:0.8em;"> overloading</span>

```kotlin
val ViewGroup.views: List<View>
    get() = (0 until childCount).map { getChildAt(it) }
```

```kotlin
val view = viewGroup.views[0]
```

Note:

- Use list operator

---

### Coroutines

Note:

- Replace Threads, AsyncTasks...

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Coroutines</span> <span style="text-transform: none; font-size:0.8em;"> deps</span>

<br/>

```gradle
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:0.22.5"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:0.22.5"
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

### Unit tests with mockito

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Tests</span> <span style="text-transform: none; font-size:0.8em;"> with Mockito</span>

```kotlin
@Test
fun onAttachedRegisterOnMetadataListener() {
    // Given
    val presenter = createInstanceToTest()

    // When
    presenter.onAttached()

    // Then
    Mockito.verify(videoManager)!!.registerOnMetadataListener(Mockito.any())
}
```

`java.lang.IllegalStateException: Mockito.any() must not be null`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Tests</span> <span style="text-transform: none; font-size:0.8em;"> with Mockito</span>

```kotlin
private inline fun <reified T : Any> any() = Mockito.any(T::class.java) ?: castNull()

@Suppress("UNCHECKED_CAST")
private fun <T> castNull(): T = null as T
```

---

### Kotlin 1.3-m1

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Kotlin 1.3-m1</span> <span style="text-transform: none; font-size:0.8em;"> when</span>

<br/>

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
- https://medium.com/google-developers/kotlin-demystified-understanding-shorthand-lamba-syntax-74724028dcc5


