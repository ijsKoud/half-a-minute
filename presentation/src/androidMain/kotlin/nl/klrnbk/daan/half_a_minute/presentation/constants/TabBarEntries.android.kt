package nl.klrnbk.daan.half_a_minute.presentation.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

actual fun getTabBarEntries(): List<TabBarEntry> {
    return listOf(
        TabBarEntry(
            name = "Overview",
            icon = Icons.Filled.Home,
            path = "/",
        ),
        TabBarEntry(
            name = "History",
            icon = Icons.Filled.Refresh,
            path = "/history",
        ),
        TabBarEntry(
            name = "Settings",
            icon = Icons.Filled.Settings,
            path = "/settings",
        )
    )
}

actual data class TabBarEntry(
    val name: String,
    val icon: ImageVector,
    private val path: String,
) {
    actual fun getPath(): String = ""
}