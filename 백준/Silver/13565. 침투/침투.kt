import java.util.LinkedList
import java.util.Queue

fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }

    val adj = Array(m) { IntArray(n) }
    for (i in 0..<m) {
        val input = readln().map { it.toString().toInt() }
        for (j in 0..<n) {
            adj[i][j] = input[j]
        }
    }
    val visited = Array(m) { BooleanArray(n) }

    //좌표를 저장하기위해 Pair 이용한다
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    //BFS 시작점
    for (j in 0..<n) {
        if (adj[0][j] == 0) {
            queue.add(Pair(0, j))
            visited[0][j] = true
        }
    }

    val dr = intArrayOf(0, 0, 1, -1) // 행: 상하좌우
    val dc = intArrayOf(1, -1, 0, 0) // 열: 우좌상하

    var reached = false

    while (queue.isNotEmpty()) {
        val (r, c) = queue.poll()

        if (r == m - 1) {
            reached = true
            break // 도달했으면 더 이상 탐색할 필요가 없습니다.
        }

        for (i in 0..<4) {
            val nr = r + dr[i] // 새로운 행
            val nc = c + dc[i] // 새로운 열

            // 범위 내에 포함인가?
            if (nr in 0..<m && nc in 0..<n) {
                if (!visited[nr][nc] && adj[nr][nc] == 0) {
                    visited[nr][nc] = true
                    queue.add(Pair(nr, nc))
                }
            }
        }
    }

    if (reached) {
        println("YES")
    } else {
        println("NO")
    }
}