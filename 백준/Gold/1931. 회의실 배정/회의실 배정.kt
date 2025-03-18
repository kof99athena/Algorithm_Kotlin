fun main() {
    val N = readln().toInt()
    val intervals = Array(N) { readln().split(" ").map { it.toInt() }.toIntArray() }

    intervals.sortWith(compareBy({ it[1] }, { it[0] }))

    var count = 0
    var lastEnd = 0

    for (mettings in intervals) {
        if (mettings[0] >= lastEnd) {
            count++
            lastEnd = mettings[1]
        }
    }

    println(count)
}