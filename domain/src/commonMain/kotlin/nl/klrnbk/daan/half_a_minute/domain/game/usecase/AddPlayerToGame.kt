package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import org.koin.core.annotation.Factory

@Factory
class AddPlayerToGame(private val playerRepository: PlayerRepository) {
    suspend operator fun invoke(name: String, gameId: Uuid): Player =
        playerRepository.createPlayer(name, gameId)
}
