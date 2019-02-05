![Logo](mwm-5-dynamic-delivery/presentation/logo-1.gif)

#### <span style="text-transform: none">Dynamic delivery</span>

<span style="color:gray; font-size:0.6em;">Android </span> <span style="color: #00B8D4; font-size:0.6em;">module</span>
<br/>
<span style="color:gray; font-size:0.5em;">02-2019</span>
<br/>
<span style="color:gray; font-size:0.4em;">Frédéric Torcheux. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">bowserf</span>
<br/>
<span style="color:gray; font-size:0.4em;">Jonathan Mercandalli. Github: </span> <span style="color: #00B8D4; font-size:0.4em;">Mercandj</span>


Note:

- Version of kotlin is important, all result could change in next / previous version
- Find the presentation and source [here](https://github.com/Mercandj/presentation)
- Next kotlin version already here -> **1.2.61**

---

### Goal!

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Dynamic module gradle</span>


---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Generate APKs from App Bundle with BundleTool</span>

```
bundletool build-apks
--bundle=edjingFree.aab
--output=edjingFree.apks
--ks=/path/to/keystore.jks
--ks-pass=pass:PASSWORD
--ks-key-alias=androidreleasekey
--key-pass=pass:PASSWORD
```

This generate an APK set archive `.apks`

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Generate APKs from App Bundle with BundleTool</span>

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

Only generate a set of APKs according to the configuration of the connected devide.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Install an application from a set of APKs with BundleTool</span>

```
bundletool install-apks
--apks=edjingFree.apks
```

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Other features of BundleTool</span>

- Build app bundle from device specification file
- Generate device specification file from connected device
- Extract device specific APKs from an existing APK set

Note:

- `bundletool build-apks --device-spec=device_spec.json`
- `bundletool get-device-spec`
- `bundletool extract-apks`
- adb install-multiple : install several apks at a time.

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Codelab</span>

---

### <span style="color: #00B8D4; text-transform: none; font-size:0.8em;">Sources</span>

- https://developer.android.com/studio/command-line/bundletool
- https://github.com/google/bundletool

https://codelabs.developers.google.com/codelabs/on-demand-dynamic-delivery

