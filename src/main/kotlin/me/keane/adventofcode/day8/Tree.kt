package me.keane.adventofcode.day8

import me.keane.adventofcode.util.mapIndexed
import java.io.File
import kotlin.streams.toList

class Tree(
    val height: Int,
    val row: Int,
    val col: Int
)

fun List<List<Tree>>.isVisible(tree: Tree): Boolean {
    if (tree.row == 0 || tree.col == 0 || tree.row + 1 == size || tree.col + 1 == get(tree.row).size) {
        return true
    }
    var isVisibleFromNorth = true
    var isVisibleFromEast = true
    var isVisibleFromSouth = true
    var isVisibleFromWest = true
    forEach { row ->
        row.forEach { otherTree ->
            if (otherTree != tree) {
                if (tree.col == otherTree.col && tree.row > otherTree.row && tree.height <= otherTree.height) {
                    isVisibleFromNorth = false
                }
                if (tree.col < otherTree.col && tree.row == otherTree.row && tree.height <= otherTree.height) {
                    isVisibleFromEast = false
                }
                if (tree.col == otherTree.col && tree.row < otherTree.row && tree.height <= otherTree.height) {
                    isVisibleFromSouth = false
                }
                if (tree.col > otherTree.col && tree.row == otherTree.row && tree.height <= otherTree.height) {
                    isVisibleFromWest = false
                }

            }
        }
    }
    return isVisibleFromNorth || isVisibleFromEast || isVisibleFromSouth || isVisibleFromWest
}

fun File.toForest(): List<List<Tree>> = mapIndexed { row, line ->
    line.mapIndexed { col, c ->
        Tree(
            height = c.digitToInt(),
            row = row,
            col = col
        )
    }
}.toList()