import java.util.ArrayDeque
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val M = scanner.nextInt()
    val R = scanner.nextInt()

    //인접 리스트
    val graph = Array(N + 1) { mutableListOf<Int>() }
    for (i in 1..M) {
        val u = scanner.nextInt()
        val v = scanner.nextInt()
        graph[u].add(v)
        graph[v].add(u)
    }
    for (i in 1..N) {
        graph[i].sortDescending()
    }

    //방문 여부를 확인하는 리스트
    val visited = Array(N + 1) { false }

    // 방문 순서를 저장할 배열
    val order = Array(N + 1) { 0 }
    var count = 1

    //방문 순서를 넣은 덱
    val answerDeque = ArrayDeque<Int>()
    answerDeque.add(R)
    visited[R] = true
    order[R] = count

    while (answerDeque.isNotEmpty()) {
        val current = answerDeque.removeFirst()
        for (next in graph[current]) {
            if (!visited[next]) {
                answerDeque.add(next)
                visited[next] = true
                count++
                order[next] = count
            }
        }
    }

    for (i in 1..N) {
        println(order[i])
    }
}