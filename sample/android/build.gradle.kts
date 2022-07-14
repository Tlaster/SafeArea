plugins {
    id("org.jetbrains.compose") version Versions.compose_jb
    id("com.android.application")
    kotlin("android")
}

group = "moe.tlaster"
version = "1.0"

dependencies {
    implementation(project(":sample:common"))
    implementation("androidx.activity:activity-compose:1.5.0")
}

android {
    compileSdk = Versions.Android.compile
    buildToolsVersion = Versions.Android.buildTools
    defaultConfig {
        applicationId = "moe.tlaster.safearea_sample"
        minSdk = Versions.Android.min
        targetSdk = Versions.Android.target
        versionCode = 1
        versionName = "0.1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = Versions.Java.java
        targetCompatibility = Versions.Java.java
    }
}
