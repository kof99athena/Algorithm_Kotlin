import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

fun bfs(p1: Int, p2: Int, arr: Array<MutableList<Int>>, n: Int): Int {
    val queue: Queue<Int> = LinkedList()
    val visited = IntArray(n + 1) { 0 }

    queue.add(p1)
    visited[p1] = 1

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == p2) {
            return visited[p2] - 1
        }

        for (next in arr[current]) {
            if (visited[next] == 0) {
                queue.add(next)
                visited[next] = visited[current] + 1
            }
        }
    }
    return -1
}

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val p1 = scanner.nextInt()
    val p2 = scanner.nextInt()
    val relationCount = scanner.nextInt() 
    val relationArray = Array(n + 1) { mutableListOf<Int>() } 

    repeat(relationCount) {
        val a1 = scanner.nextInt()
        val b1 = scanner.nextInt()
        relationArray[a1].add(b1)
        relationArray[b1].add(a1)
    }

    val answer = bfs(p1, p2, relationArray, n)
    println(answer)
}