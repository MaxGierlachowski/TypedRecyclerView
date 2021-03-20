import io.gierla.utils.Dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
    id("org.jetbrains.dokka")
    id("com.vanniktech.maven.publish")
}

android {
    compileSdkVersion(Dependencies.AndroidSdk.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Dependencies.AndroidSdk.minSdkVersion)
        targetSdkVersion(Dependencies.AndroidSdk.targetSdkVersion)
        versionCode = Dependencies.AndroidSdk.Core.versionCode
        versionName = Dependencies.AndroidSdk.Core.versionName
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

publishing {
    repositories {
        maven {
            name = "mavenCentral"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = property("STAGE_USER") as String
                password = property("STAGE_PASSWORD") as String
            }
        }
    }
}

dependencies {
    // Local libraries
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Dependencies.kotlinVersion}")

    // Compatibility
    implementation("androidx.appcompat:appcompat:${Dependencies.Libraries.AndroidX.appCompat}")

    // Android X
    implementation("androidx.core:core-ktx:${Dependencies.Libraries.AndroidX.coreKtx}")

    // Efficient lists
    implementation("androidx.recyclerview:recyclerview:${Dependencies.Libraries.AndroidX.recyclerView}")
}