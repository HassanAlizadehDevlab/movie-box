plugins {
    id(Plugins.java)
    id(Plugins.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(UpcomingMoviesModule.domain))

    implementation(Data.retrofit)

    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.coroutines)
    testImplementation(UnitTest.mockk)
}