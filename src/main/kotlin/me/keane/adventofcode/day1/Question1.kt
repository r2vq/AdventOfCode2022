package me.keane.adventofcode.day1

import me.keane.adventofcode.util.fold
import java.io.File

fun question1(file: File): Int = file
    .fold(0 to 0) { (highestSet, currentSet), line ->
        if (line.isEmpty()) {
            highestSet.coerceAtLeast(currentSet) to 0
        } else {
            highestSet to currentSet + line.toInt()
        }
    }
    .first