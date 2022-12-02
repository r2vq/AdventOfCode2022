package me.keane.adventofcode.day2

import java.io.File

fun question2(file: File): Int {
    var totalScore = 0

    val rockScore = 1
    val paperScore = 2
    val scissorsScore = 3

    val lossScore = 0
    val tieScore = 3
    val winScore = 6

    val memo = mapOf(
        "A Y" to tieScore + rockScore,
        "A X" to lossScore + scissorsScore,
        "A Z" to winScore + paperScore,
        "B Y" to tieScore + paperScore,
        "B X" to lossScore + rockScore,
        "B Z" to winScore + scissorsScore,
        "C Y" to tieScore + scissorsScore,
        "C X" to lossScore + paperScore,
        "C Z" to winScore + rockScore,
    )

    file.forEachLine {
        totalScore += memo[it] ?: 0
    }

    return totalScore
}