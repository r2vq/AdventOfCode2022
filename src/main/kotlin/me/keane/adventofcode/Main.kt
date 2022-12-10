package me.keane.adventofcode

import me.keane.adventofcode.day10.question1
import java.io.File

fun main(args: Array<String>) {
    println("Advent of Code 2022 Day 10 Question 1")
    val file = File("day10-input.txt")
    println(question1(file))
}