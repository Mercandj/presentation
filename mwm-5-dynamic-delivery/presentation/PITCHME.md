![Logo](mwm-5-dynamic-delivery/presentation/logo-1.gif)

#### <span style="text-transform: none">App bundle and Dynamic delivery</span>

<span style="color:gray; font-size:0.6em;">Android </span> <span style="color: #00B8D4; font-size:0.6em;">module</span>
<br/>
<span style="color:gray; font-size:0.5em;">02-2019</span>
<br/>
<span style="color:gray; font-size:0.4em;">Frédéric Torcheux. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">bowserf</span>
<br/>
<span style="color:gray; font-size:0.4em;">Jonathan Mercandalli. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">Mercandj</span>
<br/>
<span style="color:gray; font-size:0.3em;">Version "com.google.android.play:core:1.3.6"</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android</span><span style="text-transform: none; font-size:0.8em;"> App Bundle</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android</span><span style="text-transform: none; font-size:0.8em;"> App Bundle</span>

- New format to `upload` application.
- Contains code and all resources.
- Play Store generates APKS from this file.
- According device spec, it will only download required APKs.

---


### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">edjingFree APKs</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/edjingfree-apks-pixel-en-ko.png)

Generate APKs for a Pixel phone with english and korean languages.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android</span><span style="text-transform: none; font-size:0.8em;"> App Bundle</span>

- Reduce the quantity of data to download.
- Reduce the app weight on the disk.

Note:

- Only download usefull features.
- Reduce the weight to not appear at the top of the list of heavier apps, to avoid to be uninstall

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Look into an AAB file</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/aab-format.png)

Note:

- Each part represents a different module of the app.
- Dynamic feature module name is given the name specified by the split attribute in the module's manifest.
- BUNDLE-METADATA/: contains metadata files such as proguard mappings and the list of all DEX files. These files are not packaged into the APK.
- dex/: contains dex files for this module.
- res/, lib/ and assets/: identical to those in a typical APK.
- manifest/: contains androidManifest.xml file.
- root/: contains other files present to the root of an APK.
- Module Protocol Buffer(.pb): BundleConfig.pb contains metadata such as which version of the build tools has been used
- resources.pb, native.pb: describe the code and resources in each module

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Inside edjing Free app bundle</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/edjing-free-app-bundle.png)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Inside edjing Free app bundle</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/edjing-free-app-bundle-details.png)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Configure App Bundle for your application</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Configure App Bundle for your application</span>

```
android {
    ...
    bundle {
        language {
            enableSplit = true
        }
        density {
            enableSplit = true
        }
        abi {
            enableSplit = true
        }
    }
    ...
}
```

Add this code to ``build.gradle`` of your application.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">How it works</span><span style="text-transform: none; font-size:0.8em;"> for old devices</span>

- Pre-Lollipop devices download an optimized APK.
- Pre-Lollipop devices  don't manage multiples APKs.
- Optimized APK contains all available languages.

Note:

- Downloaded APK has only ABI and dimen resources for the target.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Application size</span><span style="text-transform: none; font-size:0.8em;"> limitation</span>

- Increase app size limit to 500MB.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">BundleTool</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Generate APKs from App Bundle</span>

```
bundletool build-apks
--bundle=edjingFree.aab
--output=edjingFree.apks
--ks=/path/to/keystore.jks
--ks-pass=pass:PASSWORD
--ks-key-alias=ALIAS
--key-pass=pass:PASSWORD
```

This generates an APK set archive `.apks`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Generate APKs from App Bundle</span>

`--connected-device` option

```
bundletool build-apks
--bundle=edjingFree.aab
--output=edjingFree.apks
--ks=/path/to/keystore.jks
--ks-pass=pass:PASSWORD
--ks-key-alias=ALIAS
--key-pass=pass:PASSWORD
--connected-device
```

Generate an APKs set according to the configuration of the connected devide.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Install an application from a set of APKs</span>

```
bundletool install-apks
--apks=edjingFree.apks
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Other features</span>

- Build app bundle from device specification file
- Generate device specification file from connected device
- Extract device specific APKs from an existing APK set

Note:

- `bundletool build-apks --device-spec=device_spec.json`
- `bundletool get-device-spec`
- `bundletool extract-apks`
- adb install-multiple : install several apks at a time.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic Feature</span>

---


### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic feature</span><span style="text-transform: none; font-size:0.8em;"> Goal</span>

- Runtime module download
- Reduce base APK size
- Remove feature from the disk


---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic feature</span><span style="text-transform: none; font-size:0.8em;"> Setup</span>

---?image=mwm-5-dynamic-delivery/presentation/tuto-1.png&size=auto 80%

---?image=mwm-5-dynamic-delivery/presentation/tuto-2.png&size=auto 80%

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Base module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

<br/>

```groovy
android {
   // ...
   dynamicFeatures = [":app_search_dynamic"]
}
```
```groovy
dependencies {
    api "com.google.android.play:core:1.3.6"
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Base module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

```groovy
dependencies {
   implementation project(":app_search_dynamic") <- TO REMOVE
   api "com.google.android.play:core:1.3.6"
}
```

Remove in the base module the dependency to the dynamic module.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Base module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

```groovy
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'
apply plugin: 'kotlin-kapt'
apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    defaultConfig {
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode rootProject.ext.appVersionCode
        versionName rootProject.ext.appVersionName
    }

    bundle {
        density.enableSplit = true
        abi.enableSplit = true
        language.enableSplit = false
    }

    buildTypes {
        release {
            minifyEnabled true
            shrinkResources false
            multiDexEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
        debug {
            shrinkResources false
        }
    }

    dynamicFeatures = [":app_search_dynamic"]
}

dependencies {
    api project(':file_api')
}
```

@[17-21](App bundle)
@[26,31](Do not shrink)
@[35](Dynamic features declaration)
@[39](Api dependency used by the dynamic module)




---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

<br/>

```groovy
apply plugin: 'com.android.dynamic-feature'
```

```groovy
dependencies {
    implementation project(':app')
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

```groovy
apply plugin: 'com.android.dynamic-feature'
apply plugin: 'kotlin-android-extensions'
apply plugin: 'kotlin-android'

android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    defaultConfig {
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode rootProject.ext.appVersionCode
        versionName rootProject.ext.appVersionName
    }
}

dependencies {
    implementation project(':app')
    implementation project(':file_api_android')
}

repositories {
    mavenCentral()
}
```

@[1](Plugin)
@[18](Base dependence)
@[19](Other classic module that is not api by the app module)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> Manifest</span>

<br/>

```xml
<manifest
    ...
    xmlns:dist="http://schemas.android.com/apk/distribution">

    <dist:module
        dist:onDemand="true"
        dist:title="@string/title_app_search_dynamic">
        <dist:fusing dist:include="true" />
    </dist:module>
</manifest>
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> Manifest</span>

<br/>

```xml
<dist:module
    ...
    dist:title="@string/title_app_search_dynamic">
</dist:module>
```

- `title_app_search_dynamic` should be defined in the base module.
- Is used to identify and download the module from the Play Store.
- Use in the consent dialog to describe the module.

Note:

- The dynamic module title can be translated.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> Manifest</span>

<br/>

```xml
<dist:module
    ...
    dist:onDemand="true">
</dist:module>
```

- Set the module available for on-demand download.
- If set to false, module is downloaded when user download the app.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> Manifest</span>

<br/>

```xml
<dist:module ...>
    <dist:fusing dist:include="true" />
</dist:module>
```

- True to set the module available to device running Android 4.4 and lower.
- Option only available if `onDemand="true"`.

Note:

- enable on-demandd and disable fusing will avoid devices that don't support downloading and installing split APKs.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> Manifest</span>

<br/>

```xml
<application
android:hasCode="false">
...
</application>
```

- When module has no code, we need to indicate it to avoid runtime error.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic feature</span><span style="text-transform: none; font-size:0.8em;"> API</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Base module</span><span style="text-transform: none; font-size:0.8em;"> SplitInstallManager</span>

<br/>

```kotlin
interface SplitInstallManager {
    fun startInstall(request: SplitInstallRequest): Task<Int>
    fun cancelInstall(sessionId: Int): Task<Void>
    fun getSessionState(): Task<List<SplitInstallSessionState>>
    fun getSessionState(sessionId: Int): Task<SplitInstallSessionState>
    fun deferredUninstall(featureModuleNames: List<String>): Task<Void>
    fun deferredInstall(featureModuleNames: List<String>): Task<Void>
    fun getInstalledModules(): Set<String>

    fun registerListener(listener: SplitInstallStateUpdatedListener)
    fun unregisterListener(listener: SplitInstallStateUpdatedListener)
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Install</span><span style="text-transform: none; font-size:0.8em;"> a dynamic module</span>

<br/>

```kotlin
val splitInstallManager = SplitInstallManagerFactory.create(context)
val name = context.getString(R.string.title_app_search_dynamic)

// check if we already have the module
if (!splitInstallManager.installedModules.contains(name)) {
    // Create request to install a feature module by name.
    val request = SplitInstallRequest.newBuilder()
        .addModule(name)
        .build()

    // Load and install the requested feature module.
    splitInstallManager.startInstall(request)
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Install</span><span style="text-transform: none; font-size:0.8em;"> a dynamic module</span>

<br/>

```kotlin
splitInstallManager.startInstall(request)
     // When the platform accepts your request to download
     // an on demand module, it binds it to the following session ID.
     // You use this ID to track further status updates for the request.
     .addOnSuccessListener {
         // From here the install started and splitInstallManager
         // could be called with the install session id.
         this.sessionId = it
     }
     .addOnCompleteListener {
         this.sessionId = -1
         this.startSearch()
     }
     .addOnFailureListener {
         this.sessionId = -1
         this.showErrorMessage()
     }
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Deferred</span><span style="text-transform: none; font-size:0.8em;"> install</span>

<br/>

```kotlin
splitInstallManager.deferredInstall(Arrays.asList(featureModuleName))
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Install request</span><span style="text-transform: none; font-size:0.8em;"> listener</span>

<br/>

```kotlin
val listener = SplitInstallStateUpdatedListener { state ->
    state.moduleNames().forEach { name ->
        when (state.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> { ... }
            SplitInstallSessionStatus.DOWNLOADED -> { ... }
            SplitInstallSessionStatus.INSTALLING -> { ... }
            SplitInstallSessionStatus.INSTALLED -> { ... }
            SplitInstallSessionStatus.CANCELING -> { ... }
            SplitInstallSessionStatus.CANCELED -> { ... }
            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> { ... }
            SplitInstallSessionStatus.FAILED -> { ... }
            SplitInstallSessionStatus.PENDING -> { ... }
            SplitInstallSessionStatus.UNKNOWN -> { ... }
        }
    }
}
manager.registerListener(listener)
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Install request</span><span style="text-transform: none; font-size:0.8em;"> listener</span>

<br/>

```kotlin
val listener = SplitInstallStateUpdatedListener { state ->
    state.moduleNames().forEach { name ->
        when (state.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> {
                val bytesDownloaded = state.bytesDownloaded()
                val totalBytesToDownload = state.totalBytesToDownload()
                val percentDownloaded = if (totalBytesToDownload <= 0) {
                    0f
                } else {
                    bytesDownloaded.toFloat() / totalBytesToDownload
                }
                notifyDownloading(percentDownloaded)
            }
        }
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Uninstall</span><span style="text-transform: none; font-size:0.8em;"> dynamic module</span>

- The uninstallation is not immediate.
- The device decides when it will remove the module.

```kotlin
SplitInstallManager.deferredUninstall(List<String> moduleNames)
```

- We can remove useless dynamic module (ex: Onboarding).

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">User consent</span><span style="text-transform: none; font-size:0.8em;"> to download module(s)</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">User consent</span><span style="text-transform: none; font-size:0.8em;"> to download module(s)</span>

- If a module, or a list of modules need to be downloaded, during a certain period of time, are heavier than 10MB, the user's consent must be requested.
- For defer installations, the limit is 100MB.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">User consent</span><span style="text-transform: none; font-size:0.8em;"> to download module(s)</span>

<br/>

```kotlin
private val listener = SplitInstallStateUpdatedListener { state ->
    state.moduleNames().forEach { name ->
        when (state.status()) {
            ...
            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                // This may occur when attempting to download a sufficiently large module.
                startIntentSender(state.resolutionIntent()?.intentSender, null, 0, 0, 0)
            }
        }
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Access</span><span style="text-transform: none; font-size:0.8em;"> to code and resources</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Enable</span><span style="text-transform: none; font-size:0.8em;"> the SplitCompat Library</span>

```xml
<application
    ...
    android:name="com.google.android.play.core.splitcompat
        .SplitCompatApplication">
</application>
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Enable</span><span style="text-transform: none; font-size:0.8em;"> the SplitCompat Library</span>

```kotlin
class MyApplication: SplitCompatApplication() {
    ...
}

```
or
```kotlin
override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    SplitCompat.install(this)
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Enable</span><span style="text-transform: none; font-size:0.8em;"> the SplitCompat Library</span>


Call `SplitCompat.install(this)` in activities of a dynamic module

```kotlin
class SearchActivity : AppCompatActivity() {
    ...
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.install(this)
    }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Update</span><span style="text-transform: none; font-size:0.8em;"> base context</span>

- Context created at app launch doesn't contain the content of the new module.
- We need to create a new one.

```kotlin
val newContext = context.createPackageContext(context.getPackageName(), 0)
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Start</span><span style="text-transform: none; font-size:0.8em;"> "dynamic" activity</span>

<br/>

```kotlin
override fun startSearch() {
    val intent = Intent()
    if (context !is Activity) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
    }
    intent.setClassName(
        "com.mwm.android.apps.sample",
        "com.mwm.android.apps.sample.search_dynamic.SearchActivity"
    ).also { context.startActivity(it) }
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Load native library</span><span style="text-transform: none; font-size:0.8em;"> in dynamic module</span>

```kotlin
System.loadLibrary("search-feature-native-lib")
```

It won't work for a library inside dynamic module. Instead use:

```kotlin
SplitInstallHelper.loadLibrary(context, "search-feature-native-lib")
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Problem</span><span style="text-transform: none; font-size:0.8em;"> with resources</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Conflict</span><span style="text-transform: none; font-size:0.8em;"> with shrinkResources</span>

```
android {
    ...
    buildTypes {
        release {
            shrinkResources false
        }
    }
}
```

Do not enable `shrinkResources` for a dynamic module or base module.

Otherwise, this error will occurred:

```
Resource shrinker cannot be used for multi-apk applications
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Resources</span><span style="text-transform: none; font-size:0.8em;"> used in AndroidManifest</span>

- `MyDynamicModuleActivity` and `MyTheme` are defined in a dynamic module.

```xml
<application>
    <activity
        android:name=".MyDynamicModuleActivity"
        android:theme="@style/MyTheme" />
</application>
```

- In the mergedManifest, the style is unknown !
- Define empty resource in the base module.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Run</span><span style="text-transform: none; font-size:0.8em;"> Debug</span>

---?image=mwm-5-dynamic-delivery/presentation/run-debug-1.png&size=auto 80%

Note:

- You can choose which dynamic features to include when deploying your app

---?image=mwm-5-dynamic-delivery/presentation/run-debug-2.png&size=auto 80%

Note:

- By default, Android Studio doesn’t use app bundles to deploy your app. It builds and pushes APKs to your device that are optimized for deployment speed, rather than APK size. To configure Android Studio to instead build and deploy APKs from an app bundle, modify your run/debug configuration and select the option to deploy APK from app bundle.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Go</span><span style="text-transform: none; font-size:0.8em;"> further</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Clear</span><span style="text-transform: none; font-size:0.8em;"> app storage from settings</span>

- Makes `installedModules.contains(name)` returning false
- Does not uninstall apk, the next `startInstall(request)` is almost synchronous

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Code </span><span style="text-transform: none; font-size:0.8em;"> shrinking</span>

- To enable code shrinking for entire project, you must do so from the base module’s build.gradle file
- MinifyEnabled property in dynamic feature module build configurations is ignored

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Version</span>

- Your base module and dynamic feature apks will share the same version code and version name
- The base module version code and version name is the reference

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Open </span><span style="text-transform: none; font-size:0.8em;"> question</span>

- Cascade of dynamic modules?
- Shrink resources for the base module?

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Google</span><span style="text-transform: none; font-size:0.8em;"> Codelab</span>

<br/>

[On demand dynamic delivery](https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Open sources</span><span style="text-transform: none; font-size:0.8em;"> examples</span>

<br/>

- [Plaid](https://github.com/nickbutcher/plaid)
- [FileSpace](https://github.com/Mercandj/file-android)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Sources</span>

<br/>

- [About Android App Bundles](https://developer.android.com/guide/app-bundle/)
- [Dynamic delivery](https://developer.android.com/studio/projects/dynamic-delivery)
- [Play Core library](https://developer.android.com/guide/app-bundle/playcore)
- [BundleTool doc](https://developer.android.com/studio/command-line/bundletool)
- [Download BundleTool](https://github.com/google/bundletool)
