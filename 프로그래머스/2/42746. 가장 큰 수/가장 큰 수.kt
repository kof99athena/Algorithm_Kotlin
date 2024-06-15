class Solution {
fun solution(numbers: IntArray): String {
    var answer = "" // 정답

    if (numbers.all { it == 0 }) {
        return "0"
    }
    var nums = numbers.map { it.toString() }
    val sortedNums = nums.sortedWith({ x, y -> (y + x).compareTo(x + y) })
    for (i in nums.indices) {
        answer += sortedNums[i]
    }
    return answer
}
}