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

    /* data */
    const val retrofit = "2.9.0"
    const val gson = "2.9.0"


    /* presentation */
    const val coreKtx = "1.7.0"
    const val appcompat = "1.4.1"
    const val material = "1.5.0"
    const val constraintLayout = "2.1.3"


    /* test */
    const val junit = "4.13.2"
    const val coroutinesTest = "1.6.1"
    const val mockk = "1.12.3"
}

object Data {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConvertor = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Domain {

}

object Presentation {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object UnitTest {
    const val junit = "junit:junit:${Versions.junit}"
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
}

object Common {

    const val inject = "javax.inject:javax.inject:${Versions.inject}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val java = "java-library"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val jvm = "org.jetbrains.kotlin.jvm"
    const val kotlinKapt = "kotlin-kapt"
}

object UpcomingMoviesModule {
    const val domain = ":upcomingmovies:domain"
    const val data = ":upcomingmovies:data"
}

object NetworkModule {
    const val network = ":network"
}