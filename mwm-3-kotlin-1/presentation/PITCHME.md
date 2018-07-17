![Logo](mwm-3-kotlin-1/presentation/logo-1.png)

#### <span style="text-transform: none">Koltin - 1</span>

<span style="color:gray; font-size:0.5em;">Github </span> <span style="color: #00B8D4; font-size:0.5em;">Mercandj/presentation</span>
<br/>
<span style="color:gray; font-size:0.4em;">Kotlin </span> <span style="color: #00B8D4; font-size:0.4em;">1.2.51</span>
<br/>
<span style="color:gray; font-size:0.4em;">19-07-2018</span>

---

### <span style="color: #00B8D4; text-transform: none;">Presentation</span> <span style="text-transform: none;">goals</span>
<br/>

In the Android developer context:

<span style="color:gray; font-size:0.5em;">
    - Why use this langage
    - Where use this langage
    - What is the cost/overhead
    - Decompile basic Kotlin to Java
</span>

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">pros</span>

* Strongly typed
* More concise and readable than Java
* "Lightweight"
* JetBrains
* ...

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">cons</span>

* Overhead
* Team skills
* New languages
* Versions

---

### <span style="color: #00B8D4; text-transform: none;">Kotlin</span> <span style="text-transform: none;">methods</span>

<p style="height:11em;">
![Logo](mwm-3-kotlin-1/presentation/logo-2-kotlin-methods-1-2-51.png)
</p>

<span style="color:gray; font-size:0.4em;">Kotlin 1.2.51 (demo app) - com.getkeepsafe.dexcount</span>

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

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">decompiler</span>

![Logo](mwm-3-kotlin-1/presentation/logo-3-decompiler.png)

---

### <span style="color: #00B8D4; text-transform: none">Kotlin</span> <span style="text-transform: none">decompiler</span>

![Logo](mwm-3-kotlin-1/presentation/logo-4-decompiler.png)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Hello</span> <span style="text-transform: none; font-size:0.8em;"> World</span>
<br/>

```kotlin
fun start(): String = "Hello World"
```

```java
public final class TaskKt {
   @NotNull
   public static final String start() {
      return "Hello World";
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
   CharSequence var2 = (CharSequence)str;
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

![Logo](mwm-3-kotlin-1/presentation/logo-5-variable-shadowing.png)

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
      this((String)null, 1, (DefaultConstructorMarker)null);
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

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range</span>

```kotlin
fun basicRange(){
    for(i in 1..10){
        Log.i(TAG, "i : $i")
    }
}

```
<span style="color:gray; font-size:0.6em;">RangeTester.kt</span>

```java
public final void basicRange() {
	int i = 1;
	for (byte var2 = 10; i <= var2; ++i) {
		Log.i("RangeTester", "i : " + i);
	}
}
```
<span style="color:gray; font-size:0.6em;">RangeTester.java</span>

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
    for(i in 0 until 10){
        Log.i(TAG, "i : $i")
    }
}
```
<span style="color:gray; font-size:0.6em;">RangeTester.kt</span>


---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range with a cost</span>

```kotlin
fun stepRange() {
    for(i in 0..10 step 2) {
        Log.i(TAG, "i : $i")
    }
}
```
<span style="color:gray; font-size:0.6em;">RangeTester.kt</span>

/!\ Instantiation of 2 temporaries objects : `IntProgression` and `IntRange`.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">on a range with a cost</span>

```java
public final void stepRange() {
    byte var4 = 0;
    IntProgression var10000 = RangesKt.step((IntProgression)(new IntRange(var4, 10)), 2);
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
<span style="color:gray; font-size:0.6em;">RangeTester.java</span>

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
<span style="color:gray; font-size:0.6em;">RangeTester.kt</span>

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
<span style="color:gray; font-size:0.6em;">RangeTester.java</span>

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
<span style="color:gray; font-size:0.6em;">ForDemo.kt</span>

```java
public final void testForEachOnRange() {
	byte var1 = 1;
	Iterable $receiver$iv = (Iterable)(new IntRange(var1, 10));
	Iterator var2 = $receiver$iv.iterator();

	while (var2.hasNext()) {
		int element$iv = ((IntIterator)var2).nextInt();
		Log.i("", "i : " + element$iv);
	}
}
```
<span style="color:gray; font-size:0.6em;">ForDemo.java</span>

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
<span style="color:gray; font-size:0.6em;">ForDemo.kt</span>

```java
public final void testForEachOnIterator1() {
	Iterable $receiver$iv = (Iterable)list;
	Iterator var2 = $receiver$iv.iterator();

	while (var2.hasNext()) {
			Object element$iv = var2.next();
			int it = ((Number)element$iv).intValue();
			Log.i("", "i : " + it);
	}
}
```
<span style="color:gray; font-size:0.6em;">ForDemo.java</span>

No additionnaly cost. 

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Loop</span> <span style="text-transform: none; font-size:0.8em;">with indices</span>

Can loop on list indices without additionnal cost.

```kotlin
fun testForWithIndices() {
    for (i in list.indices) {
        Log.i(TAG, "i : " + list[i])
    }
}
```
<span style="color:gray; font-size:0.6em;">ForDemo.kt</span>

```java
public final void testForWithIndices() {
    int i = 0;
    for (int var2 = ((Collection)list).size(); i < var2; ++i) {
        Log.i("", "i : " + (Integer)list.get(i));
    }
}
```
<span style="color:gray; font-size:0.6em;">ForDemo.java</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Extend</span> <span style="text-transform: none; font-size:0.8em;">from a parent</span>

In Kotlin, class and methods are `final` by default.

`open` keyword required to be able to extend from class/method :

```kotlin
open class Animal(){
	open fun myOpenedFunction() {}
}
class Dog() : Animal(){
	override fun myOpenedFunction() {}
}
```

`override` language keyword required to override a method.

---

### Demo

---


### Speakers

- <span style="color:gray; font-size:0.5em;">Frédéric Torcheux. Github: </span> <span style="color: #00B8D4; font-size:0.5em;">bowserf</span>
- <span style="color:gray; font-size:0.5em;">Jonathan Mercandalli. Github: </span> <span style="color: #00B8D4; font-size:0.5em;">Mercandj</span>

