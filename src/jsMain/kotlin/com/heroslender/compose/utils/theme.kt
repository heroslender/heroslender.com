import kotlinx.browser.window

const val DARK_MEDIA_QUERY = "(prefers-color-scheme: dark)"

fun isSystemInDarkTheme(): Boolean = window.matchMedia(DARK_MEDIA_QUERY).matches