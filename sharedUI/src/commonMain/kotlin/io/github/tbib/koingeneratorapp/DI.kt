package io.github.tbib.koingeneratorapp

import io.github.tbib.koingeneratorannotations.InstallIn
import org.koin.core.module.Module as KoinModule
import io.github.tbib.koingeneratorannotations.Module

@Module
@InstallIn()
interface DI {
    val module: KoinModule
}