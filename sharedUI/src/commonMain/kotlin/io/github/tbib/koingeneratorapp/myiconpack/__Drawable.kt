package io.github.tbib.koingeneratorapp.myiconpack

import androidx.compose.ui.graphics.vector.ImageVector
import io.github.tbib.koingeneratorapp.MyIconPack
import kotlin.collections.List as ____KtList

object DrawableGroup

val MyIconPack.Drawable: DrawableGroup
    get() = DrawableGroup

private var __AllIcons: ____KtList<ImageVector>? = null

val DrawableGroup.AllIcons: ____KtList<ImageVector>
    get() {
        if (__AllIcons != null) {
            return __AllIcons!!
        }
        __AllIcons = listOf()
        return __AllIcons!!
    }
