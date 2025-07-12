class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        //방문 여부 확인을 위한 BooleanArray
        val visited = BooleanArray(n) { false }

        for (start in 0 until n) {
            if (visited[start].not()) {
                answer += 1
                dfs(n, start, visited, computers)
            }
        }
        return answer
    }

    fun dfs(n: Int, start: Int, visited: BooleanArray, computers: Array<IntArray>) {
        visited[start] = true
        for (end in 0 until n) {
            if (computers[start][end] == 1 && visited[end].not()) {
                dfs(n, end, visited, computers)
            }
        }
    }
}
