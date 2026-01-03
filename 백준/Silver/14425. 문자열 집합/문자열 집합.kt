fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }

    val words = HashSet<String>()
    repeat(m) {
        words.add(readln())
    }

    var answer = 0

    repeat(n) {
        if (words.contains(readln())) {
            answer++
        }
    }
    println(answer)
}