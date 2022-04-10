plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.daggerAndroid)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(NetworkModule.network))
    implementation(project(UpcomingMoviesModule.data))
    implementation(project(UpcomingMoviesModule.domain))

    implementation(DI.dagger)
    implementation(DI.daggerCompiler)
}