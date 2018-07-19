![Logo](mwm-3-kotlin-1/presentation/logo-1.png)

#### <span style="text-transform: none">Kotlin - 1</span>

<span style="color:gray; font-size:0.6em;">Kotlin </span> <span style="color: #00B8D4; font-size:0.6em;">1.2.51</span>
<br/>
<span style="color:gray; font-size:0.5em;">18-07-2018</span>
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

### <span style="color: #00B8D4; text-transform: none;">Presentation</span> <span style="text-transform: none;">goals</span>
<br/>

In the Android developer context:

<span style="color:gray; font-size:0.5em;">
    - Why use this language
    - Where use this language
    - What is the cost/overhead
    - Decompile basic Kotlin to Java
</span>

Note:

- Presentation in 3 parts
- How MWM use / will use this language
- We suppose that the person who are listening are Android developers and know Java

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">pros</span>

* Strongly typed
* More concise and readable than Java
* "Lightweight"
* JetBrains
* ...

Note:

- Typed (include nullity in type)
- Relatively light
- Jetbrains <3

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">cons</span>

* Overhead
* Team skills
* New languages
* Versions

Note:

- Not all devs are up-to-date with Kotlin
- New -> not mature
- Versions of Kotlin in libs / apps??

---

### <span style="color: #00B8D4; text-transform: none;">Kotlin</span> <span style="text-transform: none;">methods</span>

<p style="height:11em;">
![Logo](mwm-3-kotlin-1/presentation/logo-2-kotlin-methods-1-2-51.png)
</p>

<span style="color:gray; font-size:0.4em;">Kotlin 1.2.51 (demo app) - com.getkeepsafe.dexcount</span>

Note:

- We count the method of the last Kotlin version 1.2.51
- Proportion in an empty app that have the support lib
- Demo app available in Mercandj/presentation

---

### <span style="color: #00B8D4; text-transform: none;">Kotlin</span> <span style="text-transform: none;">methods</span>

```java
6102  791  kotlin
3     2    kotlin._Assertions
12    20   kotlin.annotation
2763  119  kotlin.collections
112   28   kotlin.comparisons
31    2    kotlin.concurrent
149   40   kotlin.coroutines
149   40   kotlin.coroutines.experimental
33    10   kotlin.coroutines.experimental.intrinsics
10    4    kotlin.coroutines.experimental.jvm
10    4    kotlin.coroutines.experimental.jvm.internal
8     0    kotlin.experimental
36    10   kotlin.internal
12    5    kotlin.internal.contracts
2     0    kotlin.internal.jdk7
276   52   kotlin.io
2     0    kotlin.jdk7
601   108  kotlin.jvm
23    0    kotlin.jvm.functions
557   108  kotlin.jvm.internal
2     0    kotlin.jvm.internal.unsafe
117   9    kotlin.math
20    7    kotlin.properties
294   36   kotlin.ranges
141   17   kotlin.reflect
455   117  kotlin.sequences
3     0    kotlin.system
836   183  kotlin.text
```

Note:

- Collections 1/3 of all methods

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">size</span>

![Logo](mwm-3-kotlin-1/presentation/logo-3-kotlin-size.png)

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">learning</span>

- IntelliJ + EduTools plugin + Koans course
- Ctrl + Alt + Shift + K

Note:

- Learn with build in courses
- Convert Java to Kotlin

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">decompiler</span>

![Logo](mwm-3-kotlin-1/presentation/logo-4-decompiler.png)

Note:

- Open decompiler Kotlin -> Java

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">decompiler</span>

![Logo](mwm-3-kotlin-1/presentation/logo-5-decompiler.png)

Note:

- Steps from Kotlin to Java
- Kotlin cursor select bytecode (correspondence)

---

### Let's code

Note:

After this slide, only code decompiled

- Kotlin similar to Java
- Type after the **argument**
- Type **return** at the end of the signature
- Strongly type/nullity

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Hello</span> <span style="text-transform: none; font-size:0.8em;"> World</span>
<br/>

```kotlin
fun start(): String = "Hello World"
```
```java
public final class HelloWorldKt {
   @NotNull
   public static final String start() {
      return "Hello World";
   }
}
```

```kotlin
fun printTwice(message: String) {
    Log.d("jm/debug", "$message " + message)
}
```
```java   
public static final void printTwice(@NotNull String message) {
   Intrinsics.checkParameterIsNotNull(message, "message");
   Log.d("jm/debug", message + ' ' + message);
}
```

Note:

- Simple decompile
- Java Top / Kotlin bottom
- Create missing Java class

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Val</span> <span style="text-transform: none; font-size:0.8em;"> Var</span>

```kotlin
fun valVar(): Int {
    val immutableInt1 = 1
    val immutableInt2: Int = 2
    var mutableInt1 = 3
    mutableInt1 = 4
    var mutableInt2: Int = 5
    var mutableInt3: Int? = null
    return immutableInt1 + immutableInt2 + mutableInt1 + 
       mutableInt2 + mutableInt3!! // Will throw
}
```

```java
public final int valVar() {
   int immutableInt1 = 1; int immutableInt2 = 2;
   int mutableInt1 = true; int mutableInt1 = 4;
   int mutableInt2 = 5; Integer mutableInt3 = (Integer) null;
   int var10000 = immutableInt1 + immutableInt2 + mutableInt1 + mutableInt2;
   Intrinsics.throwNpe();
   return var10000 + mutableInt3;
}
```

Note:

- IDE advice here to replace `var`
- Tips: We had to do computation to avoid boolean simplification
- Create missing Java class
- Will throw

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lateinit</span> <span style="text-transform: none; font-size:0.8em;"> Var</span>

```kotlin
class ValVarTester {
    private lateinit var lateField: String

    fun init() {
        if (!::lateField.isInitialized) {
            lateField = "42"
        }
    }
    
    fun get(): String { return lateField }
}
```

```java
public final void init() {
   if (lateField == null) { lateField = "42"; }
}

@NotNull
public final String get() {
   String var10000 = lateField;
   if (lateField == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lateField");
   }
   return var10000;
}
```

Note:

- Lazy init
- Throw

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lateinit</span> <span style="text-transform: none; font-size:0.8em;"> Var</span>

```java
// $FF: synthetic method
@NotNull
public static final String access$getLateField$p(ValVarTester $this) {
   String var10001 = lateField;
   if (lateField == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lateField");
   }
   return var10001;
}

// $FF: synthetic method
public static final void access$setLateField$p(ValVarTester $this, @NotNull String var1) {
   lateField = var1;
}
```

Note:

- Added in the class too

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lateinit</span> <span style="text-transform: none; font-size:0.8em;"> Var</span>

```java
final class ValVarTester$init$1 extends MutablePropertyReference0 {
   ValVarTester$init$1(ValVarTester var1) {
      super(var1);
   }
   public String getName() {
      return "lateField";
   }
   public String getSignature() {
      return "getLateField()Ljava/lang/String;";
   }
   public KDeclarationContainer getOwner() {
      return Reflection.getOrCreateKotlinClass(ValVarTester.class);
   }
   @Nullable
   public Object get() {
      return ValVarTester.access$getLateField$p((ValVarTester) this.receiver);
   }
   public void set(@Nullable Object value) {
      ValVarTester.access$setLateField$p((ValVarTester) this.receiver, (String) value);
   }
}
```

Note:

- Extra class created, I don't know why

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Lateinit</span> <span style="text-transform: none; font-size:0.8em;"> Var in Activity</span>

```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.activity_main_text_view)
    }
}
```

Note:

- Good because crash on multiple affectation
- Good because instead of `TextView?` that require `!!.` or `?.` only `.`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Class</span> <span style="text-transform: none; font-size:0.8em;">and constructor</span>

```kotlin
class MyClass constructor(private val myProperty: Int, simpleParameter: Float) {
    private var anotherVal: Double = 0.0
	
    constructor(myProperty: Int, simpleParameter: Float, anotherSimpleParameter: Double)
            : this(myProperty, simpleParameter) {
        Log.i("MyClass", "secondary constructor")
        this.anotherVal = anotherSimpleParameter
    }

    init {
        Log.i("MyClass", "init")
    }
}
```

Note:

- `constructor` keyword can be omitted because there is no visibility modifier and annotation
- `simpleParameter` is only usable in the init method and in property initializer
- `myProperty` is a class property because of keyword `val`/`var`
- Content of `init` will be call before secondary constructor content
- `init` method correponds to the primary constructor content
- Secondary constructor must call primary constructor

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Class</span> <span style="text-transform: none; font-size:0.8em;">and constructor</span>

```java
public final class MyClass {
   private double anotherVal;
   private final int myProperty;

   public MyClass(int myProperty, float simpleParameter) {
      this.myProperty = myProperty;
      Log.i("MyClass", "init");
   }

   public MyClass(int myProperty, float simpleParameter, double anotherSimpleParameter) {
      this(myProperty, simpleParameter);
      Log.i("MyClass", "secondary constructor");
      this.anotherVal = anotherSimpleParameter;
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Custom</span> <span style="text-transform: none; font-size:0.8em;">View</span>

```kotlin
class CustomView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val textView: TextView

    init {
        View.inflate(context, R.layout.view_custom, this)
        textView = findViewById(R.id.view_custom_text_view)
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Custom</span> <span style="text-transform: none; font-size:0.8em;">View</span>

```java
public final class CustomView extends FrameLayout {
   private final TextView textView;
   private HashMap _$_findViewCache;

   @JvmOverloads
   public CustomView(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
      Intrinsics.checkParameterIsNotNull(context, "context");
      super(context, attrs, defStyleAttr);
      View.inflate(context, 2131296294, (ViewGroup) this);
      View var10001 = this.findViewById(2131165323);
      Intrinsics.checkExpressionValueIsNotNull(var10001, "findViewById(R.id.view_custom_text_view)");
      this.textView = (TextView) var10001;
   }

   // $FF: synthetic method
   @JvmOverloads
   public CustomView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = (AttributeSet) null;
      }
      if ((var4 & 4) != 0) {
         var3 = 0;
      }
      this(var1, var2, var3);
   }

   @JvmOverloads
   public CustomView(@NotNull Context context, @Nullable AttributeSet attrs) {
      this(context, attrs, 0, 4, (DefaultConstructorMarker) null);
   }

   @JvmOverloads
   public CustomView(@NotNull Context context) {
      this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
   }

   public View _$_findCachedViewById(int var1) {
      if (this._$_findViewCache == null) {
         this._$_findViewCache = new HashMap();
      }
      View var2 = (View)this._$_findViewCache.get(var1);
      if (var2 == null) {
         var2 = this.findViewById(var1);
         this._$_findViewCache.put(var1, var2);
      }
      return var2;
   }

   public void _$_clearFindViewByIdCache() {
      if (this._$_findViewCache != null) {
         this._$_findViewCache.clear();
      }
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;">in constructor</span>
<br/>

```kotlin
class NullityDemo(
        nonNullString: String,
        nullableString: String?
)
```

```java
public final class NullityDemo {
   public NullityDemo(@NotNull String nonNullString, @Nullable String nullableString) {
      Intrinsics.checkParameterIsNotNull(nonNullString, "nonNullString");
      super();
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;">in constructor</span>

```java
public static void checkParameterIsNotNull(Object value, String paramName) {
    if (value == null) {
        throwParameterIsNullException(paramName);
    }
}
```

```java
private static void throwParameterIsNullException(String paramName) {
    StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

    // #0 Thread.getStackTrace()
    // #1 Intrinsics.throwParameterIsNullException
    // #2 Intrinsics.checkParameterIsNotNull
    // #3 our caller
    StackTraceElement caller = stackTraceElements[3];
    String className = caller.getClassName();
    String methodName = caller.getMethodName();

    IllegalArgumentException exception =
            new IllegalArgumentException("Parameter specified as non-null is null: " +
                                         "method " + className + "." + methodName +
                                         ", parameter " + paramName);
    throw sanitizeStackTrace(exception);
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;">?.</span>

```kotlin
fun isStringEmptySafe(str: String?): Boolean {
    return str?.length == 0
}
```

```java
public final boolean isStringEmptySafe(@Nullable String str) {
   boolean var10000;
   if (str != null) {
      if (str.length() == 0) {
         var10000 = true;
         return var10000;
      }
   }
   var10000 = false;
   return var10000;
}
```

Note:

- Add extra `if`
- Add extra variable

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;">!!.</span>

```kotlin
fun isStringEmpty(str: String?): Boolean {
    return str!!.isEmpty()
}
```

```java
public final boolean isStringEmpty(@Nullable String str) {
   if (str == null) {
      Intrinsics.throwNpe();
   }
   CharSequence var2 = (CharSequence) str;
   return var2.length() == 0;
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;">!!.</span>


```java
public static void throwNpe() {
    throw sanitizeStackTrace(new KotlinNullPointerException());
}

private static <T extends Throwable> T sanitizeStackTrace(T throwable) {
    return sanitizeStackTrace(throwable, Intrinsics.class.getName());
}

static <T extends Throwable> T sanitizeStackTrace(T throwable, String classNameToDrop) {
    StackTraceElement[] stackTrace = throwable.getStackTrace();
    int size = stackTrace.length;
    int lastIntrinsic = -1;
    for (int i = 0; i < size; i++) {
        if (classNameToDrop.equals(stackTrace[i].getClassName())) {
            lastIntrinsic = i;
        }
    }
    List<StackTraceElement> list = Arrays.asList(stackTrace).subList(lastIntrinsic + 1, size);
    throwable.setStackTrace(list.toArray(new StackTraceElement[list.size()]));
    return throwable;
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Variable</span> <span style="text-transform: none; font-size:0.8em;">shadowing</span>

![Logo](mwm-3-kotlin-1/presentation/logo-6-variable-shadowing.png)

```kotlin
class VariableShadowingDemo(
        private val str: String = "str-constructor"
) {

    fun exampleOfVariableShadowing(
            str: String = "str-parameter"
    ): List<String> {
        val list = ArrayList<String>()
        list.add(str)
        list.add(this.str)
        val str = "str-local-variable"
        list.add(str)
        list.add(this.str)
        return list
    }
}
```

Note:

- Not possible in Java

---

```java
public final class VariableShadowingDemo {
   private final String str;

   @NotNull
   public final List exampleOfVariableShadowing(@NotNull String str) {
      Intrinsics.checkParameterIsNotNull(str, "str");
      ArrayList list = new ArrayList();
      list.add(str);
      list.add(this.str);
      String str = "str-local-variable";
      list.add(str);
      list.add(this.str);
      return (List)list;
   }

   @NotNull
   public static List exampleOfVariableShadowing$default(VariableShadowingDemo var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) { var1 = "str-parameter"; }
      return var0.exampleOfVariableShadowing(var1);
   }

   public VariableShadowingDemo(@NotNull String str) {
      Intrinsics.checkParameterIsNotNull(str, "str");
      super();
      this.str = str;
   }

   public VariableShadowingDemo(String var1, int var2, DefaultConstructorMarker var3) {
      if ((var2 & 1) != 0) { var1 = "str-constructor"; }
      this(var1);
   }

   public VariableShadowingDemo() {
      this((String) null, 1, (DefaultConstructorMarker) null);
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Variable</span> <span style="text-transform: none; font-size:0.8em;">shadowing</span>

Output:


```kotlin
@Test
fun exampleOutput() {
    val list = VariableShadowingDemo().exampleOfVariableShadowing()
    Assert.assertEquals("str-parameter", list[0])
    Assert.assertEquals("str-constructor", list[1])
    Assert.assertEquals("str-local-variable", list[2])
    Assert.assertEquals("str-constructor", list[3])
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Data</span> <span style="text-transform: none; font-size:0.8em;">class</span>

```kotlin
data class SamplePack(private val id: Long, val name: String, var nbTimesLoaded: Int)
```

```java
public final class SamplePack {
   @NotNull
   private final String name;
   private int nbTimesLoaded;

   @NotNull
   public final String getName() { return this.name; }

   public final int getNbTimesLoaded() { return this.nbTimesLoaded; }

   public final void setNbTimesLoaded(int var1) { this.nbTimesLoaded = var1; }

   public SamplePack(@NotNull String name, int nbTimesLoaded) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.name = name;
      this.nbTimesLoaded = nbTimesLoaded;
   }
...
```

Note:
- The primary constructor needs to have at least one parameter.
- All primary constructor parameters need to be marked as val or var.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Data</span> <span style="text-transform: none; font-size:0.8em;">class</span>

```java
NotNull
public final SamplePack copy(@NotNull String name, int nbTimesLoaded) {
    Intrinsics.checkParameterIsNotNull(name, "name");
    return new SamplePack(name, nbTimesLoaded);
}

public String toString() {
    return "SamplePack(name=" + this.name + ", nbTimesLoaded=" + this.nbTimesLoaded + ")";
}

public int hashCode() {
    return (this.name != null ? this.name.hashCode() : 0) * 31 + this.nbTimesLoaded;
}

public boolean equals(Object var1) {
    ...
}
```

Note:

- Compiler only use properties define in the primary constructor to generate functions.


---
### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Named</span> <span style="text-transform: none; font-size:0.8em;">arguments</span>

```kotlin
class EventManager {
    fun sendEvent(eventType: String, abtest: String) {
        val message = "{\"eventType\": \"$eventType\"," +
                " \"abtest\": \"$abtest\"}"
        Log.i("EventManager", message)
    }
}

val eventManager = EventManager()
eventManager.sendEvent(abtest = "variation_a", eventType = "transaction")
```

```java
EventManager eventManager = new EventManager();
String var5 = "transaction";
String var6 = "variation_a";
eventManager.sendEvent(var5, var6);
```

Note:

- Positional arguments should be placed before named argumments.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Default</span> <span style="text-transform: none; font-size:0.8em;">parameter in function</span>

```kotlin
class EventManager {
    fun sendEvent(eventType: String? = null, abtest: String) {
        val message = "{\"eventType\": \"$eventType\", \"abtest\": \"$abtest\"}"
        Log.i("EventManager", message)
    }
}
```

```java
public final class EventManager {
   public final void sendEvent(@Nullable String eventType, @NotNull String abtest) {
      Intrinsics.checkParameterIsNotNull(abtest, "abtest");
      String message = "{\"eventType\": \"" + eventType + "\"," + " \"abtest\": \"" + abtest + "\"}";
      Log.i("EventManager", message);
   }
   public static void sendEvent$default(EventManager var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = (String) null;
      }
      var0.sendEvent(var1, var2);
   }
}
```

Note:

- A static method in java is generated if a function has default parameter.
- Override a method with a default parameter will use the same parameter as the one in the base method. It should be omitted from the signature of the overriding method.
- A default parameter can be use before non default parameter in the prototytpe if they are named.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range</span>

```kotlin
fun basicRange() {
    for (i in 1..10) {
        Log.i(TAG, "i : $i")
    }
}

```


```java
public final void basicRange() {
	int i = 1;
	for (byte var2 = 10; i <= var2; ++i) {
		Log.i("RangeTester", "i : " + i);
	}
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range</span>

No additionally cost for these functions.

```kotlin
fun downToRange() {
    for(i in 10 downTo 1) {
        Log.i(TAG, "i : $i")
    }
}

// Equivalent to the downTo example
fun reversedRange() {
    for (i in (1..10).reversed()) {
        Log.i(TAG, "i : $i")
    }
}

// Exclude the upper value
fun untilRange() {
    for (i in 0 until 10) {
        Log.i(TAG, "i : $i")
    }
}
```


---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range with a cost</span>

```kotlin
fun stepRange() {
    for (i in 0..10 step 2) {
        Log.i(TAG, "i : $i")
    }
}
```

<br/>
/!\ Instantiation of 2 temporaries objects : `IntProgression` and `IntRange`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range with a cost</span>

```java
public final void stepRange() {
    byte var4 = 0;
    IntProgression var10000 = RangesKt.step((IntProgression) (new IntRange(var4, 10)), 2);
    int i = var10000.getFirst();
    int var2 = var10000.getLast();
    int var3 = var10000.getStep();
    if (var3 > 0) {
        if (i > var2) {
            return;
        }
    } else if (i < var2) {
        return;
    }
    while (true) {
        Log.i("RangeTester", "i : " + i);
        if (i == var2) {
           return;
        }
        i += var3;
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range with a cost</span>

```kotlin
fun oneMorelLevelRange() {
    val customRange = 1..10
    for (i in customRange) {
        Log.i(TAG, "i : $i")
    }
}
```

```java
public final void oneMorelLevelRange() {
    byte var2 = 1;
    IntRange customRange = new IntRange(var2, 10);
    int i = customRange.getFirst();
    int var3 = customRange.getLast();
    if (i <= var3) {
        while(true) {
			Log.i("RangeTester", "i : " + i);
			if (i == var3) {
               break;
            }
            ++i;
        }
    }
}
```

<br/>
/!\ Temporary `IntRange` is allocated.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">with forEach</span>

```kotlin
fun testForEachOnRange() {
    (1..10).forEach {
        Log.i(TAG, "i : $it")
    }
}
```

```java
public final void testForEachOnRange() {
	byte var1 = 1;
	Iterable $receiver$iv = (Iterable) (new IntRange(var1, 10));
	Iterator var2 = $receiver$iv.iterator();
	while (var2.hasNext()) {
		int element$iv = ((IntIterator) var2).nextInt();
		Log.i("", "i : " + element$iv);
	}
}
```

<br/>
/!\ Temporary `IntRange` is allocated.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">with forEach</span>

`forEach` should only be used with `Iterable`, not `Range`.

```kotlin
fun testForEachOnIterator() {
    list.forEach {
        Log.i(TAG, "i : $it")
    }
}
```

```java
public final void testForEachOnIterator1() {
    Iterable $receiver$iv = (Iterable) list;
    Iterator var2 = $receiver$iv.iterator();
    while (var2.hasNext()) {
        Object element$iv = var2.next();
        int it = ((Number) element$iv).intValue();
        Log.i("", "i : " + it);
    }
}
```

<br/>
No additional cost. 

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">with indices</span>

Can loop on list of indices without additional cost.

```kotlin
fun testForWithIndices() {
    for (i in list.indices) {
        Log.i(TAG, "i : " + list[i])
    }
}
```

```java
public final void testForWithIndices() {
    int i = 0;
    for (int var2 = ((Collection)list).size(); i < var2; ++i) {
        Log.i("", "i : " + (Integer)list.get(i));
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Extend</span> <span style="text-transform: none; font-size:0.8em;">from a parent</span>

In Kotlin, classes and methods are `final` by default.

```kotlin
open class Animal() {
	open fun myOpenedFunction() {}
}

class Dog() : Animal() {
	override fun myOpenedFunction() {}
}
```

`open` keyword is required to be able to extend from class/method.

<br/>
`override` language keyword is required to override a method.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">When</span> <span style="text-transform: none; font-size:0.8em;">basic</span>

```kotlin
fun basicWhen(str: String): Int {
    when (str) {
        "" -> return 1
        "c" -> return 2
        "coucou" -> return 3
    }
    return 0
}
```

```java
public final int basicWhen(@NotNull String str) {
   Intrinsics.checkParameterIsNotNull(str, "str");
   switch (str.hashCode()) {
      case -1354586272:
         if (str.equals("coucou")) { return 3; }
         break;
      case 0:
         if (str.equals("")) { return 1; }
         break;
      case 99:
         if (str.equals("c")) { return 2; }
   }
   return 0;
}
```

Note:

- No extra cost
- Reorder conditions: check big string first

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">When</span> <span style="text-transform: none; font-size:0.8em;">"basic"</span>

```kotlin
fun basicWhen(str: String): Int {
    when (str) {
        "" -> return 1
        "c" -> return 2
        "coucou" -> return 3
        "cou" + "cou" -> return 3
    }
    return 0
}
```

```java
public final int basicWhen(@NotNull String str) {
   Intrinsics.checkParameterIsNotNull(str, "str");
   switch (str.hashCode()) {
      case -1354586272:
         if (str.equals("coucou")) { return 3; }
         if (str.equals("coucou")) { return 4; }
         break;
      case 0:
         if (str.equals("")) { return 1; }
         break;
      case 99:
         if (str.equals("c")) { return 2; }
   }
   return 0;
}
```

Note:

- No extra cost
- Reorder conditions: check big string first

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">When</span> <span style="text-transform: none; font-size:0.8em;">basic with else</span>

```kotlin
fun basicWhenWithElse(str: String) = when (str) {
    "" -> 1
    "c" -> 2
    "coucou" -> 3
    else -> 0
}
```

```java
public final int basicWhenWithElse(@NotNull String str) {
   Intrinsics.checkParameterIsNotNull(str, "str");
   byte var10000;
   switch (str.hashCode()) {
      case -1354586272:
         if (str.equals("coucou")) {
            var10000 = 3; return var10000;
         }
         break;
      case 0:
         if (str.equals("")) {
            var10000 = 1; return var10000;
         }
         break;
      case 99:
         if (str.equals("c")) {
            var10000 = 2; return var10000;
         }
   }
   var10000 = 0; return var10000;
}
```

Note:

- Extra local variable

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">When</span> <span style="text-transform: none; font-size:0.8em;"> with computation</span>

```kotlin
fun whenWithComputation(integer: Int) = when (integer) {
    1 -> 1
    1 + integer -> 2
    2 + integer -> 3
    else -> 0
}
```

```java
public final int whenWithComputation(int integer) {
   return integer == 1 ? 1 : 
      (integer == 1 + integer ? 2 : 
         (integer == 2 + integer ? 3 : 0));
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">When</span> <span style="text-transform: none; font-size:0.8em;"> with is</span>

```kotlin
fun whenWithIs(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}
```

```java
public final boolean hasPrefix(@NotNull Object x) {
   Intrinsics.checkParameterIsNotNull(x, "x");
   return x instanceof String ? StringsKt.startsWith$default(
           (String) x, "prefix", false, 2, (Object) null) : false;
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">When</span> <span style="text-transform: none; font-size:0.8em;"> with range</span>

```kotlin
fun whenWithRange(integer: Int) = when (integer) {
    1 -> 1
    2, 3, 4 -> 2
    in 6..10 -> 3
    !in 30..50 -> 4
    else -> 0
}
```

```java
public final int whenWithRange(int integer) {
   byte var10000;
   if (integer == 1) {
      var10000 = 1;
   } else if (integer != 2 && integer != 3 && integer != 4) {
     if (6 <= integer) {
        if (10 >= integer) { var10000 = 3; return var10000; }
     }
     if (30 <= integer) {
        if (50 >= integer) { var10000 = 0; return var10000; }
     }
     var10000 = 4;
   } else {
      var10000 = 2;
   }
   return var10000;
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Anonymous</span> <span style="text-transform: none; font-size:0.8em;"> from interface</span>

```kotlin
fun useManager() {
    executeManager(object : Manager {
        override fun execute() {}
    })
}

private fun executeManager(manager: Manager) {}

interface Manager {
    fun execute()
}
```

Generate same code as the java one

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Anonymous</span> <span style="text-transform: none; font-size:0.8em;"> from class</span>

```kotlin
fun useManagerImpl() {
    executeManagerImpl(object : ManagerImpl() {
        override fun execute() {}
    })
}

private fun executeManagerImpl(managerImpl: ManagerImpl) {}

open class ManagerImpl {
    open fun execute() {}
}
```

Generate same code as the java one

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Destructuring</span> <span style="text-transform: none; font-size:0.8em;">variable</span>

![Logo](mwm-3-kotlin-1/presentation/logo-7-destructuring.png)

`.val` autocompletion

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Destructuring</span> <span style="text-transform: none; font-size:0.8em;">variable</span>

```kotlin
fun destructuring(): String {
    val (id, videosIds) = create()
    if (videosIds.isEmpty()) {
        throw IllegalStateException()
    }
    return id
}
```

```java
@NotNull
public final String destructuring() {
   Destructuring.Pojo var3 = this.create();
   String id = var3.component1();
   List videosIds = var3.component2();
   if (videosIds.isEmpty()) {
      throw (Throwable) (new IllegalStateException());
   } else {
      return id;
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Singleton</span> <span style="text-transform: none; font-size:0.8em;">with object</span>

```kotlin
object DateUtils {
    fun getCurrentDate(): Date {
        return Calendar.getInstance().time
    }
}
```

```java
public final class DateUtils {
   public static final DateUtils INSTANCE;
   @NotNull
   public final Date getCurrentDate() {
      Calendar var10000 = Calendar.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(var10000, "Calendar.getInstance()");
      Date var1 = var10000.getTime();
      Intrinsics.checkExpressionValueIsNotNull(var1, "Calendar.getInstance().time");
      return var1;
   }
   static {
      DateUtils var0 = new DateUtils();
      INSTANCE = var0;
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Companion object</span> <span style="text-transform: none; font-size:0.8em;">of class</span>

```kotlin
class OtherActivity : Activity() {
    
    companion object {
        private const val TAG = "OtherActivity"
        fun startActivity(context: Context) {
            val intent = Intent(context, OtherActivity::class.java)
            if (context !is Activity) {
                intent.flags = FLAG_ACTIVITY_NEW_TASK and FLAG_ACTIVITY_CLEAR_TASK
            }
            context.startActivity(intent)
        }
    }
}
```

Note:

- In Kotlin, we don't have to write the companion object name.
- `startActivity` method is called by calling `OtherActivity.Companion.startActivity` from Java.
- `Companion` is the default name in case companion object doesn't have one.
- We can write `companion object Fabric` and call method with `OtherActivity.Fabric.startActivity` in Java.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Companion object</span> <span style="text-transform: none; font-size:0.8em;">of class</span>

```java
public final class OtherActivity extends Activity {
   private static final String TAG = "OtherActivity";
   public static final OtherActivity.Companion Companion = new OtherActivity.Companion((DefaultConstructorMarker)null);
   public static final class Companion {
      public final void startActivity(@NotNull Context context) {
         Intrinsics.checkParameterIsNotNull(context, "context");
         Intent intent = new Intent(context, OtherActivity.Companion.getClass());
         if (!(context instanceof Activity)) {
            intent.setFlags(0);
         }
         context.startActivity(intent);
      }

      private Companion() {}

      public Companion(DefaultConstructorMarker $constructor_marker) {
         this();
      }
   }
}
```

---

### Scope functions

Note:

- There are just some fine details between each scope functions.
- Functions which help to structure the code by creating blocks of logics.
- `apply` and `also` return the caller.
- `run` and `let` return the block result.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Run</span> <span style="text-transform: none; font-size:0.8em;">scope function</span>

```kotlin
private var a = 5
fun testRun() {
    run {
        val a = 10
        Log.i("ScopeDemo", "a : $a")
        Log.i("ScopeDemo", "this:a : " + this.a)
    }
}
```

```java
private int a;
public final void testRun() {
    ScopeDemo $receiver = (ScopeDemo)this;
    int a = 10;
    Log.i("ScopeDemo", "a : " + a);
    Log.i("ScopeDemo", "this:a : " + $receiver.a);
}
```

Note:

- Create a small scope with `run`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Run</span> <span style="text-transform: none; font-size:0.8em;">scope function</span>

```kotlin
inline fun <T, R> T.run(block: T.() -> R): R
```
```kotlin
private var view = View(context)
fun testViewRun() {
    view.run {
        alpha = 0.5f
        isEnabled = true
    }
}
```

```java
private View view;
public final void testViewRun() {
    View var1 = this.view;
    var1.setAlpha(0.5F);
    var1.setEnabled(true);
}
```

Note:

- The caller `view` is accessible with `this`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Run</span> <span style="text-transform: none; font-size:0.8em;">scope function</span>

```kotlin
fun testRunReturn() : Notification{
    return Notification.Builder(context).run {
		setContentTitle("Title")
		setContentText("Message")
		build()
	}
}
```

```java
@NotNull
public final Notification testRunReturn() {
    Builder var1 = new Builder(this.context);
    var1.setContentTitle((CharSequence)"Title");
    var1.setContentText((CharSequence)"Message");
    Notification var10000 = var1.build();
    Intrinsics.checkExpressionValueIsNotNull(var10000, "build()");
    Intrinsics.checkExpressionValueIsNotNull(var10000, "");
    return var10000;
}
```

Note:

- Return the block result.
- The caller `Notification.Builder` is accessible with `this`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Let</span> <span style="text-transform: none; font-size:0.8em;">scope function</span>

```kotlin
inline fun <T, R> T.let(block: (T) -> R): R
```
```kotlin
fun testLetReturn() : Notification?{
    return notifbuilder?.let {
        it.setContentTitle("Title")
        it.setContentText("Message")
        it.build()
    }
}
```
```java
@Nullable
public final Notification testLet1Return() {
    Builder var10000 = this.notifbuilder;
    Notification var4;
    if (this.notifbuilder != null) {
        Builder var1 = var10000;
        var1.setContentTitle((CharSequence) "Title");
        var1.setContentText((CharSequence) "Message");
        var4 = var1.build();
    } else {
        var4 = null;
    }
    return var4;
}
```

Note:

- `let` allows on a nullable variable to create a scope where the variable is not null.
- Return the block result.
- The caller `notifbuilder` is accessible with `it`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Apply and also</span> <span style="text-transform: none; font-size:0.8em;">scope function</span>

```kotlin
inline fun <T> T.apply(block: T.() -> Unit): T
inline fun <T> T.also(block: (T) -> Unit): T
```
```kotlin
fun testApply() {
    val paint = Paint().apply {
        color = Color.MAGENTA
        style = Paint.Style.STROKE
    }
}
fun testAlso() {
    val paint = Paint().also {
        it.color = Color.MAGENTA
        it.style = Paint.Style.STROKE
    }
}
```
```java
// both methods generate same java code
public final void testApply() {
    Paint var2 = new Paint();
    var2.setColor(-65281);
    var2.setStyle(Style.STROKE);
}
```

Note:

- `apply` and `also` return the caller.
- The caller `Paint` is accessible with `this` for `apply`.
- The caller `Paint` is accessible with `it` for `also`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">With</span> <span style="text-transform: none; font-size:0.8em;">scope function</span>

```kotlin
inline fun <T, R> with(receiver: T, block: T.() -> R): R
```
```kotlin
fun testWith() {
    with (view) {
        this.alpha = 0.5f
        isEnabled = true
    }
}
```
```java
public final void testWith() {
    View var1 = this.view;
    var1.setAlpha(0.5F);
    var1.setEnabled(true);
}
```

Note:

- `with` is not an extension function.
- The caller `view` is accessible with `this`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Scope</span> <span style="text-transform: none; font-size:0.8em;">function summary</span>

![Logo](mwm-3-kotlin-1/presentation/scope_function.png)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Any</span> <span style="text-transform: none; font-size:0.8em;">with list</span>

```kotlin
fun anyList(): List<Any> {
    val list = ArrayList<Any>(1)
    list.add("Coucou")
    return list
}
```
```java
@NotNull
public final List anyList() {
   ArrayList list = new ArrayList(1);
   list.add("Coucou");
   return (List)list;
}
```

Note:

- Any replace Java `Object`

---

### Java Interoperability

Note:

- Pretty easy to call Kotlin code from Java but there are some fine details.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Static</span> <span style="text-transform: none; font-size:0.8em;">methods and fields</span>

```kotlin
class Interoperability {
    companion object {
        @JvmField val myVar = 5
        @JvmStatic fun myStaticFunctionInJava() {
            Log.i("OtherActivity", "My static function in java in Interoperability")
        }
        fun myNotStaticFunctionInJava() {
            Log.i("OtherActivity", "My not static function in java in Interoperability")
        }
    }
}
```
```java
public final class Interoperability {
   @JvmField public static final int myVar = 5;
   public static final Interoperability.Companion Companion = new Interoperability.Companion((DefaultConstructorMarker)null);
   @JvmStatic public static final void myStaticFunctionInJava() { Companion.myStaticFunctionInJava(); }
   public static final class Companion {
      @JvmStatic public final void myStaticFunctionInJava() {
         Log.i("OtherActivity", "My static function in java in Interoperability");
      }
      public final void myNotStaticFunctionInJava() {
         Log.i("OtherActivity", "My not static function in java in Interoperability");
      }
      private Companion() {}
      public Companion(DefaultConstructorMarker $constructor_marker) { this(); }
   }
}
```

Note:

- `myVar` is private by default, event if we put `public` in front of the variable declaration.
- Need to use `@JvmField` to set it `public`.
- Can also use `const` or `lateinit`.
- `@JvmStatic` above a function allow to directly call this method without passing by companion object.
- Call `Interoperability.myStaticFunctionInJava()` instead of `Interoperability.Companion.myStaticFunctionInJava()`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Static</span> <span style="text-transform: none; font-size:0.8em;">methods and fields</span>

```java
Interoperability.myStaticFunctionInJava(); // works fine
Interoperability.myNotStaticFunctionInJava(); // error
Interoperability.Companion.myNotStaticFunctionInJava(); // works, a call through the singleton instance
Interoperability.Companion.myStaticFunctionInJava(); // works too
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Throw</span> <span style="text-transform: none; font-size:0.8em;">exception</span>

```kotlin
class ThrowException {
    fun myMethodThrowException(){
        throw IOException("I throw an exception which can't be catch by java")
    }
    @Throws(IOException::class)
    fun myMethodThrowExceptionCatchableFromJava(){
        throw IOException("I throw an exception which works with Java")
    }
}
```
```java
public final class ThrowException {
   public final void myMethodThrowException() {
      throw (Throwable)(new IOException("I throw an exception which can't be catch by java"));
   }

   public final void myMethodThrowExceptionCatchableFromJava() throws IOException {
      throw (Throwable)(new IOException("I throw an exception which works with Java"));
   }
}
```

Note:

- Can't catch exception for `myMethodThrowException` method in Java because methods doesn't indicate that this exception can be throw.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Kotlin</span> <span style="text-transform: none; font-size:0.8em;">Jni</span>

```kotlin
class BridgeJni {
    companion object {
        @JvmStatic
        external fun getString(): String

        init { System.loadLibrary("cpp-api") }
    }
}
```

```java
public final class BridgeJni {
   public static final BridgeJni.Companion Companion = new BridgeJni.Companion(
           (DefaultConstructorMarker) null);
   static { System.loadLibrary("cpp-api"); }

   @JvmStatic @NotNull
   public static final native String getString();

   public static final class Companion {
      @JvmStatic @NotNull
      public final String getString() { return BridgeJni.getString(); }

      private Companion() {}

      public Companion(DefaultConstructorMarker $constructor_marker) { this(); }
   }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Kotlin</span> <span style="text-transform: none; font-size:0.8em;">Jni</span>

```cpp
#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_mwm_demo_1kotlin_jni_BridgeJni_getString(
        JNIEnv *env,
        jclass /* this */) {
    return env->NewStringUTF("Hello");
}
```

Note:

- Like Java, package with `_` should have `1` before

---

### End

