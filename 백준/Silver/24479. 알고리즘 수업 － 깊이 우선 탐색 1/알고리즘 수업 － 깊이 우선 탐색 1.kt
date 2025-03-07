import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val M = scanner.nextInt()
    val R = scanner.nextInt()

    // 인접 리스트
    val graph = Array(N + 1) { mutableListOf<Int>() }
    repeat(M) {
        val u = scanner.nextInt()
        val v = scanner.nextInt()
        graph[u].add(v)
        graph[v].add(u)
    }
    for (i in 1..N) {
        graph[i].sort()
    }

    //방문 여부
    val visited = Array(N + 1) { false }

    //노드의 순서를 넣는 리스트
    val order = Array(N + 1) { 0 }
    var count = 1

    //DFS
    fun dfs(node: Int) {
        visited[node] = true
        order[node] = count++

        for (next in graph[node]) {
            if (!visited[next]) {
                dfs(next)
            }
        }
    }
    dfs(R)

    for (i in 1..N) {
        println(order[i])
    }
}

