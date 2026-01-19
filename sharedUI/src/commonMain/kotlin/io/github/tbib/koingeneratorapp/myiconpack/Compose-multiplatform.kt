package io.github.tbib.koingeneratorapp.myiconpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Brush.Companion.radialGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.tbib.koingeneratorapp.MyIconPack

val MyIconPack.`Compose-multiplatform`: ImageVector
    get() {
        if (`_compose-multiplatform` != null) {
            return `_compose-multiplatform`!!
        }
        `_compose-multiplatform` = Builder(
            name = "Compose-multiplatform", defaultWidth = 450.0.dp,
            defaultHeight = 450.0.dp, viewportWidth = 64.0f, viewportHeight = 64.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF6075f2)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(56.25f, 18.0f)
                verticalLineTo(46.0f)
                lineTo(32.0f, 60.0f)
                lineTo(7.75f, 46.0f)
                verticalLineTo(18.0f)
                lineTo(32.0f, 4.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6b57ff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveToRelative(41.5f, 26.5f)
                verticalLineToRelative(11.0f)
                lineTo(32.0f, 43.0f)
                verticalLineTo(60.0f)
                lineTo(56.25f, 46.0f)
                verticalLineTo(18.0f)
                close()
            }
            path(
                fill = radialGradient(
                    0.0f to Color(0xFF5383EC), 0.867f to Color(0xFF7F52FF),
                    center = Offset(23.131f, 18.441f), radius = 42.132f
                ), stroke = null,
                strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveToRelative(32.0f, 43.0f)
                lineToRelative(-9.5f, -5.5f)
                verticalLineToRelative(-11.0f)
                lineTo(7.75f, 18.0f)
                verticalLineTo(46.0f)
                lineTo(32.0f, 60.0f)
                close()
            }
            path(
                fill = linearGradient(
                    0.0f to Color(0xFF33C3FF), 0.878f to Color(0xFF5383EC), start
                    = Offset(44.172f, 4.377f), end = Offset(17.973f, 34.035f)
                ), stroke = null,
                strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(22.5f, 26.5f)
                lineTo(32.0f, 21.0f)
                lineTo(41.5f, 26.5f)
                lineTo(56.25f, 18.0f)
                lineTo(32.0f, 4.0f)
                lineTo(7.75f, 18.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveToRelative(32.0f, 21.0f)
                lineToRelative(9.526f, 5.5f)
                verticalLineToRelative(11.0f)
                lineTo(32.0f, 43.0f)
                lineTo(22.474f, 37.5f)
                verticalLineToRelative(-11.0f)
                close()
            }
        }
            .build()
        return `_compose-multiplatform`!!
    }

private var `_compose-multiplatform`: ImageVector? = null

@Preview
@Composable
private fun Preview(): Unit {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = MyIconPack.`Compose-multiplatform`, contentDescription = "")
    }
}
