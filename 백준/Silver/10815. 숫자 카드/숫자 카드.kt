fun main() {
    val N = readln().toInt()
    val sanggeunArr = readln().split(" ").map { it.toInt() }.toSet() //라인별로 배열화?

    val M = readln().toInt()
    val checkArr = readln().split(" ").map { it.toInt() }

    val stBuilder = buildString {
        checkArr.forEach { i ->
            if (sanggeunArr.contains(i)) append("1 ") else append("0 ")
        }
    }

    println(stBuilder)
}