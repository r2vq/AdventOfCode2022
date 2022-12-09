package me.keane.adventofcode.day9

import kotlin.math.abs

internal fun flattenDirection(direction: String): List<String> = buildList {
    val (letter, distance) = direction.split(" ")
    for (i in 0 until distance.toInt()) {
        add(letter)
    }
}

internal fun calculateHead(direction: String, head: Pair<Int, Int>): Pair<Int, Int> = when (direction) {
    "U" -> head.x to head.y + 1
    "R" -> head.x + 1 to head.y
    "D" -> head.x to head.y - 1
    "L" -> head.x - 1 to head.y
    else -> throw IllegalArgumentException("Unhandled direction [$direction]")
}

internal fun calculateKnot(head: Pair<Int, Int>, knot: Pair<Int, Int>): Pair<Int, Int> {
    val diff = head.x - knot.x to head.y - knot.y
    val distance = (if (diff.x > 0) 1 else -1) to (if (diff.y > 0) 1 else -1)
    return when {
        abs(diff.x) <= 1 && abs(diff.y) <= 1 -> knot
        head.y == knot.y -> (knot.x + distance.x) to knot.y
        head.x == knot.x -> knot.x to (knot.y + distance.y)
        else -> (knot.x + distance.x) to (knot.y + distance.y)
    }
}

internal val Pair<Int, Int>.x get() = first
internal val Pair<Int, Int>.y get() = second

internal fun <T> buildList(builder: MutableList<T>.() -> Unit): List<T> = mutableListOf<T>().apply { builder() }