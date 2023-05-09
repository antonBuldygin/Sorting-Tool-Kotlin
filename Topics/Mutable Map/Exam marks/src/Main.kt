fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    val flag: Boolean = true
    var str = ""
    var count = 0
    while (flag) {
        str = readln()
        count++
        if (str == "stop") {
            break
        } else {

            if (count % 2 != 0 && studentsMarks.containsKey(str)) {
                str = readln().toString()
                count++
            }
            if (count % 2 != 0 && str == "stop") {
                break
            }
            if (count % 2 != 0 && !studentsMarks.containsKey(str)) {
                studentsMarks[str] = readln().toInt()
                count++
            }
        }

    }
    println(studentsMarks)

}