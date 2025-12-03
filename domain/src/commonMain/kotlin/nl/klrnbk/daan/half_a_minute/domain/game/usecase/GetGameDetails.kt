package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.repository.GameRepository
import org.koin.core.annotation.Factory

@Factory
class GetGameDetails(private val gameRepository: GameRepository) {
    suspend operator fun invoke(gameId: Uuid): Game? = gameRepository.getGameById(gameId)
}
