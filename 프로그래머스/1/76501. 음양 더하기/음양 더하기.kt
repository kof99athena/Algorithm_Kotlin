class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray ): Int {
    var sign: String = "+"
    var number:Int = 0

    for (i in 0 until absolutes.size) {
        if (signs[i] == false) {
            sign = "-"
        } else {
            sign = "+"
        }
        number += (sign + absolutes[i].toString()).toInt()

    }
    return number
}
}