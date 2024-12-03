package day3

fun run() {
    val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"

    val result = getGroups(input)
        .fold(0) { sum, (x, y) -> sum + x * y }

    println("Result: $result")
}

val multiplyPattern = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

fun getGroups(input: String): List<Pair<Int, Int>> {
    return multiplyPattern
        .findAll(input)
        .map { match ->
            val (x, y) = match.groupValues.drop(1).map { it.toInt() }
            Pair(x, y)
        }
        .toList()
}
