pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CoursAndroid"
include(":app")
include(":mod1demo1")
include(":mod1demo2poo")
include(":mod3demo1")
include(":mod3demo2componentsjetpack")
include(":mod3demo3boxrowcolumn")
include(":mod3demo4spaces")
include(":mod3demo5lists")
include(":mod4demo1states")
include(":mod4demo2viewmodel")
include(":tpvm")
