package com.heroslender.compose.utils

import org.jetbrains.compose.web.css.CSSStyleVariable
import org.jetbrains.compose.web.css.StylePropertyValue
import kotlin.properties.ReadOnlyProperty

fun <TValue : StylePropertyValue> mdSysColorVariable() =
    ReadOnlyProperty<Any?, CSSStyleVariable<TValue>> { _, property ->
        CSSStyleVariable("md-sys-color-" + property.name.toKebabCase())
    }

fun <TValue : StylePropertyValue> mdVariable() =
    ReadOnlyProperty<Any?, CSSStyleVariable<TValue>> { _, property ->
        CSSStyleVariable("md-" + property.name.toKebabCase())
    }

fun <TValue : StylePropertyValue> mdVariable(name: String) =
    ReadOnlyProperty<Any?, CSSStyleVariable<TValue>> { _, property ->
        CSSStyleVariable("md-$name")
    }

fun String.toKebabCase() = fold(StringBuilder(length)) { acc, c ->
    if (c in 'A'..'Z') acc.append('-').append(c + ('a' - 'A'))
    else if (c in '0'..'9' && acc.last() in 'A'..'z') acc.append('-').append(c)
    else acc.append(c)
}.toString()