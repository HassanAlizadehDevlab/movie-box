plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.daggerAndroid)
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        applicationId = Apps.ApplicationId
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Views.mainPage))

    implementation(Presentation.coreKtx)
    implementation(Presentation.appCompat)
    implementation(Presentation.material)
    implementation(Presentation.constraintLayout)
    implementation(Presentation.navigationFragmentKtx)
    implementation(Presentation.navigationUItKtx)

    implementation(DI.dagger)
    kapt(DI.daggerCompiler)

    testImplementation(UnitTest.junit)
}