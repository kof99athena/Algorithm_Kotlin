import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, m) = readln().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
    val grid = Array(m) { readln().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray() }

    val visited = Array(m) { BooleanArray(n) }

    val queue: Queue<Pair<Int, Int>> = LinkedList()

    val dr = listOf(1, 0)
    val dc = listOf(0, 1)

    var reached = false

    if (grid[0][0] == 1) {
        queue.add(Pair(0, 0))
        visited[0][0] = true
    }

    while (queue.isNotEmpty()) {
        val (r, c) = queue.poll()

        if (r == m - 1 && c == n - 1) {
            reached = true
            break
        }

        for (i in 0..<2) {
            val nr = dr[i] + r
            val nc = dc[i] + c

            // 경계 조건 확인, 그리드의 크기를 우선 확인해야한다.
            // nr은 0 <= nr < N
            // nc는 0 <= nc < M
            if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                if (!visited[nr][nc] && grid[nr][nc] == 1) {
                    visited[nr][nc] = true
                    queue.add(Pair(nr, nc))
                }
            }
        }
    }

    if (reached) {
        println("Yes")
    } else {
        println("No")
    }
}