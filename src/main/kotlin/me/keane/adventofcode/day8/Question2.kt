package me.keane.adventofcode.day8

import java.io.File

fun question2(file: File): Int {
    val forest = file.toForest()

    return forest.fold(0) { acc, row ->
        row.fold(acc) { rowAcc, tree ->
            rowAcc.coerceAtLeast(forest.getViewingDistance(tree))
        }
    }
}