plugins {
    id("com.android.application") apply false
    id("com.android.library") apply false
    kotlin("android") apply false
    id(Config.Plugins.ktLint) version (Versions.ktLintVersion)
}

allprojects {
    group = Environments.Release.appId
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin(Config.Plugins.ktLint)
    }

    ktlint {
        debug.set(true)
        version.set(Versions.ktLintSnapshotVersion)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("clean", Delete::class.java) {
    delete(rootProject.buildDir)
}
