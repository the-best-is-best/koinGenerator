package io.github.tbib.koingeneratorapp.view_model

import androidx.lifecycle.ViewModel
import io.github.tbib.core.presenter.MyPresenter
import io.github.tbib.koingeneratorannotations.KoinViewModel

@KoinViewModel
public class MyViewModel(private val myPresenter: MyPresenter): ViewModel()
