import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val (N, M, R) = readln().split(" ").map { it.toInt() }

    // 인접한 노드들을 저장함
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    //방문 여부
    val visited = Array(N + 1) { false }

    //깊이 저장
    val depth = Array(N + 1) { -1 }

    //(정점, 깊이)
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.offer(R to 0)
    visited[R] = true
    depth[R] = 0

    while (queue.isNotEmpty()) {
        val (current, d) = queue.poll()
        for (next in graph[current].sorted()) {
            if (!visited[next]) {
                visited[next] = true
                depth[next] = d + 1
                queue.offer(next to d + 1)
            }
        }
    }
    for (i in 1..N) {
        println(depth[i])
    }
}