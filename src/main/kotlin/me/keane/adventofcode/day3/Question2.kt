package me.keane.adventofcode.day3

import me.keane.adventofcode.util.fold
import java.io.File

fun question2(file: File, capacity: Int = 3): Int = file
    .fold<Pair<Int, ArrayList<String>>>(0 to ArrayList(capacity)) { (total, lines), line ->
        lines.add(line)
        lines.takeUnless { it.size == capacity }
            ?.let { total to it }
            ?: lines.last()
                .fold<Char?>(null) { found, char -> found ?: char.takeIf { lines contains char } }
                .priority
                .let { priority -> total + priority to ArrayList(capacity) }
    }
    .first

private infix fun MutableList<String>.contains(c: Char): Boolean = fold(true) { prev, line -> prev && line.contains(c) }

private val Char?.priority: Int
    get() = this
        ?.let { c -> "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) }
        ?: throw IllegalArgumentException()