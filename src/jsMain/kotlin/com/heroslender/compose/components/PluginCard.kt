package com.heroslender.compose.components

import PluginCard
import androidx.compose.runtime.Composable
import com.huanshankeji.compose.web.material.MdcCard
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun PluginCard(plugin: PluginStats) {
    MdcCard(padding = 12.px, attrs = { classes(PluginCard.card) }) {
        P({ classes("title-medium", "on-surface-text") }) {
            Text(plugin.pluginName)
        }

        ProgressBarStats(
            icon = "server",
            statsName = "Servers",
            stats = plugin.serversStats
        )

        ProgressBarStats(
            icon = "players",
            statsName = "Players",
            stats = plugin.playerStats
        )
    }
}

@Composable
fun ProgressBarStats(icon: String, statsName: String, stats: StatsData) {
    Div({ classes(PluginCard.progressbar); classes("title-medium", "on-surface-text") }) {
        Div({ classes("progress") }) {
            Span(attrs = { style { width((stats.current / stats.max.toDouble() * 100).coerceIn(0.0, 100.0).percent) } })
        }

        Div({ classes("hexagon", icon) }) {
            Div({ classes("hexTop") })
            Div({ classes("hexBottom") })
        }

        P {
            Text("${stats.current}/${stats.max} $statsName")
        }
    }
}

data class PluginStats(val pluginName: String, val playerStats: StatsData, val serversStats: StatsData)

data class StatsData(val current: Int, val max: Int)