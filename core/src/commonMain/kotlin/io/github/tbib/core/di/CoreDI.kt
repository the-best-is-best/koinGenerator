package io.github.tbib.core.di

import io.github.tbib.koingeneratorannotations.InstallIn
import io.github.tbib.koingeneratorannotations.Module

@Module
@InstallIn()
 interface CoreDI {
    val module: org.koin.core.module.Module
}