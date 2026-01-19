package io.github.tbib.koingeneratorapp

import androidx.compose.ui.graphics.vector.ImageVector
import io.github.tbib.koingeneratorapp.myiconpack.AllIcons
import io.github.tbib.koingeneratorapp.myiconpack.Drawable
import kotlin.collections.List as ____KtList

object MyIconPack

private var __AllIcons: ____KtList<ImageVector>? = null

val MyIconPack.AllIcons: ____KtList<ImageVector>
    get() {
        if (__AllIcons != null) {
            return __AllIcons!!
        }
        __AllIcons = Drawable.AllIcons + listOf()
        return __AllIcons!!
    }
