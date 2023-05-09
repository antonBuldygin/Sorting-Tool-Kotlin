fun main() {
    // write your code here
    val nc = readln().toInt()
    var list = MutableList(nc) { readln().toDouble() }
    val tax = MutableList(nc) { readln().toDouble() }
    var max = 0.0
    var comNum = 0

//    println("list ${list.joinToString(":")} and tax ${tax.joinToString(", ")}")

    for (i in 0..nc - 1) {
        if (tax[i] == 0.0) {
            continue
        }
        if (i == 0) {
            max = (list[i] * tax[i]) / 100.0

        }
        if (i != 0 && max < (list[i] * tax[i]) / 100) {
            max = (list[i] * tax[i]) / 100
            comNum = i
        }
        if (i != 0 && max == (list[i] * tax[i]) / 100) {
            continue
        }

    }
    println("${comNum + 1}")

}

