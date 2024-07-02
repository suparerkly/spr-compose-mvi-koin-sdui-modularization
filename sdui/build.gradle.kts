@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("maven-publish")
}

android {
    namespace = "com.example.sdui"
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":core"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.foundation.android)

    // Data store
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.androidx.appcompat)

    // Squareup
    implementation(libs.squareup.retrofit)
    implementation(libs.squareup.converter.moshi)
    implementation(libs.squareup.moshi.kotlin)
    implementation(libs.squareup.moshi.adapters)

    // Coroutines
    implementation(libs.jetbrains.kotlinx.coroutines.core)

    // Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)

    // Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)

    // koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    //libs
//    implementation("com.spr.sprLibApplication:sprLibSDUI:0.0.6-test03")
//    implementation("com.google.android.gms:play-services-ads:22.6.0")
    implementation(libs.compose.video)
    implementation(libs.androidx.media3.exoplayer) // [Required] androidx.media3 ExoPlayer dependency
    implementation(libs.androidx.media3.session) // [Required] MediaSession Extension dependency
    implementation(libs.androidx.media3.ui) // [Required] Base Player UI

    implementation(libs.androidx.media3.exoplayer.dash) // [Optional] If your media item is DASH
    implementation(libs.androidx.media3.exoplayer.hls) // [Optional] If your media item is HLS (m3u8..)
}