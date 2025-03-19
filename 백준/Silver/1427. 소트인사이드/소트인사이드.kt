fun main() {
    val N = readln()
    val size = N.length
    var arr = mutableListOf<String>()

    for (i in 0 until size) {
        arr.add(N[i].toString())
    }

    val sortedArr = arr.sortedDescending()
    println(sortedArr.joinToString(""))
}