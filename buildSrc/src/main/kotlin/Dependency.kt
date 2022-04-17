object Apps {
    const val ApplicationId = "com.github.moviebox"
    const val compileSdk = 32
    const val minSdk = 21
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "3.5.0"
    const val kotlin_plugin = "1.3.50"
    const val kotlin = "1.6.20"
    const val android = "7.1.2"

    const val inject = "1"
    const val dagger = "2.40"
    const val coroutines = "1.6.1"

    /* data */
    const val retrofit = "2.9.0"
    const val gson = "2.9.0"


    /* presentation */
    const val coreKtx = "1.7.0"
    const val fragmentKtx = "1.4.1"
    const val appcompat = "1.4.1"
    const val material = "1.5.0"
    const val constraintLayout = "2.1.3"
    const val lifecycle = "2.4.1"
    const val navigation = "2.4.2"
    const val glide = "4.13.1"


    /* test */
    const val junit = "4.13.2"
    const val coroutinesTest = "1.6.1"
    const val mockk = "1.12.3"
    const val coreTesting = "2.1.0"
}

object Data {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Presentation {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUItKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object UnitTest {
    const val junit = "junit:junit:${Versions.junit}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
}

object Common {
    const val inject = "javax.inject:javax.inject:${Versions.inject}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object DI {
    const val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val java = "java-library"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val jvm = "org.jetbrains.kotlin.jvm"
    const val kotlinKapt = "kotlin-kapt"
    const val daggerAndroid = "dagger.hilt.android.plugin"
    const val dagger = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}"
}

object UpcomingMoviesModule {
    const val domain = ":upcomingmovies:domain"
    const val domainDI = ":upcomingmovies:domain_di"
    const val data = ":upcomingmovies:data"
    const val dataDI = ":upcomingmovies:data_di"
}

object PopularMoviesModule {
    const val domain = ":popularmovies:domain"
    const val domainDI = ":popularmovies:domain_di"
    const val data = ":popularmovies:data"
    const val dataDI = ":popularmovies:data_di"
}

object NetworkModule {
    const val network = ":network"
}

object Views {
    const val mainPage = ":mainpage"
}