package com.densitech.mvi.ui.components

import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.densitech.mvi.R
import com.densitech.mvi.ui.theme.NeutralBaseGreyColor
import com.densitech.mvi.ui.theme.NeutralLightGreyColor
import com.densitech.mvi.ui.theme.NeutralWhiteColor
import com.densitech.mvi.ui.theme.NotesTextStyles.textBaseMedium
import com.densitech.mvi.ui.theme.PrimaryColor
import com.densitech.mvi.ui.theme.PrimaryDarkColor

@Composable
fun NoteButton(
    text: String,
    type: NoteButtonType,
    modifier: Modifier = Modifier,
    size: NoteButtonSize = NoteButtonSize.BLOCK,
    iconPosition: NoteIconPosition = NoteIconPosition.NONE,
    icon: Painter? = null,
    state: NoteButtonState = NoteButtonState.ENABLED,
    loading: Boolean = false,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val enabled = state == NoteButtonState.ENABLED

    // Fade + scale on press
    val alpha by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.6f else 1f,
        animationSpec = tween(durationMillis = 800, easing = EaseInOut),
        label = "buttonFade"
    )

    val scale by animateFloatAsState(
        targetValue = if (isPressed && enabled) 0.96f else 1f,
        animationSpec = tween(durationMillis = 150, easing = EaseInOut)
    )

    val shape = NoteButtonToken.Shape
    val padding = NoteButtonToken.ContentPadding[size]!!
    val iconSize = NoteButtonToken.IconSize[size]!!

    // Background based on type + state
    val bgColor = when {
        !enabled -> NeutralBaseGreyColor
        isPressed -> when (type) {
            NoteButtonType.PRIMARY -> PrimaryDarkColor
            NoteButtonType.SECONDARY -> NeutralWhiteColor
            NoteButtonType.TRANSPARENT -> Color.Transparent
        }

        else -> when (type) {
            NoteButtonType.PRIMARY -> PrimaryColor
            NoteButtonType.SECONDARY -> NeutralWhiteColor
            NoteButtonType.TRANSPARENT -> Color.Transparent
        }
    }

    val border = when (type) {
        NoteButtonType.SECONDARY -> BorderStroke(
            1.dp,
            if (enabled) PrimaryColor else NeutralBaseGreyColor
        )

        else -> null
    }

    // Text color
    val textColor = when {
        !enabled -> NeutralLightGreyColor
        isPressed -> when (type) {
            NoteButtonType.PRIMARY -> NeutralWhiteColor
            NoteButtonType.SECONDARY -> PrimaryDarkColor
            NoteButtonType.TRANSPARENT -> PrimaryColor
        }

        else -> when (type) {
            NoteButtonType.PRIMARY -> NeutralWhiteColor
            NoteButtonType.SECONDARY -> PrimaryColor
            NoteButtonType.TRANSPARENT -> PrimaryColor
        }
    }

    val clickModifier =
        if (enabled) Modifier.clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        )
        else Modifier

    Row(
        modifier = modifier
            .then(if (size == NoteButtonSize.BLOCK) Modifier.fillMaxWidth() else Modifier)
            .graphicsLayer(
                scaleX = scale, scaleY = scale
            )
            .alpha(alpha)
            .background(bgColor, shape)
            .border(border ?: BorderStroke(0.dp, Color.Transparent), shape)
            .then(clickModifier)
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(iconSize),
                strokeWidth = 2.dp,
                color = textColor
            )
        } else {
            if (icon != null && iconPosition == NoteIconPosition.START) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(iconSize)
                        .padding(end = 8.dp),
                    tint = textColor
                )
            } else {
                Spacer(modifier = Modifier.size(iconSize))
            }

            Text(
                text,
                style = textBaseMedium.copy(color = textColor),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            if (icon != null && iconPosition == NoteIconPosition.END) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(iconSize)
                        .padding(start = 8.dp),
                    tint = textColor
                )
            } else {
                Modifier.size(iconSize)
            }
        }
    }
}

enum class NoteButtonType {
    PRIMARY, SECONDARY, TRANSPARENT
}

enum class NoteButtonSize {
    BLOCK, SMALL, LARGE
}

enum class NoteIconPosition {
    NONE, START, END
}

enum class NoteButtonState {
    ENABLED, DISABLED, PRESSED
}

object NoteButtonToken {
    val Shape = RoundedCornerShape(100.dp)

    val ContentPadding = mapOf(
        NoteButtonSize.BLOCK to PaddingValues(horizontal = 24.dp, vertical = 16.dp),
        NoteButtonSize.LARGE to PaddingValues(horizontal = 24.dp, vertical = 16.dp),
        NoteButtonSize.SMALL to PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    )

    val IconSize = mapOf(
        NoteButtonSize.BLOCK to 20.dp,
        NoteButtonSize.LARGE to 20.dp,
        NoteButtonSize.SMALL to 20.dp,
    )
}

@Composable
@Preview
fun NoteButtonPreview() {
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        NoteButton("Block + Primary", type = NoteButtonType.PRIMARY, size = NoteButtonSize.BLOCK)

        NoteButton(
            "Block + Primary",
            type = NoteButtonType.PRIMARY,
            size = NoteButtonSize.BLOCK,
            icon = painterResource(
                R.drawable.ic_close
            ),
            iconPosition = NoteIconPosition.START
        )

        NoteButton(
            "Block + Primary",
            type = NoteButtonType.PRIMARY,
            size = NoteButtonSize.BLOCK,
            icon = painterResource(
                R.drawable.ic_close
            ),
            iconPosition = NoteIconPosition.END
        )

        NoteButton(
            "Block + Primary",
            type = NoteButtonType.PRIMARY,
            size = NoteButtonSize.BLOCK,
            state = NoteButtonState.DISABLED
        )

        NoteButton(
            "Block + Primary",
            type = NoteButtonType.PRIMARY,
            size = NoteButtonSize.BLOCK,
            state = NoteButtonState.DISABLED
        )

        NoteButton(
            "Block + Primary",
            type = NoteButtonType.SECONDARY,
            size = NoteButtonSize.BLOCK
        )
    }
}