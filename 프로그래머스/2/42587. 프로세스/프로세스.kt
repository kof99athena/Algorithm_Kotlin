class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue = priorities.mapIndexed { index, priority -> Pair(index, priority) }.toMutableList()
        var number = 0

        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            if (queue.any { it.second > current.second }) {
                queue.add(current)
            } else {
                number++
                if (current.first == location) {
                    return number
                }
            }
        }
        return number
    }
}