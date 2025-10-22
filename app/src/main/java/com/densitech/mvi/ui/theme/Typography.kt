package com.densitech.mvi.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.densitech.mvi.R

val Inter = FontFamily(
    Font(R.font.inter_bold, FontWeight.Bold),
    Font(R.font.inter_semi_bold, FontWeight.SemiBold),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_italic, FontWeight.Thin),
    Font(R.font.inter_light, FontWeight.Light)
)

private object FontSize {
    val XS = 10.sp
    val XXS = 12.sp
    val SM = 14.sp
    val Base = 16.sp
    val LG = 20.sp
    val XL = 24.sp
    val XXL = 32.sp
    val XXXL = 40.sp
}

private object LineHeight {
    val SM = 20.sp
    val Base = 22.sp
    val LG = 28.sp
    val XL = 33.sp
    val XXL = 38.sp
    val XXXL = 44.sp
}

private fun baseTextStyle(
    fontSize: TextUnit,
    fontWeight: FontWeight,
    lineHeight: TextUnit,
    letterSpacing: TextUnit = 0.sp,
    color: Color = Color.Black,
) = TextStyle(
    fontFamily = Inter,
    fontWeight = fontWeight,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    color = color
)

object NotesTextStyles {
    object Regular {
        val XS = baseTextStyle(FontSize.XS, FontWeight.Normal, FontSize.XS)
        val XXS = baseTextStyle(FontSize.XXS, FontWeight.Normal, FontSize.XXS)
        val SM = baseTextStyle(FontSize.SM, FontWeight.Normal, LineHeight.SM)
        val Base = baseTextStyle(FontSize.Base, FontWeight.Normal, LineHeight.Base)
        val LG = baseTextStyle(FontSize.LG, FontWeight.Normal, LineHeight.LG)
        val XL = baseTextStyle(FontSize.XL, FontWeight.Normal, LineHeight.XL)
        val XXL = baseTextStyle(FontSize.XXL, FontWeight.Normal, LineHeight.XXL)
        val XXXL = baseTextStyle(FontSize.XXXL, FontWeight.Normal, LineHeight.XXXL)
    }

    object Medium {
        val XS = baseTextStyle(FontSize.XS, FontWeight.Medium, FontSize.XS)
        val SM = baseTextStyle(FontSize.SM, FontWeight.Medium, LineHeight.SM, FontSize.SM)
        val Base = baseTextStyle(FontSize.Base, FontWeight.Medium, LineHeight.Base)
        val LG = baseTextStyle(FontSize.LG, FontWeight.Medium, LineHeight.LG)
        val XL = baseTextStyle(FontSize.XL, FontWeight.Medium, LineHeight.XL)
        val XXL = baseTextStyle(FontSize.XXL, FontWeight.Medium, LineHeight.XXL)
        val XXXL = baseTextStyle(FontSize.XXXL, FontWeight.Medium, LineHeight.XXXL)
    }

    object Bold {
        val XS = baseTextStyle(FontSize.XS, FontWeight.Bold, FontSize.XS)
        val SM = baseTextStyle(FontSize.SM, FontWeight.Bold, LineHeight.SM)
        val Base = baseTextStyle(FontSize.Base, FontWeight.Bold, LineHeight.Base)
        val LG = baseTextStyle(FontSize.LG, FontWeight.Bold, LineHeight.LG)
        val XL = baseTextStyle(FontSize.XL, FontWeight.Bold, LineHeight.XL)
        val XXL = baseTextStyle(FontSize.XXL, FontWeight.Bold, LineHeight.XXL)
        val XXXL = baseTextStyle(FontSize.XXXL, FontWeight.Bold, LineHeight.XXXL)
    }

    // For backward compatibility
    val textXSRegular = Regular.XS
    val text2XSRegular = Regular.XXS
    val textSMRegular = Regular.SM
    val textBaseRegular = Regular.Base
    val textLGRegular = Regular.LG
    val textXLRegular = Regular.XL
    val text2XLRegular = Regular.XXL
    val text3XLRegular = Regular.XXXL

    val textXSMedium = Medium.XS
    val textSMMedium = Medium.SM
    val textBaseMedium = Medium.Base
    val textLGMedium = Medium.LG
    val textXLMedium = Medium.XL
    val text2XLMedium = Medium.XXL
    val text3XLMedium = Medium.XXXL

    val textXSBold = Bold.XS
    val textSMBold = Bold.SM
    val textBaseBold = Bold.Base
    val textLGBold = Bold.LG
    val textXLBold = Bold.XL
    val text2XLBold = Bold.XXL
    val text3XLBold = Bold.XXXL
}