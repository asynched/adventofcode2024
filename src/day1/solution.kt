package day1

import kotlin.math.abs

fun run() {
    val left = mutableListOf(3, 4, 2, 1, 3, 3).sorted()
    val right = mutableListOf(4, 3, 5, 3, 9, 3).sorted()

    val distances = left
        .zip(right)
        .fold(0) { sum, (x, y) -> sum + abs(x - y) }

    println("Sum of distances is: $distances")
}

data class Tuple<T>(val first: T, val second: T)

fun <T> List<T>.zip(other: List<T>): Iterable<Tuple<T>> {
    val iterator1 = this.iterator()
    val iterator2 = other.iterator()

    return object : Iterable<Tuple<T>> {
        override fun iterator(): Iterator<Tuple<T>> {
            return object : Iterator<Tuple<T>> {
                override fun hasNext(): Boolean {
                    return iterator1.hasNext() && iterator2.hasNext()
                }

                override fun next(): Tuple<T> {
                    return Tuple(iterator1.next(), iterator2.next())
                }
            }
        }
    }
}