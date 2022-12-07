package me.keane.adventofcode.day7

import java.io.File

fun question1(file: File): Long {
    val root = file.createNodes()
    return root
        .getDirectories()
        .filter { it.size <= 100000 }
        .fold(0L) { acc, directory -> acc + directory.size }
}