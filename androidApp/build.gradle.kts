import org.jetbrains.compose.compose

plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "aaa.bivizul.a31project.android"
    compileSdk = Deps.Versions.compileSdk
    defaultConfig {
        applicationId = "aaa.bivizul.a31project.android"
        minSdk = Deps.Versions.minSdk
        targetSdk = Deps.Versions.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Deps.Versions.composeCompiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(":shared"))
//    implementation("androidx.compose.ui:ui:1.2.1")
//    implementation("androidx.compose.ui:ui-tooling:1.2.1")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
//    implementation("androidx.compose.foundation:foundation:1.2.1")
//    implementation("androidx.compose.material:material:1.2.1")
//    implementation("androidx.activity:activity-compose:1.5.1")
    implementation(Deps.AndroidX.appCompat)
    implementation(Deps.AndroidX.activityCompose)
    implementation(compose.ui)
    implementation(compose.material)
    implementation(compose.foundation)
    implementation(Deps.JetBrains.Serialization.serializationJson)
    implementation(Deps.Kmp.Util.onesignal)
    implementation(Deps.ArkIvanov.Decompose.decompose)
    implementation(Deps.ArkIvanov.Decompose.extensionsAndroid)
}