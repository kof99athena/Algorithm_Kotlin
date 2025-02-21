class Solution {
    fun solution(numbers: IntArray): IntArray {
    val answer = IntArray(numbers.size) { -1 }
    var answerList = mutableListOf<Int>()

    for (i in numbers.indices) {
        while (answerList.isNotEmpty() && numbers[answerList.last()] < numbers[i]) {
            val index = answerList.removeAt(answerList.lastIndex)
            answer[index] = numbers[i]
        }
        answerList.add(i)
    }
    return answer
}
}