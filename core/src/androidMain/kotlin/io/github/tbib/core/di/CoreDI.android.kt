package io.github.tbib.core.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

actual fun initKoin(appDeclaration: KoinAppDeclaration) = startKoin {
    appDeclaration()

    modules(
        CoreDI().module
    )
}