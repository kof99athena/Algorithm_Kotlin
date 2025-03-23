fun main() {
    val N = readln().toInt()
    val numberArr = readln().split(" ").map { it.toInt() }.toSet()

    val M = readln().toInt()
    val checkArr = readln().split(" ").map { it.toInt() }

    val result = buildString {
        checkArr.forEach { i ->
            append(if (numberArr.contains(i)) println(1) else println(0))
        }
    }
}