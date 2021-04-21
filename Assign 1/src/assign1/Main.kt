fun isComposite(number: Int): Boolean {

    for (i in 2..number / 2) {
        if (number % i == 0) {
            return true
        }
    }
    return false
}

fun main() {
    println(isComposite(7))
    println(isComposite(8))
}
