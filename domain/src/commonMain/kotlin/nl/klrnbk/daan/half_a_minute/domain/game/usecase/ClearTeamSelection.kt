package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.repository.GameRepository
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import nl.klrnbk.daan.half_a_minute.domain.game.repository.TeamRepository
import org.koin.core.annotation.Factory

@Factory
class ClearTeamSelection(
    private val teamRepository: TeamRepository,
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(gameId: Uuid) {
        val game = gameRepository.getGameById(gameId) ?: return
        game.players.forEach { playerRepository.clearPlayerTeamSelection(it.id) }
        game.teams.forEach { teamRepository.removeTeam(it.id) }
    }
}
