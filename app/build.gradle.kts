plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.tsiklaurimail" // Change to your package name
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.tsiklaurimail" // Change to your package name
        minSdk = 21
        targetSdk = 35 // Update to match compileSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6" // Replace this with your Compose compiler extension version
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation("androidx.appcompat:appcompat:1.6.1") // AppCompat
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation("androidx.activity:activity-compose:1.6.1") // Activity Compose
    implementation(platform(libs.androidx.compose.bom)) // Compose BOM
    implementation("androidx.compose.ui:ui") // Compose UI
    implementation("androidx.compose.ui:ui-graphics") // Compose UI Graphics
    implementation("androidx.compose.ui:ui-tooling-preview") // Compose Tooling Preview
    implementation("androidx.material3:material3:1.1.0") // Material 3

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM for tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4") // Compose UI Testing
    debugImplementation("androidx.compose.ui:ui-tooling") // Tooling support
    debugImplementation("androidx.compose.ui:ui-test-manifest") // UI Test Manifest
}
