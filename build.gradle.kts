buildscript {
    val kotlin_version by extra("1.3.72")
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.android.tools.build:gradle:${BuildPlugins.androidGradle}")

        classpath("org.jetbrains.dokka:dokka-gradle-plugin:${BuildPlugins.dokka}")
    }
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
