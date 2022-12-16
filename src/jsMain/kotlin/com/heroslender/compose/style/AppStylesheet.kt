package com.heroslender.compose.style

import com.heroslender.compose.utils.mdSysColorVariable
import com.heroslender.compose.utils.mdVariable
import org.jetbrains.compose.web.css.*

object AppThemeColors {
    val primary by mdSysColorVariable<CSSColorValue>()
    val onPrimary by mdSysColorVariable<CSSColorValue>()
    val primaryContainer by mdSysColorVariable<CSSColorValue>()
    val onPrimaryContainer by mdSysColorVariable<CSSColorValue>()
    val secondary by mdSysColorVariable<CSSColorValue>()
    val onSecondary by mdSysColorVariable<CSSColorValue>()
    val secondaryContainer by mdSysColorVariable<CSSColorValue>()
    val onSecondaryContainer by mdSysColorVariable<CSSColorValue>()
    val tertiary by mdSysColorVariable<CSSColorValue>()
    val onTertiary by mdSysColorVariable<CSSColorValue>()
    val tertiaryContainer by mdSysColorVariable<CSSColorValue>()
    val onTertiaryContainer by mdSysColorVariable<CSSColorValue>()
    val error by mdSysColorVariable<CSSColorValue>()
    val onError by mdSysColorVariable<CSSColorValue>()
    val errorContainer by mdSysColorVariable<CSSColorValue>()
    val onErrorContainer by mdSysColorVariable<CSSColorValue>()
    val background by mdSysColorVariable<CSSColorValue>()
    val onBackground by mdSysColorVariable<CSSColorValue>()
    val surface by mdSysColorVariable<CSSColorValue>()
    val onSurface by mdSysColorVariable<CSSColorValue>()
    val surfaceVariant by mdSysColorVariable<CSSColorValue>()
    val onSurfaceVariant by mdSysColorVariable<CSSColorValue>()
    val surface1 by mdSysColorVariable<CSSColorValue>()

    val discord by mdVariable<CSSColorValue>("custom-color-discord")
    val accent by mdVariable<CSSColorValue>("custom-color-accent")
}

object AppStylesheet : StyleSheet() {

    init {
        universal style {
            fontFamily("Roboto")
        }

        type("a") style {
            textDecoration("none")
        }
    }
}