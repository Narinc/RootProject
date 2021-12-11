import dependencies.UiDep

plugins {
    id(Config.Plugins.androidApplication)
    kotlin(Config.Plugins.kotlinAndroid)
}

android {
    compileSdk = Config.Sdk.compileSdkVersion

    defaultConfig {
        applicationId = Environments.appId
        minSdk = Config.Sdk.minSdkVersion
        targetSdk = Config.Sdk.targetSdkVersion

        testInstrumentationRunner = Config.testRunner
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

        create("uat") {
            initWith(getByName("release"))
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

    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
    }

    flavorDimensions.add("server")
    productFlavors {
        create("dev") {
            dimension = "server"
            applicationIdSuffix = ".dev"
            versionCode = Environments.Development.versionCode
            versionName = Environments.Development.versionName

            buildConfigField("String", "BASE_URL", "\"" + Environments.Development.baseUrl + "\"")
        }
        create("prod") {
            dimension = "server"
            applicationIdSuffix = ".prod"
            versionCode = Environments.Production.versionCode
            versionName = Environments.Production.versionName

            buildConfigField("String", "BASE_URL", "\"" + Environments.Production.baseUrl + "\"")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(kotlin("stdlib", Versions.kotlinVersion))
    implementation(UiDep.coreKtx)
    implementation(UiDep.appCompat)
    implementation(UiDep.material)

    testImplementation(UiDep.Test.junit)
    androidTestImplementation(UiDep.Test.testExtJunit)
    androidTestImplementation(UiDep.Test.espressoCore)
}
