package me.keane.adventofcode.day2

import java.io.File

fun question1(file: File): Int {
    var totalScore = 0

    val rockScore = 1
    val paperScore = 2
    val scissorsScore = 3

    val lossScore = 0
    val tieScore = 3
    val winScore = 6

    val memo = mapOf(
        "A Y" to winScore + paperScore,
        "A X" to tieScore + rockScore,
        "A Z" to lossScore + scissorsScore,
        "B Y" to tieScore + paperScore,
        "B X" to lossScore + rockScore,
        "B Z" to winScore + scissorsScore,
        "C Y" to lossScore + paperScore,
        "C X" to winScore + rockScore,
        "C Z" to tieScore + scissorsScore,
    )

    file.forEachLine {
        totalScore += memo[it] ?: 0
    }

    return totalScore
}