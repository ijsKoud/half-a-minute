package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.invite

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlin.uuid.Uuid

@Composable
fun GameInviteScreen(gameId: Uuid) {
    Text(gameId.toString())
}
