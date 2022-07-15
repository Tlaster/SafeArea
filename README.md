# SafeArea
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/moe.tlaster/safearea/badge.svg)](https://maven-badges.herokuapp.com/maven-central/moe.tlaster/safearea)
[![compose-jb-version](https://img.shields.io/badge/compose--jb-1.2.0--alpha01--dev745-blue)](https://github.com/JetBrains/compose-jb)
![license](https://img.shields.io/github/license/Tlaster/SafeArea)

![badge-android](https://img.shields.io/badge/Platform-Android-brightgreen)
![badge-ios](https://img.shields.io/badge/Platform-iOS-lightgray)
![badge-jvm](https://img.shields.io/badge/Platform-JVM-orange)

SafeArea for Compose multiplatform

# Setup
```
api("moe.tlaster:safearea:$safearea_version")
```
## Android
Nothing to setup.
## Desktop
Warp your App in with `ProvideSafeArea()` like this
```Kotlin
fun main() {
    application {
        Window {
            ProvideSafeArea {
                App()
            }
        }
    }
}
```
## iOS
Warp your App with `ProvideSafeArea(window: UIWindow)` like this
```Kotlin
window = UIWindow(frame = UIScreen.mainScreen.bounds).apply {
    rootViewController = Application("SafeArea") {
        ProvideSafeArea(this) {
            App()
        }
    }
    makeKeyAndVisible()
}
```

# Usage
Warp your content in `SafeArea`, the content will be displayed in safe area
```Kotlin
SafeArea {
    Column(
        modifier = Modifier.background(Color.Cyan).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("Hello World!")
        Text("in SafeArea")
    }
}
```


# LICENSE
```
MIT License

Copyright (c) 2022 Tlaster

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
