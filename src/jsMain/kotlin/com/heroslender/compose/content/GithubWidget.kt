package com.heroslender.compose.content

import androidx.compose.runtime.Composable
import com.heroslender.compose.style.AppStylesheet
import com.heroslender.compose.style.AppThemeColors
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

data class GithubWidget(
    val userId: String,
    val username: String,
    val bio: String,
    val country: String,
    val stars: Int,
    val followers: Int,
    val following: Int,
    val featuredRepos: List<Repository>
) {
    data class Repository(
        val ownerId: String,
        val repoId: String,
        val displayName: String,
        val description: String,
        val language: String,
        val stars: Int,
        val forks: Int,
    )
}

@Composable
fun Github(github: GithubWidget) {
    Div({ classes("github", GithubWidgetStyle.github) }) {
        Div({ classes("header") }) {
            Div({ classes("user") }) {
                Div({ classes("user-logo") }) {
                    Img("https://github.com/${github.userId}.png", "Github")
                }

                Div({ classes("user-info") }) {
                    A("https://github.com/${github.userId}", { classes("username") }) {
                        Text(github.username)
                    }

                    Span({ classes("bio") }) {
                        Text(github.bio)
                    }

                    Span({ classes("country") }) {
                        I({ classes("las", "la-map-marker") })
                        Text(github.country)
                    }
                }
            }
            Div({ classes("footer") }) {
                Div({ classes("git-stats") }) {
                    A("https://github.com/${github.userId}?tab=stars", { target(ATarget.Blank) }) {
                        Span({ classes("count") }) {
                            Text(github.stars.toString())
                        }
                        Span({ classes("stat") }) {
                            Text("Stars")
                        }
                    }
                }
                Div({ classes("git-stats") }) {
                    A("https://github.com/${github.userId}?tab=followers", { target(ATarget.Blank) }) {
                        Span({ classes("count") }) {
                            Text(github.followers.toString())
                        }
                        Span({ classes("stat") }) {
                            Text("Seguidores")
                        }
                    }
                }
                Div({ classes("git-stats") }) {
                    A("https://github.com/${github.userId}?tab=following", { target(ATarget.Blank) }) {
                        Span({ classes("count") }) {
                            Text(github.following.toString())
                        }
                        Span({ classes("stat") }) {
                            Text("Seguindo")
                        }
                    }
                }
            }
        }

        Div({ classes("repos") }) {
            for (featuredRepo in github.featuredRepos) {
                GithubRepository(featuredRepo)
            }
        }
    }
}

@Composable
fun GithubRepository(repo: GithubWidget.Repository) {
    Div({ classes("repo") }) {
        Div({ classes("repo-name") }) {
            I({ classes("fa", "fa-book") })
            A("https://github.com/${repo.ownerId}/${repo.repoId}", { target(ATarget.Blank) }) {
                Text(repo.displayName)
            }
        }
        Div({ classes("repo-description") }) {
            Text(repo.description)
        }
        Div({ classes("repo-footer") }) {
            Div({ classes("language") }) {
                I({ classes("ball"); style { background("#b07219") } })
                Text(repo.language)
            }
            A(
                href = "https://github.com/${repo.ownerId}/${repo.repoId}/stargazers",
                attrs = {
                    classes("stars")
                    target(ATarget.Blank)
                }
            ) {
                I({ classes("las", "la-star") })
                Text(" ${repo.stars}")
            }
            A(
                href = "https://github.com/${repo.ownerId}/${repo.repoId}/network/members",
                attrs = {
                    classes("forks")
                    target(ATarget.Blank)
                }
            ) {
                I({ classes("las", "la-code-branch") })
                Text(" ${repo.forks}")
            }
        }
    }
}

object GithubWidgetStyle : StyleSheet(AppStylesheet) {
    @OptIn(ExperimentalComposeWebApi::class)
    val github by style {
        padding(15.px)
        background(AppThemeColors.surface1.value().toString())
        color(AppThemeColors.onSurface.value())

        className("header") style {
            display(DisplayStyle.Flex)
            flex(1)
            flexDirection(FlexDirection.Column)
            paddingBottom(0.5.cssRem)
            property("border-bottom", "0.2rem solid var(--${AppThemeColors.accent.name})")

            className("user") style {
                display(DisplayStyle.Flex)
                flex(1)
                flexDirection(FlexDirection.Row)

                className("user-logo") style {
                    display(DisplayStyle.Flex)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    marginRight(15.px)

                    type("img") style {
                        width(4.cssRem)
                        height(4.cssRem)
                        borderRadius(50.percent)
                    }
                }

                className("user-info") style {
                    display(DisplayStyle.Flex)
                    flex(1)
                    flexDirection(FlexDirection.Column)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    fontSize(0.8.cssRem)

                    type("a") style {
                        color(AppThemeColors.accent.value())
                    }

                    className("username") style {
                        fontSize(1.5.cssRem)
                    }
                }
            }

            className("footer") style {
                display(DisplayStyle.Flex)
                flex(1)
                flexDirection(FlexDirection.Row)
                paddingTop(1.cssRem)

                className("git-stats") style {
                    display(DisplayStyle.Flex)
                    flex(1)
                    flexDirection(FlexDirection.Column)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    fontSize(1.cssRem)

                    type("a") style {
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Column)
                        alignItems(AlignItems.Center)
                        justifyContent(JustifyContent.Center)
                        color(AppThemeColors.onSurface.value())
                    }

                    className("count") style {
                        color(AppThemeColors.accent.value())
                        fontSize(1.3.cssRem)
                    }
                }
            }
        }

        className("repos") style {
            display(DisplayStyle.Flex)
            flex(1)
            flexDirection(FlexDirection.Column)

            className("repo") style {
                property("border-bottom", "1px solid var(--${AppThemeColors.accent.name})")
                padding(1.cssRem, 0.px)

                self + lastChild style {
                    property("border-bottom", "0")
                }

                className("repo-name") style {
                    fontSize(1.cssRem)
                    paddingBottom(0.2.cssRem)

                    type("a") style {
                        color(AppThemeColors.accent.value())
                    }
                }

                className("repo-description") style {
                    fontSize(0.8.cssRem)
                    paddingBottom(1.cssRem)
                }

                className("repo-footer") style {
                    display(DisplayStyle.Flex)
                    flex(1)
                    flexDirection(FlexDirection.Row)
                    fontSize(0.8.cssRem)

                    group(
                        className("language"),
                        className("stars"),
                        className("forks")
                    ) style {
                        paddingRight(1.cssRem)
                    }

                    group(
                        className("language") + lastChild,
                        className("stars") + lastChild,
                        className("forks") + lastChild
                    ) style {
                        paddingRight(0.px)
                    }

                    child(className("language"), type("i")) + className("ball") style {
                        position(Position.Relative)
                        top(1.px)
                        width(0.8.cssRem)
                        height(0.8.cssRem)
                        borderRadius(50.percent)
                        marginRight(3.px)
                        display(DisplayStyle.InlineBlock)
                    }

                    type("a") style {
                        color(AppThemeColors.onSurface.value())
                        transitions {
                            "color" {
                                duration(300.ms)
                                timingFunction(AnimationTimingFunction.EaseOut)
                            }
                        }

                        self + hover style {
                            color(AppThemeColors.accent.value())
                        }
                    }
                }
            }
        }
    }
}