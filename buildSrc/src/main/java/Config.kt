object Config {

    object Sdk {
        const val minSdkVersion = 21
        const val targetSdkVersion = 31
        const val compileSdkVersion = 31
    }

    object Plugins {
        const val kotlin = "kotlin"
        const val androidApplication = "com.android.application"
        const val androidLibrary = "com.android.library"
        const val kotlinAndroid = "android"
        const val ktLint = "org.jlleitschuh.gradle.ktlint"
        const val detekt = "io.gitlab.arturbosch.detekt"
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}
