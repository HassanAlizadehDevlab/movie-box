// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.android apply false
    id("com.android.library") version Versions.android apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin_plugin apply false
    id("org.jetbrains.kotlin.jvm") version "1.5.30" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}