plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.features"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
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
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(platform(libs.androidx.compose.bom))
    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)

    implementation(libs.jetbrains.kotlinx.coroutines.core)

    // koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    //retrofit
    implementation(libs.retrofit.v2110)
    implementation(libs.converter.gson)
    implementation(libs.converter.moshi.v240)

    //lib
//    implementation("com.spr.sprLibApplication:sprLibSDUI:0.0.6-test03")
//    implementation("com.spr.sprLibApplication:sprLibSDUI:0.0.6-test02")

    //implement module project
    implementation(project(":data"))
    implementation(project(":core"))
    implementation(project(":sdui"))

    //dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // lottie
    implementation(libs.lottie.compose)

    //coil
    implementation(libs.coil.compose.v260)
    implementation(libs.coil.svg.v260)

    // com.google.accompanist
//    implementation("com.google.accompanist:accompanist-pager:0.32.0")

    // mockito
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.mockito.core)

}