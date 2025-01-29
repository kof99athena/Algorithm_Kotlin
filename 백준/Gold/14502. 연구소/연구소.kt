import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val M = scanner.nextInt()
    val arr = Array(N) { IntArray(M) { scanner.nextInt() } }
    val visited = Array(N) { IntArray(M) { 0 } }
    var answer = 0

    val directions = arrayOf(
        Pair(-1, 0),
        Pair(1, 0),
        Pair(0, -1),
        Pair(0, 1),
    )

    fun bfs(i: Int, j: Int, spreadVirusArr: Array<IntArray>) {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(i, j))
        visited[i][j] = 1

        while (queue.isNotEmpty()) {
            val (ci, cj) = queue.poll() 
            for ((di, dj) in directions) {
                val ni = ci + di
                val nj = cj + dj
                if (ni in 0 until N && nj in 0 until M && spreadVirusArr[ni][nj] == 0) {
                    queue.add(Pair(ni, nj))
                    spreadVirusArr[ni][nj] = 2 
                }
            }
        }
    }

    fun addSafeZonecCount(spreadVirusArr: Array<IntArray>): Int {
        var zoneCount = 0
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (spreadVirusArr[i][j] == 0) {
                    zoneCount++
                }
            }
        }
        return zoneCount
    }

    fun setWalls(count: Int) {
        if (count == 3) {
            val spreadVirusArr = Array(N) { arr[it].copyOf() }
            for (i in arr.indices) {
                for (j in arr[i].indices) {
                    if (spreadVirusArr[i][j] == 2) {
                        bfs(i, j, spreadVirusArr)
                    }
                }
            }
            answer = maxOf(answer, addSafeZonecCount(spreadVirusArr))
            return
        }
        for (i in arr.indices) {
            for (j in arr[i].indices) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1 
                    setWalls(count + 1)
                    arr[i][j] = 0
                }
            }
        }
    }

    setWalls(0)
    println(answer)
}