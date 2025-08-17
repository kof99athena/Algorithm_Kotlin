import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val graph = Array(n + 1) { mutableListOf<Int>() }

    //인접 리스트
    repeat(n - 1) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    val visited = BooleanArray(n + 1)
    val nodesRoot = Array(n + 1) { 0 }
    val queue: Queue<Int> = LinkedList()

    queue.add(1)
    visited[1] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        for (next in graph[current]) {
            if (!visited[next]) {
                visited[next] = true
                nodesRoot[next] = current // 루트 기록
                queue.add(next)
            }
        }
    }
    for (i in 2..n) {
        println(nodesRoot[i])
    }
}