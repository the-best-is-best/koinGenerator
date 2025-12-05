package io.github.tbib.koingeneratorapp

import androidx.lifecycle.ViewModel
import io.github.tbib.koingeneratorannotations.Factory
import io.github.tbib.koingeneratorannotations.KoinViewModel
import io.github.tbib.koingeneratorannotations.Module
import io.github.tbib.koingeneratorannotations.Single
import org.koin.core.module.Module as KoinModule



@Module
interface DI {
    val module: KoinModule
}
