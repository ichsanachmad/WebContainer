<h1 align="center" style="border-bottom: none;">
    WebContainer 
    <p align="center">
       <a href="https://twitter.com/intent/tweet?text=Web Container for your Android WebView&url=https://github.com/ichsanachmad/WebContainer/"><img src="https://img.shields.io/badge/Tweet--white?style=social&logo=twitter" alt="twitter"></a>
      <a href="https://github.com/ichsanachmad/"><img src="https://img.shields.io/badge/GitHub--white?style=social&logo=github" alt="github author"></a>
      <a href="https://github.com/ichsanachmad/WebContainer/actions/workflows/android.yml"><img src="https://github.com/ichsanachmad/WebContainer/actions/workflows/android.yml/badge.svg?branch=master" alt="build"></a>
      <a href="https://jitpack.io/#ichsanachmad/WebContainer"><img src="https://jitpack.io/v/ichsanachmad/WebContainer.svg" alt="jitpack"></a>
<a href="https://app.fossa.com/projects/git%2Bgithub.com%2Fichsanachmad%2FWebContainer?ref=badge_shield" alt="FOSSA Status"><img src="https://app.fossa.com/api/projects/git%2Bgithub.com%2Fichsanachmad%2FWebContainer.svg?type=shield"/></a>
      <a href="https://www.codacy.com/gh/ichsanachmad/WebContainer/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=ichsanachmad/WebContainer&amp;utm_campaign=Badge_Grade"><img src="https://app.codacy.com/project/badge/Grade/c51cab0dcc56431bbda3e6e007c8e916" alt="jitpack"></a>
    </p>
</h1>

a
## Description

Web Container is a simple web container library for Android to help fellow developer to open WebView easily and we made it with a simple syntax. This library is written in Kotlin and published in JitPack.io

## How To Install

Step 1. Add the JitPack repository


Gradle 6.x.x (on build project file):  
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```


Gradle 7.x.x (on settings.gradle file): 
```gradle
dependencyResolutionManagement {
    ...
    repositories {
       ...
       maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```gradle
dependencies {
  implementation 'com.github.ichsanachmad:WebContainer:${version}'
}
```

## How to Use
### Initialization WebContainer on Application

This is the default initialization of WebContainer 

_Application.kt_ (Kotlin):
```kotlin
class App : Application() {
    override fun onCreate() {
        ...
        WebContainer.init(this)
    }
}
```

but that initialization is default init, we can do some change on the User Agent, this is the example:

```kotlin
class App : Application() {
    override fun onCreate() {
        ...
        WebContainer.init(this, UserAgent.CHROME)
    }
}
```

_AndroidManifest.xml_:
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    ...>

    <application
        android:name=".App"
        ...
    </application>
</manifest>
```

---

### Simple Usage WebContainer

_without Swipe Refresh_

Kotlin:
```kotlin
WebContainer.launch(url: String)
```

_with Swipe Refresh_

Kotlin:
```kotlin
WebContainer.launch(url: String, enableSwipeRefresh: Boolean)
```

---

### WebContainer with Callback Listener

_without Swipe Refresh_

Kotlin:
```kotlin
WebContainer.launch(Url: String, object:WebContainerListener {
    override fun callback(json: String) {
        // ToDo
    }
})
```

_with Swipe Refresh_

Kotlin:
```kotlin
WebContainer.launch(Url: String, enableSwipeRefresh: Boolean, object:WebContainerListener {
    override fun callback(json: String) {
        // ToDo
    }
})
```

---

### Trigger Callback from Web

_HTML/JS_:
```html
<input type="button" value="Say hello" onClick="showAndroidToast('Hello Android!')" />

<script type="text/javascript">
    function showAndroidToast(message) {
        AndroidAppCallback.callback(message);
    }
</script>
```

_React JS_ :
```javascript
class ClassA extends React.PureComponent {

    ...

    private handleRedirect = () => {
        if (window.AndroidAppCallback)
            window.AndroidAppCallback.callback("Test");
    };
}
```

---

### Extension

#### Check is URL

Kotlin:
```kotlin
    String.isUrl() // For Checking your String is Valid URL or Not
```

### Utilities

#### User Agent

```kotlin
    UserAgent.CHROME //if you want to define your web view using Chrome User agent 
    UserAgent.FIREFOX //if you want to define your web view using Firefox User agent 
    UserAgent.OPERA //if you want to define your web view using Opera User Agent
    UserAgent.SAFARI //if you want to define your web view using Safari User Agent
    UserAgent.DEFAULT // Device user agent
```

---

## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2Fichsanachmad%2FWebContainer.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2Fichsanachmad%2FWebContainer?ref=badge_large)

