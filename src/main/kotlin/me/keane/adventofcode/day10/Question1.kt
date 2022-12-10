package me.keane.adventofcode.day10

import java.io.File

fun question1(file: File): Int {
    val lines = file.readLines()
    var lineIndex = 0
    var cycle = 0
    var isProcessing = false
    var processingAmount = 0
    var runningTally = 1
    var output = 0
    val interestingCycles = listOf(20, 60, 100, 140, 180, 220)

    while (true) {
        cycle += 1

        when (cycle) {
            in interestingCycles -> output += runningTally * cycle
        }

        when {
            isProcessing -> {
                lineIndex += 1
                isProcessing = false
                runningTally += processingAmount
                processingAmount = 0
            }
            lines[lineIndex] == "noop" -> {
                lineIndex += 1
            }
            lines[lineIndex].startsWith("addx ") -> {
                processingAmount = lines[lineIndex].substringAfter("addx ").toInt()
                isProcessing = true
            }
        }

        if (lines.size <= lineIndex) {
            break
        }
    }

    return output
}