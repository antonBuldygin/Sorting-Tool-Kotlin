fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    // Write your code here. Do not print the result of the function! 

    val map = mutableMapOf<Int, String>()
//    map.putAll(currentMap)
//    var key = 0
    for ((k, v) in currentMap) {
        if (v == value)
        {continue}

        else {map+= k to v}
    }
    return map
}