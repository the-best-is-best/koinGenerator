package io.github.tbib.core.di

import io.github.tbib.koingeneratorannotations.Module

@Module
interface CoreDI {
    val module: org.koin.core.module.Module
}