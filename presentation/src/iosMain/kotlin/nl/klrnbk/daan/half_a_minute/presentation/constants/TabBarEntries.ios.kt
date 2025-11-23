package nl.klrnbk.daan.half_a_minute.presentation.constants

import platform.UIKit.UIImage

actual fun getTabBarEntries(): List<TabBarEntry> {
    return listOf(
        TabBarEntry(
            name = "Overview",
            path = "/",
            image = UIImage.systemImageNamed("house.fill")
        ),
        TabBarEntry(
            name = "History",
            path = "/history",
            image = UIImage.systemImageNamed("clock.fill")
        ),
        TabBarEntry(
            name = "Settings",
            path = "/settings",
            image = UIImage.systemImageNamed("gearshape.fill")
        )
    )
}

actual data class TabBarEntry(
    val name: String,
    val image: UIImage?,
    private val path: String
) {
    actual fun getPath(): String = path
}