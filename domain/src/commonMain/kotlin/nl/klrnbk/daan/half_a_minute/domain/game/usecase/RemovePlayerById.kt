package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import org.koin.core.annotation.Factory

@Factory
class RemovePlayerById(private val playerRepository: PlayerRepository) {
    suspend operator fun invoke(id: Uuid) = playerRepository.removePlayer(id)
}
