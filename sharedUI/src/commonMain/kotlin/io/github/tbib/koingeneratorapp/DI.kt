package io.github.tbib.koingeneratorapp

import io.github.tbib.koingeneratorannotations.InstallIn
import io.github.tbib.koingeneratorannotations.Module
import org.koin.core.module.Module as KoinModule

@Module
@InstallIn()
interface DI {
    val module: KoinModule
}