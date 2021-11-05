package dependencies

object Dependencies {

    object CoreDep {
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
        const val material = "com.google.android.material:material:${Versions.materialVersion}"
    }

    object TestDep {
        const val junit = "junit:junit:${Versions.junitVersion}"
        const val testExtJunit = "androidx.test.ext:junit:${Versions.axTestJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
    }
}