// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = Config.ClassPaths.pluginGradle)
    }
    dependencies {
        classpath(Config.ClassPaths.androidGradle)
        classpath(Config.ClassPaths.kotlinGradle)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id(Config.Plugins.ktLint) version(Versions.ktLintVersion)
}

allprojects {
    apply(plugin = Config.ClassPaths.pluginKtLint) // Version should be inherited from parent
    repositories {
        mavenCentral()
        maven(url = Config.ClassPaths.googleUrl)
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
