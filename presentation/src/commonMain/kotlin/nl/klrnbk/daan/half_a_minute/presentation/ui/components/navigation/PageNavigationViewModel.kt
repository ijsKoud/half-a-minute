package nl.klrnbk.daan.half_a_minute.presentation.ui.components.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import nl.klrnbk.daan.half_a_minute.presentation.constants.getTabBarEntries
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class PageNavigationViewModel() : ViewModel() {
    val entries = getTabBarEntries()
    private var _navController: NavController? = null

    private val selectedIdxMutableState = MutableStateFlow(0)
    val selectedIdxState = selectedIdxMutableState.asStateFlow()

    fun setNavController(navController: NavController) {
        _navController = navController
    }

    fun onSelect(idx: Int) {
        val item = entries[idx]
        val path = item.getPath()

        selectedIdxMutableState.tryEmit(idx)
        _navController?.navigate(path)
    }
}