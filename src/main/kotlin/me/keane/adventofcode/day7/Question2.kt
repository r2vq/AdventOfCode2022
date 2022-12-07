package me.keane.adventofcode.day7

import java.io.File

fun question2(file: File): Long {
    val root = file.createNodes()
    val diskSpace = 70000000L
    val remaining = diskSpace - root.size
    val required = 30000000L
    val difference = required - remaining
    return root
        .getDirectories()
        .sortedBy { it.size }
        .firstOrNull { it.size >= difference }
        ?.size
        ?: -1
}
