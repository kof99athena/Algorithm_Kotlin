class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var remains = 0
        var taskDay = IntArray(progresses.size)

        for (i in progresses.indices) {
            remains = 100 - progresses[i]
            taskDay[i] = Math.ceil(remains.toDouble() / speeds[i]).toInt() //7,3,9
        }
        var firstTaskDay = taskDay[0]
        var count = 1

        for (i in 1 until taskDay.size) {
            if (taskDay[i] <= firstTaskDay){
                count++
            } else {
                answer.add(count)
                count = 1
                firstTaskDay = taskDay[i]
            }
        }
        answer.add(count)

        return answer.toIntArray()
    }
}