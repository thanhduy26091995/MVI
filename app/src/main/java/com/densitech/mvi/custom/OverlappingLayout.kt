package com.densitech.mvi.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun OverlappingLayoutPreview() {
    OverlappingLayout(overlap = 36.dp) {
        for (i in 1..5) {
            androidx.compose.material3.Text(
                text = "Item $i",
                modifier = Modifier
                    .background(androidx.compose.ui.graphics.Color.LightGray)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun OverlappingLayout(
    modifier: Modifier = Modifier,
    overlap: Dp = 16.dp,
    content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->
        val overlapPx = overlap.roundToPx()
        val placeables = measurables.map { it.measure(constraints) }

        val width = placeables.sumOf { it.width } - overlapPx * (placeables.size - 1)
        val height = placeables.maxOf { it.height }

        layout(width, height){
            var x = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x, 0)
                x += placeable.width - overlapPx
            }
        }
    }
}