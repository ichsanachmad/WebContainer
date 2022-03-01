<h1 align="center" style="border-bottom: none;">
    WebContainer 
    <p align="center">
      <a href="https://twitter.com/intent/tweet?text=Web Container for your Android WebView&url=https://github.com/ichsanachmad/WebContainer/"><img src="https://img.shields.io/badge/Tweet--white?style=social&logo=twitter" alt="build"></a>
      <a href="https://jitpack.io/#ichsanachmad/WebContainer"><img src="https://jitpack.io/v/ichsanachmad/WebContainer.svg" alt="build"></a>
      <a href="https://github.com/ichsanachmad/"><img src="https://img.shields.io/badge/GitHub--white?style=social&logo=github" alt="codecov"></a>
    </p>
</h1>


## Description

Web Container is a simple web container library for Android to help fellow developer to open WebView easily and we made it with a simple syntax. This library is written in Kotlin and published in JitPack.io

## How To Install

Step 1. Add the JitPack repository to your build file
  
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```gradle
dependencies {
  implementation 'com.github.ichsanachmad:WebContainer:v1.2.0'
}
```

## How to Use
Init WebContainer on Application 

_Application.kt_ (Kotlin):
```kotlin
WebContainer.init(application: Application)
```

AndroidManifest.xml (Kotlin):
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    ...>

    <application
        android:name=".Application"
        ...
    </application>
</manifest>
```

**Simple Usage WebContainer**

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

**WebContainer with Callback Listener**

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
WebContainer.launch(Url: String, object:WebContainerListener {
    override fun callback(json: String) {
        // ToDo
    }
}, enableSwipeRefresh: Boolean)
```

HTML/JS:
```html
<input type="button" value="Say hello" onClick="showAndroidToast('Hello Android!')" />

<script type="text/javascript">
    function showAndroidToast(message) {
        AndroidAppCallback.callback(message);
    }
</script>
```

React JS :
```javascript
class ClassA extends React.PureComponent {

    ...

    private handleRedirect = () => {
        if (window.AndroidAppCallback)
            window.AndroidAppCallback.callback("Test");
    };
}
```
