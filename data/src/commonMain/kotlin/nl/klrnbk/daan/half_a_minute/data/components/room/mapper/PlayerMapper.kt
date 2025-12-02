package nl.klrnbk.daan.half_a_minute.data.components.room.mapper

import nl.klrnbk.daan.half_a_minute.data.components.room.entity.PlayerEntity
import nl.klrnbk.daan.half_a_minute.domain.game.model.Player
import org.koin.core.annotation.Factory

@Factory
class PlayerMapper {
    fun map(entity: PlayerEntity?): Player? {
        if (entity == null) return null
        return Player(
            id = entity.id,
            name = entity.name
        )
    }
}
