plugins {
    id(Plugins.java)
    id(Plugins.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(PopularMoviesModule.domain))

    implementation(Common.inject)
    implementation(Data.retrofit)

    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.coroutines)
    testImplementation(UnitTest.mockk)
}