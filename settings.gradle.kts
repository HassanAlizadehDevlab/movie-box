pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MovieBox"
include(":app")
include(":upcomingmovies:data", ":upcomingmovies:domain", ":upcomingmovies:data_di", ":upcomingmovies:domain_di")
include(":network")
include(":mainpage")
include(":popularmovies:domain", ":popularmovies:domain_di")