package me.keane.adventofcode.day9

import java.io.File

private const val ROPE_SIZE = 10

fun question2(file: File): Int = file
    .readLines()
    .flatMap(::flattenDirection)
    .fold(
        buildList<Pair<Int, Int>> { for (i in 0 until ROPE_SIZE) add(0 to 0) } to mutableSetOf<Pair<Int, Int>>()
    ) { (rope, visitedPositions), direction ->
        buildList<Pair<Int, Int>> {
            var newHead = calculateHead(direction, rope.first())
            add(newHead)
            for (i in 1 until rope.size) {
                newHead = calculateKnot(newHead, rope[i])
                add(newHead)
            }
        }.apply {
            visitedPositions.add(last())
        } to visitedPositions
    }
    .second
    .size