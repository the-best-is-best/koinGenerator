package io.github.tbib.core.presenter

import io.github.tbib.koingeneratorannotations.Factory
import io.github.tbib.core.repository.MyRepository

@Factory
public class MyPresenter(private val repository: MyRepository) {
    fun getGreeting() = "Presenter says: ${repository.getText()}"
}
