![Logo](mwm-3-kotlin-1/presentation/logo-1.png)

#### <span style="text-transform: none">Koltin - 1</span>

<span style="color:gray; font-size:0.5em;">Github </span> <span style="color: #00B8D4; font-size:0.5em;">Mercandj/presentation</span>
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

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Nullity</span> <span style="text-transform: none; font-size:0.8em;">in constructor</span>
<br/>

```kotlin
class NullityDemo(
        nonNullString: String,
        nullableString: String?
)
```

<span style="color:gray; font-size:0.6em;">NullityDemo.kt</span>
<br/>
<br/>

```java
public final class NullityDemo {
   public NullityDemo(@NotNull String nonNullString, @Nullable String nullableString) {
      Intrinsics.checkParameterIsNotNull(nonNullString, "nonNullString");
      super();
   }
}
```

<span style="color:gray; font-size:0.6em;">NullityDemo.java</span>

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

### Demo

---


### Speakers

- <span style="color:gray; font-size:0.5em;">Frédéric Torcheux. Github: </span> <span style="color: #00B8D4; font-size:0.5em;">bowserf</span>
- <span style="color:gray; font-size:0.5em;">Jonathan Mercandalli. Github: </span> <span style="color: #00B8D4; font-size:0.5em;">Mercandj</span>

