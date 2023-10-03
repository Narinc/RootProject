import dependencies.CacheDep

version = CacheEnvironments.LIBRARY_VERSION

plugins {
    id(Config.Plugins.androidLibrary)
    kotlin(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
}

android {
    namespace = Config.Project.NamespaceCache
    compileSdk = Config.Sdk.compileSdkVersion

    defaultConfig {
        minSdk = Config.Sdk.minSdkVersion
        targetSdk = Config.Sdk.targetSdkVersion

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    lint {
        warningsAsErrors = true
        abortOnError = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    // Modules
    implementation(project(Modules.data))
    // Kotlin
    implementation(CacheDep.kotlin)
    // JavaX
    implementation(CacheDep.javax)
    // Room
    CacheDep.room.forEach {
        api(it)
    }
    kapt(CacheDep.roomKapt)
    // Test Dependencies
    testImplementation(CacheDep.Test.junit)
    testImplementation(CacheDep.Test.assertJ)
    testImplementation(CacheDep.Test.coroutines)
    testImplementation(CacheDep.Test.testCore)
    testImplementation(CacheDep.Test.testExtJunit)
    testImplementation(CacheDep.Test.robolectric)
    testImplementation(CacheDep.Test.roomTest)
}
