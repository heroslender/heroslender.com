package com.heroslender.compose.style

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgba

val seed = Color(0xFF42515F)
val Discord = Color(0xFF8A9CFD)
val Accent = Color(0xFFFECF46)

fun Color(code: Long): CSSColorValue {
    return rgba(
        r = code shr 16 and 0xFF,
        g = code shr 8 and 0xFF,
        b = code and 0xFF,
        a = code shr 24 and 0xFF
    )
}
