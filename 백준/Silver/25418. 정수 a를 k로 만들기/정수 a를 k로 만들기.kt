import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var A = scanner.nextInt()
    var K = scanner.nextInt()
    var answer = 0

    while (K > A) {
        when {
            K % 2 == 0 && K / 2 >= A -> K /= 2
            else -> K -= 1
        }
        answer++
    }
    println(answer)
}