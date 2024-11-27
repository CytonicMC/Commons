plugins {
    id("java")
    `maven-publish`
    `java-library`
}

group = "net.cytonic"
version = "1.7"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:24.1.0")
    implementation("com.google.code.gson:gson:2.11.0")
    api("net.minestom:minestom-snapshots:1_21-9219e96f76")
    compileOnly("org.projectlombok:lombok:1.18.34") // lombok
    annotationProcessor("org.projectlombok:lombok:1.18.34") // lombok
    implementation("net.kyori:adventure-text-minimessage:4.17.0")// better components
}

val javadocJar = tasks.register<Jar>("javadocJar") {
    archiveClassifier.set("javadoc")
    from(tasks.javadoc)
}

val sourcesJar = tasks.register<Jar>("sourcesJar") {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allJava)
}

publishing {
    repositories {
        maven {
            name = "FoxikleCytonicRepository"
            url = uri("https://repo.foxikle.dev/cytonic")
//            credentials(PasswordCredentials::class)
            // Use providers to get the properties or fallback to environment variables
            var u = System.getenv("REPO_USERNAME")
            var p = System.getenv("REPO_PASSWORD")

            if (u == null || u.isEmpty()) {
                u = "no-value-provided"
            }
            if (p == null || p.isEmpty()) {
                p = "no-value-provided"
            }

            val user = providers.gradleProperty("FoxikleCytonicRepositoryUsername").orElse(u).get()
            val pass = providers.gradleProperty("FoxikleCytonicRepositoryPassword").orElse(p).get()
            credentials {
                username = user
                password = pass
            }
            authentication {
                create<BasicAuthentication>("basic") {

                }
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
            artifact(tasks["jar"])
            artifact(javadocJar)
            artifact(sourcesJar)
        }
    }
}

tasks.withType<JavaCompile> {
    // use String templates
    options.compilerArgs.add("--enable-preview")
}
tasks.withType<Javadoc> {
    val javadocOptions = options as CoreJavadocOptions
    val o = options as StandardJavadocDocletOptions

    javadocOptions.addStringOption("source", "21")
    javadocOptions.addBooleanOption("-enable-preview", true)

    o.tags(
        "apiNote:a:API Note:",
        "implSpec:a:Implementation Requirements:",
        "implNote:a:Implementation Note:",
    )
}
