package nl.klrnbk.daan.half_a_minute.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.infiniteretry.snizzors.SnizzorsUIView
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import nl.klrnbk.daan.half_a_minute.presentation.constants.TabBarEntry
import nl.klrnbk.daan.half_a_minute.presentation.ui.helpers.toUIColor
import platform.CoreGraphics.CGRectMake
import platform.UIKit.UIColor
import platform.UIKit.UIImage
import platform.UIKit.UITabBar
import platform.UIKit.UITabBarItem
import platform.UIKit.UIView
import platform.UIKit.UIScreen
import platform.UIKit.UITabBarDelegateProtocol
import platform.darwin.NSObject

private var storedTabBarDelegate: TabBarDelegate? = null

@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun tabBar(
    entries: List<TabBarEntry>,
    selectedItemColor: Color,
    onSelect: (Int) -> Unit,
    selectedIdx: Int,
) {
    SnizzorsUIView(
        modifier = Modifier
            .fillMaxWidth()
            .height(95.dp),
        factory = {
            val screenBounds = UIScreen.mainScreen.bounds
            val screenWidth = screenBounds.useContents { size.width }

            val view = UIView()
            view.setFrame(CGRectMake(0.0, 0.0, screenWidth, 95.0))
            val newFrame = view.frame.useContents { CGRectMake(0.0, 16.0, screenWidth, 71.0) }

            val tabBar = UITabBar()
            val items: List<UITabBarItem> = entries.map {
                UITabBarItem(title = it.name, image = it.image, selectedImage = it.image)
            }

            tabBar.apply {
                setItems(items)
                setFrame(newFrame)

                val tabBarDelegate = TabBarDelegate(onSelect)
                storedTabBarDelegate = tabBarDelegate
                delegate = storedTabBarDelegate

                selectedItem = items[selectedIdx]

                shadowImage = UIImage()
                tintColor = UIColor.whiteColor
                unselectedItemTintColor = UIColor.lightGrayColor
                selectedImageTintColor = selectedItemColor.toUIColor()
            }

            view.apply {
                addSubview(view = tabBar)
            }
        },
    )
}

class TabBarDelegate(
    private val onSelect: (Int) -> Unit
) : NSObject(), UITabBarDelegateProtocol {
    override fun tabBar(tabBar: UITabBar, didSelectItem: UITabBarItem) {
        val index = tabBar.items?.indexOf(didSelectItem) ?: -1
        if (index >= 0) { onSelect(index) }
    }
}