import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val (n, m, start) = readln().split(" ").map { it.toInt() }
    val adj = Array(n + 1) { ArrayList<Int>() }
    for (i in 1..m) {
        val (u, v) = readln().split(" ").map { it.toInt() }

        // 양방향 간선 저장
        adj[u].add(v)
        adj[v].add(u)
    }

    // 간선 오름차순으로 정렬
    for (i in 1..n) {
        adj[i].sort()
    }

    // 방문 여부 확인 BooleanArray
    val visited = BooleanArray(n + 1) { false }

    // Enqueue
    val queue: Queue<Int> = LinkedList()

    // 방문 순서
    val answer = IntArray(n + 1) { 0 }

    var order = 1
    visited[start] = true
    queue.add(start)
    answer[start] = order

    // queue의 요소가 다 사라질때까지 반복
    while (queue.isNotEmpty()) {
        val u = queue.poll() // 맨 처음엔 1

        // adj[u]와 연결된 인접 v들을 다 확인한다.
        // ex. adj[1] 이라면 [2,4]
        for (v in adj[u]) {
            if (!visited[v]) {
                order++
                visited[v] = true
                answer[v] = order
                queue.add(v)
            }
        }
    }

    for (i in 1..n) {
        println(answer[i])
    }
}