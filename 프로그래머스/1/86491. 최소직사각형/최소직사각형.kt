class Solution {
    fun solution(sizes: Array<IntArray>): Int {

        var width = 0
        var height = 0
        for (s in sizes) {
            val w = maxOf(s[0], s[1])
            val h = minOf(s[0], s[1])
            width = maxOf(width, w)
            height = maxOf(height, h)
        }
        return width * height
    }
}
