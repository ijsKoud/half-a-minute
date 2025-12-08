package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import nl.klrnbk.daan.half_a_minute.domain.game.repository.PlayerRepository
import org.koin.core.annotation.Factory

@Factory
class GetPlayerDetails(private val playerRepository: PlayerRepository) {
    suspend operator fun invoke(id: Uuid): Player? = playerRepository.getPlayer(id)
}
