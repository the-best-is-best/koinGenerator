import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform.getCurrentOperatingSystem

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.mavenPublish)
    id("maven-publish")
    id("signing")
}

tasks.withType<PublishToMavenRepository> {
    val isMac = getCurrentOperatingSystem().isMacOsX
    onlyIf {
        isMac.also {
            if (!isMac) logger.error(
                """
                    Publishing the library requires macOS to be able to generate iOS artifacts.
                    Run the task on a mac or use the project GitHub workflows for publication and release.
                """
            )
        }
    }
}

extra["packageNameSpace"] = "io.github.tbib.koingeneratorprocessor"
extra["artifactId"] = "koingenerator-processor"
extra["packageName"] = "Koingenerator Processor"


kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            api(projects.koinGeneratorAnnotations)
        }
        jvmMain.dependencies {
            compileOnly(libs.ksp.api)
            implementation(libs.kotlinpoet)
            implementation(libs.kotlinpoet.ksp)
            implementation(libs.kotlinpoet.metadata)
            api(projects.koinGeneratorAnnotations)


        }
    }
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from("src/jvmMain/resources")
}