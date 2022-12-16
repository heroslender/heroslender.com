package com.heroslender.compose

import androidx.compose.runtime.Composable
import com.heroslender.compose.components.PageLayout
import com.heroslender.compose.components.PluginCard
import com.heroslender.compose.components.PluginStats
import com.heroslender.compose.components.StatsData
import com.heroslender.compose.content.Github
import com.heroslender.compose.content.GithubWidget
import com.heroslender.compose.style.AppStylesheet
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

external fun require(module: String): dynamic

fun main() {
    require("bootstrap/dist/css/bootstrap-reboot.min.css")
    require("bootstrap/scss/bootstrap-grid.scss")

    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        PageLayout(sidebar = {
            Github(profile)
        }) {
            Div({
                classes("row", "row-cols-1", "row-cols-sm-2", "row-cols-md-1", "row-cols-lg-2", "gx-2", "gy-2")
            }) {
                for (plugin in plugins) {
                    PluginCard(plugin)
                }
            }
        }
    }
}

val profile = GithubWidget(
    userId = "heroslender",
    username = "Bruno Martins",
    bio = "Yet another human passionate with making things.",
    country = "Póvoa de Varzim, Porto, Portugal",
    stars = 292,
    followers = 66,
    following = 101,
    featuredRepos = listOf(
        GithubWidget.Repository(
            ownerId = "heroslender",
            repoId = "menu-framework",
            displayName = "menu-framework",
            description = "Yet another menu framework for bukkit, but, using maps this time.",
            language = "Kotlin",
            stars = 56,
            forks = 3,
        ),
        GithubWidget.Repository(
            ownerId = "heroslender",
            repoId = "HeroSpawners",
            displayName = "HeroSpawners",
            description = "Reduza o lag de seu servidor, permitindo que os spawners agrupem! \uD83D\uDD25",
            language = "Java",
            stars = 5,
            forks = 1,
        )
    )
)

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
    PluginStats(
        pluginName = "HeroVender 2",
        playerStats = StatsData(3, 32),
        serversStats = StatsData(10, 15)
    ),
    PluginStats(
        pluginName = "HeroSpawners 2",
        playerStats = StatsData(50, 79),
        serversStats = StatsData(16, 17)
    ),
)

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
