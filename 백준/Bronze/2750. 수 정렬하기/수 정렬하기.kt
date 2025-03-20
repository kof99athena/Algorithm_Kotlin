fun main() {
    val N = readln().toInt()
    val arr = Array(N) { readln().split("\n").map { it.toInt() }.toIntArray() }

    arr.distinct()
    arr.sortBy { it[0] }
    println(arr.joinToString("\n") { it.joinToString(" ") })
}