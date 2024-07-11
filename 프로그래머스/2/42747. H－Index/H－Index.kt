class Solution {
    fun solution(citations: IntArray): Int {
        var sortedCitations = citations.sortedDescending()
        var HIndex = 0

        for (i in sortedCitations.indices) {
            if (sortedCitations[i] >= i + 1){
                HIndex = i + 1
            } else {
                break
            }
        }
        return HIndex
    }
}