fun main() {
    val N = readln().toInt()
    val users = Array(N) { readln().split(" ") }
    users.sortBy { it[0].toInt() }

    println(users.joinToString("\n") { it.joinToString(" ") })
}