package nl.klrnbk.daan.half_a_minute.domain.game.usecase

import kotlin.uuid.Uuid
import nl.klrnbk.daan.half_a_minute.domain.game.model.Game
import nl.klrnbk.daan.half_a_minute.domain.game.repository.GameRepository
import org.koin.core.annotation.Factory

@Factory
class UpdateGameSettings(private val gameRepository: GameRepository) {
    suspend operator fun invoke(gameId: Uuid, pointsGoal: Int, wordsPerRound: Int): Game {
        val game = gameRepository.updateGameSettings(gameId, pointsGoal, wordsPerRound)
        return game ?: throw Error("No game details found")
    }
}
