package me.keane.adventofcode

import me.keane.adventofcode.day3.question2
import java.io.File

fun main(args: Array<String>) {
    println("Advent of Code 2022 Day 3 Question 2")
    val file = File("day3-input.txt")
    println(question2(file))
}