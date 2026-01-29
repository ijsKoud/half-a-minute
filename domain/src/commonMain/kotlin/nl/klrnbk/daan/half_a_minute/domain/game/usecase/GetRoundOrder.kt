package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.model.GameRound
import org.koin.core.annotation.Factory

@Factory
class GetRoundOrder {
    operator fun invoke(game: Game): List<GameRound> {
        val maxPlayers = game.teams.maxOfOrNull { it.players.size } ?: 0
        val order = mutableListOf<GameRound>()

        for (playerIndex in 0 until maxPlayers) {
            for (team in game.teams) {
                if (playerIndex < team.players.size) {
                    val player = team.players[playerIndex]
                    order += GameRound(team, player)
                }
            }
        }

        return order.toList()
    }
}
