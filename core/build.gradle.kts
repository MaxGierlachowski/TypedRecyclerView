plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {

    compileSdkVersion(AndroidSdk.compileSdkVersion)

    defaultConfig {
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        versionCode = AndroidSdk.Core.versionCode
        versionName = AndroidSdk.Core.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }

    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}

dependencies {
    // Local libraries
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion")

    // Compatibility
    implementation("androidx.appcompat:appcompat:${Libraries.AndroidX.appCompat}")

    // Android X
    implementation("androidx.core:core-ktx:${Libraries.AndroidX.coreKtx}")

    // Efficient lists
    implementation("androidx.recyclerview:recyclerview:${Libraries.AndroidX.recyclerView}")
}

tasks.create("sourcesJar", Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets["main"].java.srcDirs)
}

extra.apply{
    set("artifactId", "Core")
    set("description", "The core of the library used to create RecyclerViews with multiple view types.")
}

apply(from = "${rootDir}/create.gradle.kts")
apply(from = "${rootDir}/publish.gradle.kts")