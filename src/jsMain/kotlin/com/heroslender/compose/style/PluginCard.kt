package com.heroslender.compose.style

import com.heroslender.compose.utils.hexColor
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

object PluginCard : StyleSheet(AppStylesheet) {
    val animateWith by keyframes {
        from {
            width(0.px)
        }
    }

    val card by style {
        backgroundColor(AppThemeColors.surface1.value())
    }

    @OptIn(ExperimentalComposeWebApi::class)
    val progressbar by style {
        position(Position.Relative)
        padding(10.px, 0.px, 10.px, 0.px)

        self + not(lastChild) style {
            marginBottom(7.px)
        }

        child(self, type("p")) style {
            fontSize(10.px)
            property("float", "right")
            margin(2.px, 0.px, 0.px)
        }

        className("progress") style {
            marginLeft(20.px)
            height(.25.em)
            backgroundColor(AppThemeColors.background.value())
            position(Position.Relative)

            type("span") style {
                animation(animateWith) {
                    duration(3.s)
                    timingFunction(AnimationTimingFunction.cubicBezier(0.2, 1.0, 0.7, 0.95))
                }

                backgroundImage("linear-gradient(to right, #ffd147, #ffeaab)")
                height(.25.em)
                position(Position.Absolute)
            }
        }

        className("hexagon") style {
            position(Position.Absolute)
            top(0.px)
            width(20.px)
            height(11.55.px)
            margin(5.77.px, 0.px, 5.77.px, 0.px)
            backgroundColor(AppThemeColors.background.value())
            property("border-left", "solid 1px #333333")
            property("border-right", "solid 1px #333333")

            self + after style {
                fontFamily("Line Awesome Brands", "Line Awesome Free")
                fontSize(16.px)
                color(AppThemeColors.accent.value())
                position(Position.Absolute)
                top((-6).px)
                left(1.px)
                property("z-index", "2")
            }

            self + className("server") + after style {
                property("content", "\"\\f233\"")
                fontWeight(900)
            }

            self + className("players") + after style {
                property("content", "\"\\f007\"")
            }

            group(className("hexTop"), className("hexBottom")) style {
                position(Position.Absolute)
                property("z-index", "1")
                width(14.14.px)
                height(14.14.px)
                overflow("hidden")
                transform {
                    scaleY(.5774)
                    rotate((-45).deg)
                }
                background("inherit")
                left(2.25.px)
            }

            group(className("hexTop") + after, className("hexBottom") + after) style {
                property("content", "\"\"")
                position(Position.Absolute)
                width(18.px)
                height(10.392304845413264.px)
                transform {
                    rotate(45.deg)
                    scaleY(1.7321)
                    translateY((-5.1962).px)
                }

                property("transform-origin", "0 0")
                background("inherit")
            }

            className("hexTop") style {
                top((-7.7).px)
                property("border-top", "solid 1.4142px #333333")
                property("border-right", "solid 1.4142px #333333")
            }

            className("hexBottom") style {
                bottom((-7.7).px)
                property("border-bottom", "solid 1.4142px #333333")
                property("border-left", "solid 1.4142px #333333")
            }
        }
    }
}