package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.repository.GameRepository
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import org.koin.core.annotation.Factory

@Factory
class CreateGameWithHost(
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(hostName: String): Result<Uuid> = runCatching {
        val game = gameRepository.createGame()
        val host = playerRepository.createPlayer(hostName, game.id)

        gameRepository.assignHostToGame(game.id, host.id)
        return@runCatching game.id
    }
}
