package nl.klrnbk.daan.half_a_minute.presentation.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import nl.klrnbk.daan.half_a_minute.presentation.theme.AppTheme
import nl.klrnbk.daan.half_a_minute.presentation.ui.components.TabBar
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun PageNavigation(
    navController: NavController,
    viewModel: PageNavigationViewModel = koinViewModel()
) {
    viewModel.setNavController(navController)
    val selectedIdx by viewModel.selectedIdxState.collectAsState()

    TabBar(
        entries = viewModel.entries,
        selectedIdx = selectedIdx,
        selectedItemColor = AppTheme.colors.tertiary,
        onSelect = viewModel::onSelect
    )
}