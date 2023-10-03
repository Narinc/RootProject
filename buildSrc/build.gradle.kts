plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

object Plugins {
    const val AGP = "8.1.1"
    const val KOTLIN = "1.9.10"
    const val HILT = "2.48"
    const val NAVIGATION = "2.7.3"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${Plugins.KOTLIN}")
    implementation("com.android.tools.build:gradle:${Plugins.AGP}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${Plugins.HILT}")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:${Plugins.NAVIGATION}")
}
