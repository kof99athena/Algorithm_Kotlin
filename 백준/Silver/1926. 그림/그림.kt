import java.sql.Array
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max


fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val inputArray = Array(N) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val visited = kotlin.Array(N) { BooleanArray(M) }

    var count = 0
    var max = 0
    val dy = arrayOf(0, 1, 0, -1)
    val dx = arrayOf(1, 0, -1, 0)

    fun bfs(y: Int, x: Int): Int {
        var size = 1
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(y, x))

        while (queue.isNotEmpty()) {
            val (j, i) = queue.poll()
            for (k in 0 until 4) {
                val ny = j + dy[k]
                val nx = i + dx[k]

                if (ny in 0 until N && nx in 0 until M && inputArray[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true
                    size++
                    queue.add(Pair(ny, nx))
                }
            }
        }
        return size
    } // bfs

    for (j in inputArray.indices) {
        for (i in inputArray[j].indices) {
            if (inputArray[j][i] == 1 && visited[j][i] == false) {
                //전체 그림 개수 +1
                visited[j][i] = true
                count += 1
                //BFS를 통해서 그림의 크기르 구한다.
                max = max(max, bfs(j, i))
                //최대값 갱신
            }
        }
    }
    println(count)
    println(max)
}
