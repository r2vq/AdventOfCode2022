package me.keane.adventofcode.day6

import java.io.File
import java.util.*

private const val bufferSize = 4

fun question1(file: File): Int {
    val line = file.readLines().first()
    val buffer = LinkedList<Char>()
    line.forEachIndexed { index, c ->
        if (buffer.size < bufferSize) {
            buffer.add(c)
        } else {
            buffer.pop()
            buffer.add(c)
        }
        if (buffer.size == bufferSize && buffer.checkUnique()) {
            return index + 1
        }
    }
    return -1
}

private fun LinkedList<Char>.checkUnique(): Boolean {
    for (i in 0 until size - 1) {
        for (j in i + 1 until size) {
            if (get(i) == get(j)) {
                return false
            }
        }
    }
    return true
}