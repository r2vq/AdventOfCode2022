package me.keane.adventofcode.day4

import me.keane.adventofcode.util.map
import java.io.File

fun question1(file: File): Int = file
    .map { line ->
        line
            .split(",")
            .map { stringRange -> stringRange.split("-").map { num -> num.toInt() } }
            .map { range -> range[0] to range[1] }
    }
    .map { (first, second) ->
        if (first.start > second.start || first.start == second.start && first.end < second.end) {
            second to first
        } else {
            first to second
        }
    }
    .filter { (first, second) -> first.end >= second.start && second.end <= first.end }
    .count()
    .toInt()

private val Pair<Int, Int>.start get() = first
private val Pair<Int, Int>.end get() = second