package com.heroslender.compose.utils

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgba

fun hexColor(code: Long): CSSColorValue {
    return rgba(
        r = code shr 16 and 0xFF,
        g = code shr 8 and 0xFF,
        b = code and 0xFF,
        a = code shr 24 and 0xFF
    )
}