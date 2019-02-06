![Logo](mwm-5-dynamic-delivery/presentation/logo-1.gif)

#### <span style="text-transform: none">App bundle and Dynamic delivery</span>

<span style="color:gray; font-size:0.6em;">Android </span> <span style="color: #00B8D4; font-size:0.6em;">module</span>
<br/>
<span style="color:gray; font-size:0.5em;">02-2019</span>
<br/>
<span style="color:gray; font-size:0.4em;">Frédéric Torcheux. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">bowserf</span>
<br/>
<span style="color:gray; font-size:0.4em;">Jonathan Mercandalli. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">Mercandj</span>

---

### Goal!

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android App Bundle</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android App Bundle</span>

- Reduce the quantity of data to download.
- Reduce the app weight on the disk.

Note:

- Only download usefull features.
- Reduce the weight to not appear at the top of the list of heavier apps, to avoid to be uninstall

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android App Bundle</span>

- Increase app size limit to 500MB.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Android App Bundle</span>

- Pre-Lollipop devices download an optimized APK.
- Pre-Lollipop devices  don't manage multiples APKs.
- Optimized APK contains all available languages.

Note:

- Downloaded APK has only ABI and dimen resources for the target.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Look into an AAB file</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/aab-format.png)

Note:

- Each part represents a different module of the app.
- Dynamic feature module name is given the name specified by the split attribute in the module's manifest.
- BUNDLE-METADATA/: contains metadata files such ss proguard mappings and the list of all DEX files. These files are not packaged into the APK.
- dex/: contains dex files for this module.
- res/, lib/ and assets/: identical to those in a typical APK.
- manifest/: contains androidManifest.xml file.
- root/: contains other files present to the root of an APK.
- Module Protocol Buffer(.pb): BundleConfig.pb contains metadata such as which version of the build tools has been used
- resources.pb, native.pb: describe the code and resources in each module

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Inside edjing Free app bundle</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/android-app-bundle.png)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Inside edjing Free app bundle</span>

![Inside edjing Free app bundle](mwm-5-dynamic-delivery/presentation/android-app-bundle-details.png)

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Configure App Bundle for your application</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Configure App Bundle for your application</span>

```
android{
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

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">BundleTool</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Generate APKs from App Bundle</span>

```
bundletool build-apks
--bundle=edjingFree.aab
--output=edjingFree.apks
--ks=/path/to/keystore.jks
--ks-pass=pass:PASSWORD
--ks-key-alias=androidreleasekey
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
--ks-key-alias=androidreleasekey
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

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Base module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

<br/>

```
android {
   // ...
   dynamicFeatures = [":app_search_dynamic"]
}
```
```
dependencies {
	implementation project(":app_search_dynamic") <-- TO REMOVE
    api "com.google.android.play:core:1.3.6"
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> build.gradle</span>

<br/>

```
apply plugin: 'com.android.dynamic-feature'
```

```
dependencies {
    implementation project(':app')
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module</span><span style="text-transform: none; font-size:0.8em;"> Manifest</span>

<br/>

```xml
<dist:module
    dist:instant="false"
    dist:onDemand="true"
    dist:title="@string/title_app_search_dynamic">

    <dist:fusing dist:include="true" />

</dist:module>
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic feature</span><span style="text-transform: none; font-size:0.8em;"> API</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Base module</span><span style="text-transform: none; font-size:0.8em;"> SplitInstallManager</span>

<br/>

```kotlin
val splitInstallManager = SplitInstallManagerFactory.create(context)
```

```java
public interface SplitInstallManager {
    Task<Integer> startInstall(SplitInstallRequest request);
    Task<Void> cancelInstall(int sessionId);
    Task<SplitInstallSessionState> getSessionState(int sessionId);
    Task<List<SplitInstallSessionState>> getSessionStates();
    Task<Void> deferredUninstall(List<String> featureModuleNames);
    Task<Void> deferredInstall(List<String> featureModuleNames);
    Set<String> getInstalledModules();

    void registerListener(SplitInstallStateUpdatedListener listener);
    void unregisterListener(SplitInstallStateUpdatedListener listener);
}
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Codelab</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Sources</span>

- https://developer.android.com/studio/command-line/bundletool
- https://github.com/google/bundletool

https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery

