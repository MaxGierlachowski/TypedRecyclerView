package io.gierla.utils

object Dependencies  {
    const val kotlinVersion = "1.4.30"

    object BuildPlugins {
        const val androidGradle = "4.1.2"
        const val dokka = "1.4.20"
        const val publishPlugin = "0.13.0"
    }

    object AndroidSdk {
        const val compileSdkVersion = 29
        const val minSdkVersion = 16
        const val targetSdkVersion = 29

        object Core {
            const val versionCode = 1
            const val versionName = "1.0.0"
        }

        object Sample {
            const val applicationId = "io.gierla.trvsample"
            const val versionCode = 1
            const val versionName = "1.0.0"
        }
    }

    object Libraries {
        object AndroidX {
            const val appCompat = "1.1.0"
            const val coreKtx = "1.3.0"
            const val recyclerView = "1.1.0"
            const val constraintLayout = "1.1.3"
        }
    }
}