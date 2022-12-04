package me.keane.adventofcode.util

import java.io.File
import java.util.stream.Stream

/**
 * Iterates through each line of this [File] and applies [mapper] to transform each line to type [T]. Returns a [Stream]
 * that streams the output [T].
 */
fun <T> File.map(mapper: (String) -> T): Stream<T> = bufferedReader().lines().map { mapper(it) }