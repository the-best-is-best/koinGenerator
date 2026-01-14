<div align="center">
 <h1> Koin Generator 🚀<h1>
</div>
<div align="center">
<a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
<img src="https://img.shields.io/badge/Platform-Kotlin%20Multiplatform-blueviolet.svg" />
<img src="https://img.shields.io/badge/KSP-Supported-brightgreen.svg" />
<a href="https://github.com/tbib"><img alt="Profile" src="https://img.shields.io/badge/github-%23181717.svg?&style=for-the-badge&logo=github&logoColor=white" height="20"/></a>
</div>

---

**Koin Generator** is a powerful KSP (Kotlin Symbol Processing) library that automates the creation
of Koin modules for your Kotlin Multiplatform projects. By simply annotating your classes, you can
eliminate boilerplate code and ensure a clean, scalable dependency injection setup.

It includes:

- Automatic generation of Koin modules from simple annotations.
- Support for `@Single`, `@Factory`, `@Scoped`, and `@KoinViewModel`.
- Ability to organize modules by lifecycle using `@InstallIn` (e.g., `Application`, `Activity`).
- Generation of helper functions (`loadApplicationModules()`, `loadActivityModules()`) to easily
  load modules where they are needed.

---

# Versions

<p>
  <!-- <a href="https://search.maven.org/artifact/io.github.the-best-is-best/koingenerator-annotations">
    <img src="https://img.shields.io/maven-central/v/io.github.the-best-is-best/koingenerator-annotations" />
  </a> -->
  <a href="https://search.maven.org/artifact/io.github.the-best-is-best/koingenerator-processor">
    <img src="https://img.shields.io/maven-central/v/io.github.the-best-is-best/koingenerator-processor" />
  </a>
</p>

# 📦 Installation

**_Note: Please replace `x.y.z` with the latest version._**

## 1. Add the dependencies

In your `build.gradle.kts` file for your shared module (e.g., `core`, `shared`):

```kotlin
// Add the annotations library
implementation("io.github.the-best-is-best:koingenerator-annotations:x.y.z")

// Add the KSP processor
ksp("io.github.the-best-is-best:koingenerator-processor:x.y.z")
```

## 2. Configure KSP

In the same `build.gradle.kts`, configure the KSP processor to specify which packages to scan and
where to place the generated loader file.

```kotlin
ksp {
    // Required: Comma-separated list of base packages to scan for @Module annotations.
    // The processor will scan these packages and all their sub-packages.
    arg("packageName", "io.github.tbib.core,io.github.tbib.koingeneratorapp")

    // Optional: The package where the generated 'KoinModuleLoader.kt' file will be created.
    // Defaults to the package of the first module found.
    arg("koinLoaderPackageName", "io.github.tbib.koingeneratorapp.di")
}
```

## 3. Include Generated Code

Ensure the generated code is included in your source sets.

```kotlin
kotlin {
    sourceSets.named("commonMain").configure {
        kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
    }
}
```

---

# 🧩 Available Annotations

## `@Module`

Marks an `interface` as a definition for a Koin module. The processor will generate an
implementation for it.

```kotlin
@Module
interface AppModule {
    val module: org.koin.core.module.Module
}
```

## `@Single`, `@Factory`, `@KoinViewModel`, `@Scoped`

Attach to a `class` to define how it should be provided by Koin.

```kotlin
// Provided as a singleton
@Single
class MyRepository

// Provided as a new instance every time
@Factory
class MyPresenter(private val repo: MyRepository)

// Provided as a ViewModel
@KoinViewModel
class MyViewModel(private val presenter: MyPresenter)

// Provided within a named scope
@Scoped(scopeName = "MyActivityScope")
class MyScopedDependency
```

# 🧪 Example Usage

### 1. Annotate Your Classes

```kotlin
// core/src/commonMain/kotlin/.../repository/MyRepository.kt
@Single
class MyRepository { ... }

// core/src/commonMain/kotlin/.../presenter/MyPresenter.kt
@Factory
class MyPresenter(private val repository: MyRepository) 
```

### 2. Define Your Module Interfaces

```kotlin
// core/src/commonMain/kotlin/.../di/CoreDI.kt
@Module
interface CoreDI {
    val module: org.koin.core.module.Module
}

// composeApp/src/commonmain/kotlin/.../di/AppDI.kt
@Module
interface DI {
    val module: org.koin.core.module.Module
}
```

### 3. Initialize Koin in Your App

After building, the processor generates `KoinModuleLoader.kt` in the package you specified (
`io.github.tbib.koingeneratorapp.di`). Use the generated functions to start Koin.

```kotlin
// composeApp/src/commonMain/kotlin/.../App.kt

import io.github.tbib.koingeneratorapp.di.loadApplicationModules
import io.github.tbib.koingeneratorapp.di.loadDIModules // Specific loader for the 'DI' module

fun initKoin() {
    startKoin {
        // Load all modules
        modules(loadApplicationModules() + loadDIModules())
    }
}
```

---

# 🎉 Done
