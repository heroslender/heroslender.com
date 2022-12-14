package com.heroslender.compose

import androidx.compose.runtime.Composable
import com.heroslender.compose.components.PageLayout
import com.heroslender.compose.components.PluginCard
import com.heroslender.compose.components.PluginStats
import com.heroslender.compose.components.StatsData
import com.heroslender.compose.style.AppStylesheet
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.background
import org.jetbrains.compose.web.dom.*
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

external fun require(module: String): dynamic

fun main() {
    require("bootstrap/dist/css/bootstrap-reboot.min.css")
    require("bootstrap/scss/bootstrap-grid.scss")

    renderComposable(rootElementId = "root") {
        Style(AppStylesheet)

        PageLayout(sidebar = {
            Github()
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

@Composable
fun Github() {
    Div({ classes("github") }) {
        Div({ classes("header") }) {
            Div({ classes("user") }) {
                Div({ classes("user-logo") }) {
                    Img("https://github.com/heroslender.png", "Github")
                }

                Div({ classes("user-info") }) {
                    A("https://github.com/heroslender", { classes("username") }) {
                        Text("Bruno Martins")
                    }

                    Span({ classes("bio") }) {
                        Text("Yet another human passionate with making things.")
                    }

                    Span({ classes("country") }) {
                        I({ classes("fa", "fa-map-marker") })
                        Text("Póvoa de Varzim, Porto, Portugal")
                    }
                }
            }
            Div({ classes("footer") }) {
                Div({ classes("git-stats") }) {
                    A("https://github.com/heroslender?tab=stars", { target(ATarget.Blank) }) {
                        Span({ classes("count") }) {
                            Text("292")
                        }
                        Span({ classes("stat") }) {
                            Text("Stars")
                        }
                    }
                }
                Div({ classes("git-stats") }) {
                    A("https://github.com/heroslender?tab=followers", { target(ATarget.Blank) }) {
                        Span({ classes("count") }) {
                            Text("66")
                        }
                        Span({ classes("stat") }) {
                            Text("Seguidores")
                        }
                    }
                }
                Div({ classes("git-stats") }) {
                    A("https://github.com/heroslender?tab=following", { target(ATarget.Blank) }) {
                        Span({ classes("count") }) {
                            Text("101")
                        }
                        Span({ classes("stat") }) {
                            Text("Seguindo")
                        }
                    }
                }
            }
        }

        Div({ classes("repos") }) {
            Div({ classes("repo") }) {
                Div({ classes("repo-name") }) {
                    I({ classes("fa", "fa-book") })
                    A("https://github.com/heroslender/menu-framework", { target(ATarget.Blank) }) {
                        Text("menu-framework")
                    }
                }
                Div({ classes("repo-description") }) {
                    Text("Yet another menu framework for bukkit, but, using maps this time.")
                }
                Div({ classes("repo-footer") }) {
                    Div({ classes("language") }) {
                        I({ classes("ball"); style { background("#b07219") } })
                        Text("Kotlin")
                    }
                    A(
                        href = "https://github.com/heroslender/menu-framework/stargazers",
                        attrs = {
                            classes("stars")
                            target(ATarget.Blank)
                        }
                    ) {
                        I({ classes("fa", "fa-star") })
                        Text("56")
                    }
                    A(
                        href = "https://github.com/heroslender/menu-framework/network/members",
                        attrs = {
                            classes("forks")
                            target(ATarget.Blank)
                        }
                    ) {
                        I({ classes("fa", "fa-branch") })
                        Text("3")
                    }
                }
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
