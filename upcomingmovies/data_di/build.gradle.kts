plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.daggerAndroid)
}

android {

    compileSdk = Apps.compileSdk
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(NetworkModule.network))
    implementation(project(UpcomingMoviesModule.data))
    implementation(project(UpcomingMoviesModule.domain))

    implementation(DI.dagger)
    kapt(DI.daggerCompiler)
}