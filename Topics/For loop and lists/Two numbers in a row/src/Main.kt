fun main() {
    // write your code here
    var n = readln().toInt()
    var list = MutableList(n) { readln().toInt() }
    var (a, b) = readln().split(" ")


    for (i in 0..list.size) {

        if (i < list.size - 1 && (list[i] == a.toInt() && list[i + 1] == b.toInt()
                    || list[i] == b.toInt() && list[i + 1] == a.toInt())
        ) {
            println("NO")
            break
        }

        if (i == list.size - 2 && ((list[i] != a.toInt()
                    && list[i + 1] != b.toInt()) || (list[i] != b.toInt() && list[i + 1] != a.toInt()))
        ) {
            println("YES")

        }

    }

}