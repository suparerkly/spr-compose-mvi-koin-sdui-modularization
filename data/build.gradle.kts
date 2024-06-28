plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13"
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    // koin
    implementation("io.insert-koin:koin-android:3.5.6")
    implementation("io.insert-koin:koin-androidx-compose:3.5.6")

    //retrofit
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.converter.moshi)
//    implementation(libs.squareup.moshi.kotlin)
//    implementation(libs.squareup.moshi.adapters)

    //implement module project
    implementation(project(":core"))
    implementation(project(":sdui"))

    implementation("com.squareup.retrofit2:converter-gson:2.11.0")


    implementation("com.google.dagger:dagger:2.47")
    kapt("com.google.dagger:dagger-compiler:2.47")
}