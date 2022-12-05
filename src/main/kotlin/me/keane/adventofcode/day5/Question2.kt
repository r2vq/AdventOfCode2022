package me.keane.adventofcode.day5

import java.io.File

fun question2(file: File): String {
    val stacks = mutableListOf<MutableList<Char>>()
    val invertedStacks = mutableListOf<MutableList<Char>>()
    file.forEachLine { line ->
        if (line.contains("[")) {
            val boxes = line.chunked(4).map { it.trim() }.map { it.getOrElse(1, ) { ' ' } }

            for (i in boxes.indices) {
                if (i == invertedStacks.size) {
                    invertedStacks.add(mutableListOf())
                }
                if (boxes[i] != ' ') {
                    invertedStacks[i].add(boxes[i])
                }
            }
        } else if (line.contains("move")) {
            val moveCount = line.split("from ").first().split(" ")[1].toInt()
            val fromColumn = line.split("from ")[1].split(" ")[0].toInt() - 1
            val toColumn = line.split("from ")[1].split(" ").last().toInt() - 1
            val toColumnSize = stacks[toColumn].size
            for (i in 0 until moveCount) {
                stacks[toColumn].add(toColumnSize, stacks[fromColumn].removeLast())
            }
        } else if (line.isEmpty()) {
            if (stacks.isEmpty()) {
                invertedStacks.forEachIndexed { i, stack ->
                    if (i == stacks.size) {
                        stacks.add(mutableListOf())
                    }
                    for (j in stack.size - 1 downTo 0) {
                        stacks[i].add(stack[j])
                    }
                }
            }
        }
    }
    return buildString {
        stacks.forEach { stack ->
            append(stack.last())
        }
    }
}