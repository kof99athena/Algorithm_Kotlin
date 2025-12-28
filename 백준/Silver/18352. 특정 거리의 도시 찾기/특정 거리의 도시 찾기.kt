import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m, k, x) = readln().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { ArrayList<Int>() }
    for (i in 0..<m) {
        val (u, v) = readln().split(" ").map { it.toInt() }
        adj[u].add(v) // 단방향
    }
    val queue: Queue<Int> = LinkedList()

    //최단거리 저장 배열
    val answer = IntArray(n + 1) { -1 }

    answer[x] = 0
    queue.add(x) // 출발도시 1로 출발

    while (queue.isNotEmpty()) {
        val u = queue.poll()

        for (v in adj[u]) {
            // 아직 방문 전이라면?
            if (answer[v] == -1) {
                answer[v] = answer[u] + 1
                queue.add(v)
            }
        }
    }

    val result = ArrayList<Int>()

    for (i in 1..n) {
        if (answer[i] == k) {
            result.add(i)
        }
    }

    if (result.isEmpty()) {
        println(-1)
    } else {
        result.sort()
        for (city in result) {
            println(city)
        }
    }
}