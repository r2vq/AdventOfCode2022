package me.keane.adventofcode.day10

import me.keane.adventofcode.day10.State.*
import java.io.File

private const val LINE_WIDTH = 40
private const val DRAW_CHAR = "#"
private const val SKIP_CHAR = "#"

fun question2(file: File): String = buildString {
    val lines = file.readLines()
    var lineIndex = 0
    var cycle = 0
    var processState: State = NotProcessing
    var spritePosition = 1

    while (true) {
        when {
            processState is Processing -> processState = Processed(processState.amount)
            lines.isNoop(lineIndex) -> lineIndex += 1
            lines.isAdd(lineIndex) -> processState = Processing(lines.getAmount(lineIndex))
        }

        when (cycle % LINE_WIDTH) {
            spritePosition - 1, spritePosition, spritePosition + 1 -> append(DRAW_CHAR)
            else -> append(SKIP_CHAR)
        }

        if (processState is Processed) {
            lineIndex += 1
            spritePosition += processState.amount
            processState = NotProcessing
        }

        if (lines.size <= lineIndex) {
            break
        }
        cycle += 1
    }
}
    .chunked(LINE_WIDTH)
    .joinToString("\n")

private fun List<String>.isNoop(index: Int): Boolean = get(index) == "noop"
private fun List<String>.isAdd(index: Int): Boolean = get(index).startsWith("addx ")
private fun List<String>.getAmount(index: Int): Int = get(index).substringAfter("addx ").toInt()

private sealed class State {
    class Processing(val amount: Int) : State()
    class Processed(val amount: Int) : State()
    object NotProcessing : State()
}