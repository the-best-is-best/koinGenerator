package io.github.tbib.core.di

import io.github.tbib.koingeneratorannotations.InstallIn
import io.github.tbib.koingeneratorannotations.Module
import org.koin.core.KoinApplication
import org.koin.dsl.KoinAppDeclaration

@Module
@InstallIn()
 interface CoreDI {
    val module: org.koin.core.module.Module
}

expect fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication