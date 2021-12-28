import dependencies.MobileServicesDep

version = MobileServicesEnvironments.LIBRARY_VERSION

plugins {
    id(Config.Plugins.androidLibrary)
    kotlin(Config.Plugins.kotlinAndroid)
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
    implementation(platform(MobileServicesDep.bom))
    implementation(MobileServicesDep.timber)

    MobileServicesDep.firebase.forEach {
        implementation(it)
    }

    MobileServicesDep.huawei.forEach {
        implementation(it)
    }

    // Test Dependencies
    testImplementation(MobileServicesDep.Test.junit)
    testImplementation(MobileServicesDep.Test.assertJ)
    testImplementation(MobileServicesDep.Test.mockitoKotlin)
    testImplementation(MobileServicesDep.Test.mockitoInline)
    testImplementation(MobileServicesDep.Test.coroutines)
    testImplementation(MobileServicesDep.Test.androidxArchCore)
    testImplementation(MobileServicesDep.Test.robolectric)
    testImplementation(MobileServicesDep.Test.testExtJunit)
}
