import java.util.*

fun main() {
    val total = readln().toInt()
    val count = readln().toInt()
    val graph = buildMap<Int, MutableList<Int>> {
        for (i in 0 until count) {
            val (a, b) = readln().split(" ").map(String::toInt)
            computeIfAbsent(a, ::mutableListOf).add(b)
            computeIfAbsent(b, ::mutableListOf).add(a)
        }
    }
    val stack = Stack<Int>().apply { push(1) }
    val visited = mutableSetOf(1)

    while (!stack.empty()) {
        val current = stack.pop()

        for (next in graph[current] ?: emptyList()) {
            if (visited.contains(next)) continue
            visited.add(next)
            stack.push(next)
        }
    }
    println(visited.size - 1)
}