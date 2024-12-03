package day2

import kotlin.math.abs

fun run() {
    val levels = listOf(
        listOf(7, 6, 4, 2, 1),
        listOf(1, 2, 7, 8, 9),
        listOf(1, 3, 2, 4, 5),
        listOf(8, 6, 4, 4, 1),
        listOf(1, 3, 6, 7, 9)
    )

    levels
        .map { isSafe(it) }
        .forEachIndexed { index, safe -> println("Level $index is safe? $safe") }
}

fun isSafe(level: List<Int>): Boolean {
    val isIncreasing = level[0] < level[1]

    for ((a, b) in level.zipWithNext()) {
        val diff = b - a

        if (isIncreasing && diff < 0) {
            return false
        }

        if (!isIncreasing && diff > 0) {
            return false
        }

        val absDiff = abs(diff)

        if (absDiff < 1 || absDiff > 3) {
            return false
        }
    }

    return true
}