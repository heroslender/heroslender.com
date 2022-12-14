package com.heroslender.compose.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div

@Composable
fun PageLayout(
    sidebar: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Div({ classes("container", "mt-3") }) {
        Div({ classes("row", "gx-3", "gy-2") }) {
            Div({ classes("col") }) {
                content()
            }

            Div({ classes("col-12", "col-md-5", "col-lg-4", "col-xxl-3") }) {
                sidebar()
            }
        }
    }
}