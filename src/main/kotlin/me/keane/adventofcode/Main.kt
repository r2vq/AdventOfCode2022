package me.keane.adventofcode

import me.keane.adventofcode.day5.question1
import java.io.File

fun main(args: Array<String>) {
    println("Advent of Code 2022 Day 5 Question 1")
    val file = File("day5-input.txt")
    println(question1(file))
}