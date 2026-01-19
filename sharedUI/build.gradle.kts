plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.comGoogleDevToolsKsp)
}

kotlin {
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(libs.runtime)
            implementation(libs.foundation)
            implementation(libs.material3)
            implementation(libs.ui)
            implementation(libs.components.resources)
            implementation(libs.ui.tooling.preview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(projects.koinGeneratorAnnotations)

            implementation(projects.core)

            implementation(project.dependencies.platform("io.insert-koin:koin-bom:4.1.1"))
            implementation(libs.insert.koin.koin.compose)
            implementation(libs.koin.androidx.compose)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        sourceSets.named("commonMain").configure {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }
    }


    android {
        namespace = "io.github.tbib.koingeneratorapp"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "io.github.tbib.koingeneratorapp.sharedui.generated.resources"
}


ksp {
    arg("useKspGeneratedSources", "true")
}
dependencies {
    add("kspCommonMainMetadata", projects.koinGeneratorProcessor)
}

