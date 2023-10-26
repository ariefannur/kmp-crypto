package com.github.ariefannur.kmm.crypto.android.utils

import java.math.RoundingMode
import java.text.DecimalFormat


    fun Double.roundOffDecimal(): Double {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val value = if (this < 0) this * -1 else this
        return df.format(value).toDouble()
    }