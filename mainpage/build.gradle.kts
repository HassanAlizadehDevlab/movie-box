plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
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

    implementation(project(UpcomingMoviesModule.domain))
    implementation(project(UpcomingMoviesModule.domainDI))

    implementation(Presentation.coreKtx)
    implementation(Presentation.appCompat)
    implementation(Presentation.material)
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    testImplementation(UnitTest.junit)
    testImplementation(UnitTest.coroutines)
    testImplementation(UnitTest.mockk)
    testImplementation(UnitTest.archCoreTesting)
}