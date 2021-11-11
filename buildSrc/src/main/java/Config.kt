object Config {

    object Sdk {
        const val minSdkVersion = 21
        const val targetSdkVersion = 31
        const val compileSdkVersion = 31
    }

    object Plugins {
        const val kotlin = "kotlin"
        const val android = "com.android.application"
        const val kotlinAndroid = "android"
        const val ktLint = "org.jlleitschuh.gradle.ktlint"
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}
