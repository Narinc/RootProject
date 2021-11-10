import dependencies.UiDep

plugins {
    id(Config.Plugins.android)
    id(Config.Plugins.kotlinAndroid)
}

android {
    compileSdk = Config.Android.androidCompileSdkVersion
    buildToolsVersion = Config.Android.androidBuildToolsVersion

    defaultConfig {
        applicationId = Environments.Release.appId
        minSdk = Config.Android.androidMinSdkVersion
        targetSdk = Config.Android.androidTargetSdkVersion
        versionCode = Environments.Release.appVersionCode
        versionName = Environments.Release.appVersionName

        testInstrumentationRunner = Config.testRunner

        // Configs
        buildConfigField("String", "BASE_URL", "\"" + Environments.Release.baseUrl + "\"")
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(UiDep.coreKtx)
    implementation(UiDep.appCompat)
    implementation(UiDep.material)

    testImplementation(UiDep.Test.junit)
    androidTestImplementation(UiDep.Test.testExtJunit)
    androidTestImplementation(UiDep.Test.espressoCore)
}
