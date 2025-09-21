class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer = 0
        val n = dungeons.size
        val visited = BooleanArray(n)

        fun dfs(hp: Int, count: Int) {
            if (count > answer) answer = count

            for (i in 0 until n) {
                if (visited[i]) continue // 방문했으면 i+1로 넘어가기

                val requestFatigue = dungeons[i][0]
                val cost = dungeons[i][1]

                if (hp >= requestFatigue) {
                    visited[i] = true
                    dfs(hp - cost, count + 1)
                    visited[i] = false
                }
            }
        }
        dfs(k, 0)
        return answer
    }
}
