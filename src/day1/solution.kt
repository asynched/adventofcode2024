package day1

import java.util.Optional
import kotlin.jvm.optionals.getOrElse
import kotlin.math.abs

fun run() {
    val left = mutableListOf(3, 4, 2, 1, 3, 3).sorted()
    val right = mutableListOf(4, 3, 5, 3, 9, 3).sorted()

    val distances = left
        .zip(right)
        .fold(0) { sum, (x, y) -> sum + abs(x - y) }

    println("Sum of distances is: $distances")
}
