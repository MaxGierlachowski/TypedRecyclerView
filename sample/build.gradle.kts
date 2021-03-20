import io.gierla.utils.Dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    kotlin("android")
}

android {

    compileSdkVersion(Dependencies.AndroidSdk.compileSdkVersion)

    defaultConfig {
        applicationId =  Dependencies.AndroidSdk.Sample.applicationId
        minSdkVersion(Dependencies.AndroidSdk.minSdkVersion)
        targetSdkVersion(Dependencies.AndroidSdk.targetSdkVersion)
        versionCode = Dependencies.AndroidSdk.Sample.versionCode
        versionName = Dependencies.AndroidSdk.Sample.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

dependencies {
    // Local libraries
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Dependencies.kotlinVersion}")

    // AndroidX
    implementation("androidx.core:core-ktx:${Dependencies.Libraries.AndroidX.coreKtx}")

    // Compatibility
    implementation("androidx.appcompat:appcompat:${Dependencies.Libraries.AndroidX.appCompat}")

    // Flat layout widget
    implementation("androidx.constraintlayout:constraintlayout:${Dependencies.Libraries.AndroidX.constraintLayout}")

    // Efficient lists
    implementation("androidx.recyclerview:recyclerview:${Dependencies.Libraries.AndroidX.recyclerView}")

    // Library
    implementation(project(":core"))
}
