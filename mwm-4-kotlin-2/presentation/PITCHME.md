![Logo](mwm-3-kotlin-1/presentation/logo-1.png)

#### <span style="text-transform: none">Kotlin - 2</span>

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

### Lazy

Note:

- 

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private var themeManager: ThemeManager? = null

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
		themeManager = MainApplication.getAppComponent().provideThemeManager()
		userAction = HomeActivityPresenter(this, themeManager!!)
    }
}
```

Note:

- `var` "problem" is `!!`, need to check nullity each time

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private val themeManager = MainApplication.getAppComponent().provideThemeManager()

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
		userAction = HomeActivityPresenter(this, themeManager)		
    }
}
```

Note:

- `val` better than `var`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private val themeManager: ThemeManager by lazy {
        MainApplication.getAppComponent().provideThemeManager()
    }

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
		userAction = HomeActivityPresenter(this, themeManager)		
    }
}
```

Note:

- lazy is thread safe by default to avoid that the lambda gets computed more than once

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private val themeManager: ThemeManager by lazy(LazyThreadSafetyMode.NONE) {
        MainApplication.getAppComponent().provideThemeManager()
    }

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
		userAction = HomeActivityPresenter(this, themeManager)		
    }
}
```

Note:

- lazy is thread safe by default to avoid that the lambda gets computed more than once

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

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```java
public final class HomeActivity extends AppCompatActivity {
   private final Lazy themeManager$delegate;
   static final KProperty[] $$delegatedProperties = new KProperty[]{(KProperty)Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(HomeActivity.class), "themeManager", "getThemeManager()Lcom/mwm/demo/theme/ThemeManager;"))};

   private final ThemeManager getThemeManager() {
      Lazy var1 = this.themeManager$delegate;
      KProperty var3 = $$delegatedProperties[0];
      return (ThemeManager) var1.getValue();
   }

   public HomeActivity() {
      this.themeManager$delegate = LazyKt.lazy((Function0)null.INSTANCE);
   }
}

```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lazy</span> <span style="text-transform: none; font-size:0.8em;"> field</span>

```kotlin
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private val themeManagerLazy = lazy {
        MainApplication.getAppComponent().provideThemeManager()
    }

	override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
		userAction = HomeActivityPresenter(this, themeManagerLazy)		
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
        private val themeManagerLazy: Lazy<ThemeManager>
) : HomeActivityContract.UserAction {

    override fun start() {
        updateTheme()
    }

    private fun updateTheme(theme = themeManagerLazy.value.getTheme()) {
        // ...
    }
}
```

Note:

-  

---

### Bind

Note:

- Bind R.id with the object ref

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> var</span>

```kotlin
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private var homeView: HomeView?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeView = findViewById(R.id.activity_home_home_view)
    }

    private fun navigateToSettings() {
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
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private lateinit var homeView: HomeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeView = findViewById(R.id.activity_home_home_view)
    }

    private fun navigateToSettings() {
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
class HomeActivity : AppCompatActivity(),
        HomeActivityContract.Screen {

    private val homeView: HomeView by bind(R.id.activity_home_home_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    private fun navigateToSettings() {
        homeView.navigateToSettings()
    }
}
```

Note:

-  

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Bind</span> <span style="text-transform: none; font-size:0.8em;"> val</span>

```kotlin
// medium.com/@quiro91
private fun <T : View> Activity.bind(@IdRes res: Int): Lazy<T> {
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
class HomeView : @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val view = View.inflate(context, R.layout.view_home, this)
    private val title: Text²View = view.findViewById(R.id.view_home_title)
}
```

Note:

-  

---

