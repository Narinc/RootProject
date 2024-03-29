import dependencies.DomainDep

plugins {
    id(Config.Plugins.javaLibrary)
    id(Config.Plugins.kotlin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(DomainDep.kotlin)
    implementation(DomainDep.coroutineCore)

    // JavaX
    implementation(DomainDep.javax)

    // Test Dependencies
    testImplementation(DomainDep.Test.junit)
    testImplementation(DomainDep.Test.assertJ)
    testImplementation(DomainDep.Test.mockitoKotlin)
    testImplementation(DomainDep.Test.mockitoInline)
    testImplementation(DomainDep.Test.coroutines)

    detektPlugins(DomainDep.detektFormatting)
}
