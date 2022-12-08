package me.keane.adventofcode.day8

import java.io.File

fun question1(file: File): Int {
    val forest = file.toForest()

    return forest.fold(0) { acc, row ->
        row.fold(acc) { rowAcc, tree ->
            if (forest.isVisible(tree)) {
                rowAcc + 1
            } else {
                rowAcc
            }
        }
    }
}
