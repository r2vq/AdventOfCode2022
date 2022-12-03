package me.keane.adventofcode.day3

import me.keane.adventofcode.util.fold
import java.io.File

fun question1(file: File): Int = file
    .fold(0) { total, line ->
        val mid = line.length / 2
        total + line.substring(mid)
            .fold(
                mutableSetOf(*line.substring(0, mid).toCharArray().toTypedArray()) to 0
            ) { (firstSet, found), letter ->
                firstSet to when {
                    found != 0 -> found
                    firstSet.contains(letter) -> letter.priority
                    else -> 0
                }
            }
            .second
    }

private val Char?.priority: Int
    get() = this
        ?.let { c -> "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) }
        ?: throw IllegalArgumentException()