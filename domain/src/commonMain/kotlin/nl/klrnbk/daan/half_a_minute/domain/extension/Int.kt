package nl.klrnbk.daan.half_a_minute.domain.extension

fun Int.isEven(): Boolean = this % 2 == 0
fun Int.isOdd(): Boolean = this % 2 != 0
fun Int.toLeaderboardIndex(): Int = this + 1
