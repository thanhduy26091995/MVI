package com.densitech.mvi.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun FlowLayoutPreview() {
    FlowLayout(
        horizontalSpacing = 8.dp,
        verticalSpacing = 8.dp
    ) {
        androidx.compose.material3.Text(
            text = "Itemi",
            modifier = Modifier
                .padding(4.dp)
                .width(250.dp)
                .background(androidx.compose.ui.graphics.Color.LightGray)
                .padding(8.dp)
        )
        for (i in 1..20) {
            androidx.compose.material3.Text(
                text = "Item $i",
                modifier = Modifier
                    .padding(4.dp)
                    .background(androidx.compose.ui.graphics.Color.LightGray)
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun FlowLayout(
    modifier: Modifier = Modifier,
    horizontalSpacing: Dp = 8.dp,
    verticalSpacing: Dp = 8.dp,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        val horizontalSpacingPx = horizontalSpacing.roundToPx()
        val verticalSpacingPx = verticalSpacing.roundToPx()

        val placeables = mutableListOf<Placeable>()
        val rowHeights = mutableListOf<Int>()
        val rowItems = mutableListOf<MutableList<Placeable>>()

        var currentRowWidth = 0
        var currentRowHeight = 0
        var currentRow = mutableListOf<Placeable>()

        measurables.forEach { measurable ->
            val placeable = measurable.measure(constraints)

            if (currentRowWidth + placeable.width > constraints.maxWidth) {
                // New row
                rowHeights.add(currentRowHeight)
                rowItems.add(currentRow)

                currentRow = mutableListOf()
                currentRowWidth = 0
                currentRowHeight = 0
            }

            currentRow.add(placeable)
            currentRowWidth += placeable.width + horizontalSpacingPx
            currentRowHeight = maxOf(currentRowHeight, placeable.height)
        }
        // Add the last row
        if (currentRow.isNotEmpty()) {
            rowHeights.add(currentRowHeight)
            rowItems.add(currentRow)
        }

        val totalHeight = rowHeights.sum() + verticalSpacingPx * (rowHeights.size - 1)
        layout(constraints.maxWidth, totalHeight) {
            var  y = 0
            rowItems.forEachIndexed { rowIndex, row ->
                var x = 0
                row.forEach { placeable ->
                    placeable.placeRelative(x, y)
                    x += placeable.width + horizontalSpacingPx
                }
                y += rowHeights[rowIndex] + verticalSpacingPx
            }
        }
    }
}