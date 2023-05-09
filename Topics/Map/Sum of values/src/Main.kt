fun summator(map: Map<Int, Int>): Int {
    // put your code here
    var sum = 0
    for (m in map) {
        if (m.key % 2 == 0) {
            sum = sum + m.value
        }
    }
    return sum
}