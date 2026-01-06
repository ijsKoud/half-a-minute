package nl.klrnbk.daan.half_a_minute.presentation.ui.screens.game.guessing

val WORDS = listOf(
    "Beyoncé",
    "Leonardo DiCaprio",
    "Taylor Swift",
    "Tom Hanks",
    "Rihanna",
    "Eiffel Tower",
    "Grand Canyon",
    "Tokyo",
    "Sydney Opera House",
    "Mount Everest",
    "Umbrella",
    "Microwave",
    "Headphones",
    "Suitcase",
    "Bicycle",
    "Star Wars",
    "Minecraft",
    "The Simpsons",
    "Harry Potter",
    "Fortnite",
    "Birthday",
    "Election",
    "Earthquake",
    "Marathon",
    "Graduation"
)

fun getRandomWords(amount: Int): List<String> = WORDS.shuffled().take(amount)
