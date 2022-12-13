package com.heroslender.compose

import androidx.compose.runtime.Composable
import com.heroslender.compose.components.PluginCard
import com.heroslender.compose.components.PluginStats
import com.heroslender.compose.components.StatsData
import com.heroslender.compose.style.AppStylesheet
import com.huanshankeji.compose.web.material.mwcRequires
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

val plugins = listOf(
    PluginStats(
        pluginName = "HeroVender",
        playerStats = StatsData(3, 32),
        serversStats = StatsData(10, 15)
    ),
    PluginStats(
        pluginName = "HeroSpawners",
        playerStats = StatsData(50, 79),
        serversStats = StatsData(16, 17)
    ),
)

fun main() {
    mwcRequires()

    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        Div({ style { padding(25.px) } }) {
            for (plugin in plugins) {
                PluginCard(plugin)
            }
        }
    }
}

@Composable
fun previewTextClasses() {
    previewTextClass("title-large")
    previewTextClass("title-medium")
    previewTextClass("title-small")
    previewTextClass("label-large")
    previewTextClass("label-medium")
    previewTextClass("label-small")
    previewTextClass("body-large")
    previewTextClass("body-medium")
    previewTextClass("body-small")
    previewTextClass("headline-large")
    previewTextClass("headline-medium")
    previewTextClass("headline-small")
    previewTextClass("display-large")
    previewTextClass("display-medium")
    previewTextClass("display-small")
}

@Composable
fun previewTextClass(clazz: String) {
    Div({ classes(clazz, "on-surface-text") }) {
        Text(clazz)
    }
}
