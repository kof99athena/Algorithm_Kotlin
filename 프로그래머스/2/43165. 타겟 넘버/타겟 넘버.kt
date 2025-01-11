class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        fun dfs(index: Int, currentSum: Int, path: List<Int>) {
            if (index == numbers.size) {
                if (currentSum == target) {
                    answer++
                }
                return
            }
            dfs(index + 1, currentSum + numbers[index], path + numbers[index])
            dfs(index + 1, currentSum - numbers[index], path + (-numbers[index]))

        }
        dfs(0, 0, emptyList())
        return answer
    }
}