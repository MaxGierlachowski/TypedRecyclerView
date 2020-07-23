apply(plugin = "org.jetbrains.dokka")
apply(plugin = "maven-publish")

afterEvaluate {
    configure<PublishingExtension> {
        publications {
            create<MavenPublication>("maven") {
                groupId = LibConfig.groupId
                artifactId = extra.get("artifactId") as String
                version = LibConfig.version

                from(components["release"])

                artifact(tasks.getByName("sourcesJar"))
                artifact(javadocJar)
            }
        }
    }
}

val javadocJar by tasks.creating(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.getByName("dokka"))
}