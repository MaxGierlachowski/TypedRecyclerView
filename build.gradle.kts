plugins {
    kotlin("android") version io.gierla.utils.Dependencies.kotlinVersion apply false
    id("com.android.application") version io.gierla.utils.Dependencies.BuildPlugins.androidGradle apply false

    id("org.jetbrains.dokka") version io.gierla.utils.Dependencies.BuildPlugins.dokka apply false

    id("com.vanniktech.maven.publish") version io.gierla.utils.Dependencies.BuildPlugins.publishPlugin apply false
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
