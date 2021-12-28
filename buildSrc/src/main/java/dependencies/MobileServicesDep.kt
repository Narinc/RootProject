package dependencies

object MobileServicesDep {

    const val bom = Dependencies.Firebase.bom
    const val timber = Dependencies.TimberDep.timber

    val firebase = listOf(
        Dependencies.Firebase.messaging,
        Dependencies.Firebase.analytics,
        Dependencies.Firebase.crashlytics,
        Dependencies.Firebase.config
    )

    val huawei = listOf(
        Dependencies.Huawei.analytics,
        Dependencies.Huawei.crash,
        Dependencies.Huawei.push,
        Dependencies.Huawei.remoteConfig
    )

    object Test {
        const val junit = Dependencies.TestDep.junit
        const val coroutines = Dependencies.TestDep.coroutinesTest
        const val mockitoKotlin = Dependencies.TestDep.mockitoKotlin
        const val mockitoInline = Dependencies.TestDep.mockitoInline
        const val assertJ = Dependencies.TestDep.assertJ
        const val androidxArchCore = Dependencies.TestDep.androidxArchCore
        const val robolectric = Dependencies.TestDep.robolectric
        const val testExtJunit = Dependencies.TestDep.testExtJunit
    }

}
