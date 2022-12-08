package me.keane.adventofcode.util

import java.io.File
import java.util.stream.Stream

/**
 * Iterates through each line of this [File] and applies [mapper] to transform each line to type [T]. Returns a [Stream]
 * that streams the output [T].
 */
fun <T> File.map(mapper: (String) -> T): Stream<T> = bufferedReader().lines().map { mapper(it) }

fun <T> File.mapIndexed(mapper: (i: Int, s: String) -> T): Stream<T> {
    var i = 0
    return bufferedReader().lines().map { s -> mapper(i++, s) }
}

fun <T> File.fold(initialValue: T, folder: (prev: T, curr: String) -> T): T {
    var currentValue: T = initialValue
    forEachLine { line ->
        currentValue = folder(currentValue, line)
    }
    return currentValue
}