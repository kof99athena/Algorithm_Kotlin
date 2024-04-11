class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(3, 3) // [x,y]
        var total = brown + yellow
        var width = 3
        var height = 3
        for (w in 3..total) {
            height = total / w
            if ((w - 2) * (height - 2) == yellow) {
                answer[0] = w
                answer[1] = height
            }
        }
        return answer
    }
}