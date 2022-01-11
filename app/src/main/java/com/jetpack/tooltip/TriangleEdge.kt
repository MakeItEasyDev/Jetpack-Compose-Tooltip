package com.jetpack.tooltip

import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.unit.*

class TriangleEdge: Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val trianglePath = Path()
        trianglePath.apply {
            moveTo(x = size.width / 2, y = 0f)
            lineTo(x = size.width, y = size.height)
            lineTo(x = 0f, y = size.height)
        }

        return Outline.Generic(path = trianglePath)
    }
}