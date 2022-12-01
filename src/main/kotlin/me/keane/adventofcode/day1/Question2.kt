package me.keane.adventofcode.day1

import me.keane.adventofcode.util.fold
import java.io.File

fun question2(file: File): Int = file
    .fold(Triple(0, 0, 0) to 0) { (highestSet, currentSet), line ->
        if (line.isEmpty()) {
            highestSet.coerceAtLeast(currentSet) to 0
        } else {
            highestSet to currentSet + line.toInt()
        }
    }
    .first
    .total

private fun Triple<Int, Int, Int>.coerceAtLeast(current: Int): Triple<Int, Int, Int> = when {
    current > first -> Triple(current, first, second)
    current > second -> Triple(first, current, second)
    current > third -> Triple(first, second, current)
    else -> this
}

private val Triple<Int, Int, Int>.total: Int get() = first + second + third