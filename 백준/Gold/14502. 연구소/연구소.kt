import java.util.ArrayDeque
import java.util.Queue
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val N = scanner.nextInt()
    val M = scanner.nextInt()
    val arr = Array(N) { IntArray(M) { scanner.nextInt() } }
    var answer = 0

    val directions = arrayOf(
        Pair(-1, 0),
        Pair(1, 0),
        Pair(0, -1),
        Pair(0, 1),
    )

    fun bfs(i: Int, j: Int, spreadVirusArr: Array<IntArray>) {
        val queue: Queue<Pair<Int, Int>> = java.util.ArrayDeque()
        queue.add(Pair(i, j))

        while (queue.isNotEmpty()) {
            val (ci, cj) = queue.poll() 
            for ((di, dj) in directions) {
                val ni = ci + di
                val nj = cj + dj
                if (ni in 0..<N && nj in 0..<M && spreadVirusArr[ni][nj] == 0) {
                    queue.add(Pair(ni, nj)) 
                    spreadVirusArr[ni][nj] = 2 
                }
            }
        }
    }

    fun addSafeZoneCount(spreadVirusArr: Array<IntArray>): Int {
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
            answer = maxOf(answer, addSafeZoneCount(spreadVirusArr))
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