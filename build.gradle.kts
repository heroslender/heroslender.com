import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

group "com.heroslender"
version "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                implementation(npm("bootstrap", "^5.2.3"))
                implementation(devNpm("@popperjs/core", "^2.11.6"))

                implementation(devNpm("style-loader", "^3.3.1"))
                implementation(devNpm("file-loader", "^6.2.0"))
                implementation(devNpm("autoprefixer", "^10.4.13"))
                implementation(devNpm("cssnano", "^5.1.14"))
                implementation(devNpm("postcss", "^8.4.20"))
                implementation(devNpm("postcss-import", "^15.1.0"))
                implementation(devNpm("postcss-loader", "^7.0.2"))
                implementation(devNpm("css-loader", "^6.7.2"))
                implementation(devNpm("sass-loader", "^13.2.0"))
                implementation(devNpm("sass", "^1.56.2"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}

extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
    versions.webpackCli.version = "5.0.1"
}