package com.github.ariefannur.kmm.crypto.android.theme
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.ariefannur.kmm.crypto.android.R

// Material 3 typography
// Set of Material typography styles to start with
val sfDisplayFamily = FontFamily(
    Font(R.font.sf_ui_display_light, FontWeight.Light),
    Font(R.font.sf_ui_display_regular, FontWeight.Normal),
    Font(R.font.sf_ui_display_medium, FontWeight.Medium),
    Font(R.font.sf_ui_display_bold, FontWeight.Bold),
    Font(R.font.sf_ui_display_semibold, FontWeight.SemiBold)
)

val typography = Typography(
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = sfDisplayFamily,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = sfDisplayFamily,
        fontSize = 18.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontFamily = sfDisplayFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontFamily = sfDisplayFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    labelMedium = TextStyle(
        fontWeight = FontWeight.Light,
        fontFamily = sfDisplayFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontWeight = FontWeight.Light,
        fontFamily = sfDisplayFamily,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    )


)