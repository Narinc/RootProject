plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven { setUrl("https://developer.huawei.com/repo/")  }
}

object Plugins {
    const val AGP = "8.1.1"
    const val KOTLIN = "1.9.10"
    const val HILT = "2.48"
    const val NAVIGATION = "2.7.3"
    const val GMS = "4.3.10"
    const val FIREBASE_CRASHLYTICS = "2.8.1"
    const val AGCONNECT = "1.4.1.300"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${Plugins.HILT}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${Plugins.NAVIGATION}")
    implementation("com.google.gms:google-services:${Plugins.GMS}")
    implementation("com.google.firebase:firebase-crashlytics-gradle:${Plugins.FIREBASE_CRASHLYTICS}")
    implementation("com.huawei.agconnect:agcp:${Plugins.AGCONNECT}")
}
