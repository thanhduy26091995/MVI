package com.densitech.mvi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.densitech.mvi.R
import com.densitech.mvi.ui.theme.NeutralDarkGreyColor
import com.densitech.mvi.ui.theme.NeutralLightGreyColor
import com.densitech.mvi.ui.theme.NotesTextStyles.text2XSRegular

@Composable
fun TagView(
    label: String,
    modifier: Modifier = Modifier,
    hasCloseIcon: Boolean = false,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    Row(
        modifier = modifier
            .clickable(
                interactionSource = if (hasCloseIcon) interactionSource else null,
                indication = null,
                onClick = { onClick }
            )
            .background(
                color = if (isPressed.value) NeutralDarkGreyColor else NeutralLightGreyColor,
                shape = RoundedCornerShape(100.dp)
            )
            .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            style = text2XSRegular.copy(color = NeutralDarkGreyColor)
        )

        if (hasCloseIcon) {
            // Placeholder for close icon
            Image(
                painter = painterResource(R.drawable.ic_close),
                contentDescription = "Close Tag", modifier = Modifier
                    .padding(start = 4.dp)
                    .size(16.dp)
            )
        }
    }
}

@Composable
@Preview
fun TagViewPreview() {
    TagView(label = "Sample Tag", hasCloseIcon = true)
}