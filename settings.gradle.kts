pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            url = uri("https://www.jitpack.io")
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
        maven {
            url = uri("https://www.jitpack.io")
        }
        maven {
            url = uri("https://gitlab.com/api/v4/projects/59221580/packages/maven")
            name = "splLibApplication"
            credentials(HttpHeaderCredentials::class) {
                name = "Private-Token"
                value = "glpat-cFLik9u1WmyN-9oPjia7"
            }
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}

rootProject.name = "sprKoinModelization"
include(":app")
include(":features")
include(":data")
include(":core")
include(":sdui")
