// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
    id("com.google.gms.google-services") version "4.4.2" apply false
}