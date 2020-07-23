const val kotlinVersion = "1.3.72"

object BuildPlugins {
    const val androidGradle = "4.0.1"
    const val bintray = "1.8.5"
    const val dokka = "0.10.1"
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

object LibConfig {
    const val groupId = "io.gierla.typedrecyclerview"
    const val version = "0.0.6"
}