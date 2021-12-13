version = PresenterEnvironments.LIBRARY_VERSION

plugins {
    id(Config.Plugins.androidLibrary)
    kotlin(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
}

android {
    compileSdk = Config.Sdk.compileSdkVersion

    defaultConfig {
        minSdk = Config.Sdk.minSdkVersion
        targetSdk = Config.Sdk.targetSdkVersion

        testInstrumentationRunner = Config.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
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
    // implementation(project(Modules.domain))

    implementation(DepPresentation.kotlin)
    implementation(DepPresentation.coroutineCore)
    // Dagger-Hilt (used for @InjectViewModel)
    DepPresentation.daggerHilt.forEach {
        implementation(it)
    }
    DepPresentation.daggerHiltKapt.forEach {
        kapt(it)
    }
    // JavaX
    implementation(DepPresentation.javax)
    // LifeCycle
    DepPresentation.lifeCycle.forEach {
        implementation(it)
    }

    // Test Dependencies
    testImplementation(DepPresentation.Test.junit)
    testImplementation(DepPresentation.Test.assertJ)
    testImplementation(DepPresentation.Test.mockitoKotlin)
    testImplementation(DepPresentation.Test.mockitoInline)
    testImplementation(DepPresentation.Test.coroutines)
    testImplementation(DepPresentation.Test.androidxArchCore)
    testImplementation(DepPresentation.Test.robolectric)
    testImplementation(DepPresentation.Test.testExtJunit)
}
