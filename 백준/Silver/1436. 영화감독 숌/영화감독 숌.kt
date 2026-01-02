fun main() {
    val n = readln().toInt()

    var devilNumber = 665
    var series = 0

    while (true) {
        devilNumber++
        if (devilNumber.toString().contains("666")) {
            series++
            if (n == series) break
        }
    }
    println(devilNumber)
}