package exercises

import java.io.File

fun main() {
    val cardPairs = readCards()
    val results = cardPairs.map { it.first.toHand() to (it.second.toHand()) }
    results.forEachIndexed { index, pair ->  println("${index+1} $pair ${if (pair.first.compare(pair.second) == 0) "draw" else if (pair.first.compare(pair.second) > 0) "win" else "lose"}") }

    results.map { it.first.compare(it.second) }.count { it > 0 }.let { println(it) }
//    println(results)
    kotlin.system.exitProcess(0)
}

private fun readCards(filePath: String = "src/main/resources/0054_poker.txt"): List<Pair<CardsSorted, CardsSorted>> {
    val stringCards =
        File(filePath).readBytes().toString(Charsets.UTF_8)
            .split("\n").filter { it.isNotEmpty() } // the last line is empty
            .map { it.split(" ") }
    return stringCards
        .map { it.toCardPairs() }
}

private fun List<String>.toCardPairs(): Pair<CardsSorted, CardsSorted> {
    return this.takeIf { it.size == 10 }?.map { it.toCard() }
        ?.let { cardsStr -> CardsSorted(cardsStr.subList(0, 5)) to CardsSorted(cardsStr.subList(5, 10)) }
        ?: throw RuntimeException("The size must be ten. size = ${this.size}")
}

// e.g.) 8C -> CARD(EIGHT, CLUB)
private fun String.toCard(): Card {
    val (cardValue, suit) = this.map { it.toString() }
    return Card(CardValue.of(cardValue), Suit.of(suit))
}

private data class CardsSorted(val cards: List<Card>) {
    init {
        cards.sortedByDescending { it.cardValue.strength }
    }

    fun toHand(): Hand {
        if (this.isRoyalFlush()) return RoyalFlush(this)
        if (this.isStraightFlush()) return StraightFlush(this)
        if (this.isFourCards()) return FourCards(this)
        if (this.isFullHouse()) return FullHouse(this)
        if (this.isFlush()) return Flush(this)
        if (this.isStraight()) return Straight(this)
        if (this.isThreeCards()) return ThreeCards(this)
        if (this.isTwoPairs()) return TwoPairs(this)
        if (this.isOnePair()) return OnePair(this)
        return HighCard(this) }

}
private fun CardsSorted.isRoyalFlush(): Boolean = this.isStraightFlush() && this.cards.minBy { it.cardValue.strength }.cardValue == CardValue.TEN
private fun CardsSorted.isStraightFlush(): Boolean = this.isStraight() && this.isFlush()
private fun CardsSorted.isFourCards(): Boolean = this.cards.groupBy { it.cardValue }.filter { it.value.size == 4 }.map { it.key }.size == 1
private fun CardsSorted.isFullHouse(): Boolean = this.isThreeCards() && this.isOnePair()
private fun CardsSorted.isFlush(): Boolean = this.cards.groupBy { it.suit }.size == 1
private fun CardsSorted.isStraight(): Boolean {
    val first = this.cards.minBy { it.cardValue.strength }.cardValue
    this.cards.sortedBy { it.cardValue.strength }.forEachIndexed { index, card ->
        if (card.cardValue.strength != first.strength + index) return false
    }
    return true
}
private fun CardsSorted.isThreeCards(): Boolean = this.cards.groupBy { it.cardValue }.filter { it.value.size == 3 }.map { it.key }.size == 1
private fun CardsSorted.isTwoPairs(): Boolean = this.cards.groupBy { it.cardValue }.filter { it.value.size == 2 }.map { it.key }.size == 2
private fun CardsSorted.isOnePair(): Boolean = this.cards.groupBy { it.cardValue }.filter { it.value.size == 2 }.map { it.key }.size == 1

private data class Card(val cardValue: CardValue, val suit: Suit)

private enum class Suit(val suitString: String) {
    SPADE("S"),
    DIAMOND("D"),
    CLUB("C"),
    HEART("H");

    companion object {
        fun of(suit: String) =
            entries.firstOrNull { it.suitString == suit } ?: throw RuntimeException("invalid argument. value = $suit")
    }
}

// as the value increases , the strength number increases from 2 to 14.
enum class CardValue(val stringValue: String, val strength: Int) {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    companion object {
        fun of(stringValue: String) = entries.firstOrNull { it.stringValue == stringValue }
            ?: throw RuntimeException("invalid argument. value = $stringValue")
    }
}


private sealed interface Hand {
    fun strength(): Int
    fun restOfHand(): List<CardValue>
    fun compare(hand: Hand): Int
}

private class HighCard(private val cards: CardsSorted) : Hand {
    override fun strength() = 0
    override fun restOfHand(): List<CardValue> {
        return cards.cards.sortedByDescending { it.cardValue.strength }.map { it.cardValue }
    }

    override fun compare(hand: Hand): Int {
        return if (hand is HighCard) {
            this.restOfHand().forEachIndexed { index, cardValue ->
                val self = cardValue.strength
                val other = hand.restOfHand()[index].strength
                if (self != other) return self - other
            }
            0 // this is the lowest hand so here is dead code.
        } else -1
    }
}

private class OnePair(private val cards: CardsSorted) : Hand {
    override fun strength() = 1
    override fun restOfHand(): List<CardValue> {
        return cards.cards.groupBy { it.cardValue }.filter { it.value.size == 1 }.map { it.key }
    }

    override fun compare(hand: Hand): Int {
        return if (hand is OnePair) {
            if (this.pair() != hand.pair()) return this.pair().strength - hand.pair().strength
            this.restOfHand().forEachIndexed { index, card ->
                val self = card.strength
                val other = hand.restOfHand()[index].strength
                if (self != other) return self - other
            }
            return 0
        } else this.strength() - hand.strength()
    }
    fun pair(): CardValue = cards.cards.groupBy { it.cardValue }.filter { it.value.size == 2 }.map { it.key }.first()
}

private class TwoPairs(private val cards: CardsSorted) : Hand {
    override fun strength() = 2
    override fun restOfHand(): List<CardValue> {
        return cards.cards.groupBy { it.cardValue }.filter { it.value.size == 1 }.map { it.key }
    }

    override fun compare(hand: Hand): Int {
        return if (hand is TwoPairs) {
            this.pairs().forEachIndexed { index, cardValue ->
                val self = cardValue.strength
                val other = hand.pairs()[index].strength
                if (self != other) return self - other
            }
            this.restOfHand().forEachIndexed { index, cardValue ->
                val self = cardValue.strength
                val other = hand.restOfHand()[index].strength
                if (self != other) return self - other
            }
            return 0
        } else this.strength() - hand.strength()
    }

    fun pairs(): List<CardValue> = cards.cards.groupBy { it.cardValue }.filter { it.value.size == 2 }.map { it.key }
}
private class ThreeCards(private val cards: CardsSorted): Hand {
    override fun strength() = 3
    override fun restOfHand(): List<CardValue> {
        return cards.cards.groupBy { it.cardValue }.filter { it.value.size == 1 }.map { it.key }
    }

    override fun compare(hand: Hand): Int {
        return if (hand is ThreeCards) {
            if (this.value() != hand.value()) this.strength() - hand.strength()
            this.restOfHand().forEachIndexed { index, cardValue ->
                val self = cardValue.strength
                val other = hand.restOfHand()[index].strength
                if (self != other) return self - other
            }
            return 0
        } else this.strength() - hand.strength()
    }

    fun value(): CardValue = cards.cards.groupBy { it.cardValue }.filter { it.value.size == 3 }.map { it.key }.first()
}
private class Straight(private val cards: CardsSorted): Hand {
    override fun strength() = 4
    override fun restOfHand(): List<CardValue> = emptyList()

    override fun compare(hand: Hand): Int {
        return if (hand is Straight) {
            this.beginning().strength - hand.beginning().strength
        } else this.strength() - hand.strength()
    }

    fun beginning(): CardValue = cards.cards.minBy { it.cardValue.strength }.cardValue
}
private class Flush(private val cards: CardsSorted): Hand {
    override fun strength() = 5
    override fun restOfHand(): List<CardValue> {
        return cards.cards.sortedByDescending { it.cardValue.strength }.map { it.cardValue }
    }

    override fun compare(hand: Hand): Int {
        return if (hand is Flush) {
            this.restOfHand().forEachIndexed { index, cardValue ->
                val self = cardValue.strength
                val other = hand.restOfHand()[index].strength
                if (self != other) return self - other
            }
            return 0
        } else this.strength() - hand.strength()
    }
}
private class FullHouse(private val cards: CardsSorted): Hand {
    override fun strength() = 6
    override fun restOfHand(): List<CardValue> = emptyList()
    override fun compare(hand: Hand): Int {
        if (hand is FullHouse) {
            return this.threeCards().strength - hand.threeCards().strength
        }
        return this.strength() - hand.strength()
    }
    fun threeCards() = ThreeCards(cards).value()
}
private class FourCards(private val cards: CardsSorted): Hand {
    override fun strength() = 7
    override fun restOfHand(): List<CardValue> {
        return cards.cards.groupBy { it.cardValue }.filter { it.value.size == 1 }.map { it.key }
    }
    override fun compare(hand: Hand): Int {
        if (hand is FourCards) {
            return if (this.fourCards().strength != hand.fourCards().strength) this.fourCards().strength - hand.fourCards().strength
            else restOfHand().first().strength - hand.restOfHand().first().strength
        }
        return this.strength() - hand.strength()
    }
    fun fourCards(): CardValue = cards.cards.groupBy { it.cardValue }.filter { it.value.size == 4 }.map { it.key }.first()
}
private class StraightFlush(private val cards: CardsSorted): Hand {
    override fun strength() = 8
    override fun restOfHand(): List<CardValue> = emptyList()
    override fun compare(hand: Hand): Int {
        return if (hand is StraightFlush) {
            straight().compare(hand.straight())
        } else this.strength() - hand.strength()
    }
    fun straight() = Straight(this.cards)
}
private class RoyalFlush(private val cards: CardsSorted): Hand {
    override fun strength() = 9
    override fun restOfHand():List<CardValue> = emptyList()

    override fun compare(hand: Hand): Int = 1
}
