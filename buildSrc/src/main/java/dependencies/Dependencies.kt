package dependencies

object Dependencies {

    object KotlinDep {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    }

    object JavaDep {
        const val javax = "javax.inject:javax.inject:${Versions.javaxInjectVersion}"
    }

    object CoreDep {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }

    object LifeCycleDep {
        const val viewModelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodelKtxVersion}"
        const val liveDataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveDataKtxVersion}"
        const val lifeCycleExtension =
            "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycleExtVersion}"
        const val lifeCycleRuntime =
            "androidx.lifecycle:lifecycle-runtime:${Versions.lifeCycleRuntimeVersion}"
        const val lifeCycleRuntimeKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleRuntimeKtxVersion}"
    }


    object DaggerHiltDep {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroidVersion}"
        const val hiltAndroidKapt = "com.google.dagger:hilt-compiler:${Versions.hiltAndroidVersion}"
        const val hiltKapt = "androidx.hilt:hilt-compiler:${Versions.hiltVersion}"
    }

    object CoroutinesDep {
        const val coroutineCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineCoreVersion}"
        const val coroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineAndroidVersion}"
    }

    object RoomDep {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
        const val roomCompilerKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    }

    object TestDep {
        const val coroutinesTest =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestVersion}"
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val assertJ = "org.assertj:assertj-core:${Versions.assertJVersion}"
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlinVersion}"
        const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
        const val testRunner = "androidx.test:runner:${Versions.androidTestRunnerVersion}"
        const val testRules = "androidx.test:rules:${Versions.androidTestRuleVersion}"
        const val testCore = "androidx.test:core:${Versions.axTestCore}"
        const val testExtJunit = "androidx.test.ext:junit:${Versions.axTestJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
        const val espressoIntents =
            "androidx.test.espresso:espresso-intents:${Versions.espressoVersion}"
        const val espressoContrib =
            "androidx.test.espresso:espresso-contrib:${Versions.espressoVersion}"
        const val androidxArchCore =
            "androidx.arch.core:core-testing:${Versions.androidxArchCoreVersion}"
        const val androidxTestExtJunit = "androidx.test.ext:${Versions.extJunitVersion}"
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectricVersion}"
        const val roomTest = "androidx.room:room-testing:${Versions.roomVersion}"
    }

}