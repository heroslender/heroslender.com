package com.heroslender.compose.style

import org.jetbrains.compose.web.css.*

object AppStylesheet : StyleSheet() {

    init {
        universal style {
            fontFamily("Roboto")
        }
    }
}