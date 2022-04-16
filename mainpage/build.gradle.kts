plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.daggerAndroid)
}

android {

    compileSdk = Apps.compileSdk
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding.isEnabled = true
}

dependencies {

    implementation(project(UpcomingMoviesModule.domain))
    implementation(project(UpcomingMoviesModule.data))
    implementation(project(UpcomingMoviesModule.domainDI))
    implementation(project(UpcomingMoviesModule.dataDI))

    implementation(Common.coroutines)
    implementation(Presentation.coreKtx)
    implementation(Presentation.appCompat)
    implementation(Presentation.material)
    implementation(Presentation.fragmentKtx)
    implementation(Presentation.lifecycleViewModel)
    implementation(Presentation.glide)
    kapt(Presentation.glideCompiler)
    implementation(DI.dagger)
    kapt(DI.daggerCompiler)

    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.coroutines)
    testImplementation(UnitTest.mockk)
    testImplementation(UnitTest.archCoreTesting)
}