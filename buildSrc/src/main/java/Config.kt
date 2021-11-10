object Config {
    object Android {
        // Android sdk and version
        const val androidMinSdkVersion = 21
        const val androidTargetSdkVersion = 31
        const val androidCompileSdkVersion = 31
        const val androidBuildToolsVersion = "30.0.2"
    }

    object ClassPaths {
        const val pluginGradle = "https://plugins.gradle.org/m2/"
        const val androidGradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
        const val kotlinGradle =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
        const val googleUrl = "https://maven.google.com/"
        const val pluginKtLint = "org.jlleitschuh.gradle.ktlint"
    }

    object Plugins {
        const val kotlin = "kotlin"
        const val android = "com.android.application"
        const val kotlinAndroid = "kotlin-android"
        const val ktLint = "org.jlleitschuh.gradle.ktlint"
    }

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}
