package sorting

import java.io.File
import java.nio.IntBuffer
import java.util.*

fun main(args: Array<String>) {

//    println(args.joinToString (  ))
    val map = mutableMapOf<String, String>()

    for (i in 0 until args.size) {
        if (i % 2 == 0) {
            if (i <= args.size - 2) {
                map.put(args[i], args[i + 1])
            }
            if (i == args.size - 1) {
                map.put(args[i], "")
            }
        }

    }

//    println(map)
//    println(map["-dataType"])

    for ((k, v) in map) {
        if (k != "-dataType" && k != "-sortingType" && k != "-inputFile" && k != "-outputFile") {
            println("\"$k\" is not a valid parameter. It will be skipped.")
        }
    }



    if (map["-sortingType"] == ""
    ) {
        println("No sorting type defined!")
    }


    if (map["-dataType"] == "long" && (map["-sortingType"] == "natural"
                || !map.containsKey("-sortingType"))
    ) {
        val input = map["-inputFile"].toString()
        val output = map["-outputFile"].toString()

        number(input, output)
    }
    if (map["-dataType"] == "long" && (map["-sortingType"] == "byCount")
    ) {

        numberByCount()
    }
    if ((map["-dataType"] == "word" || map["-dataType"] ==null) && (map["-sortingType"] == "byCount")
    ) {
        val input = map["-inputFile"].toString()
        val output = map["-outputFile"].toString()
        wordByCount(input,output)
    }

    if ((map["-dataType"] == "word" || map["-dataType"] ==null)&& (map["-sortingType"] == "natural")
    ) {

        word()
    }

    if (map["-dataType"] == "line" && (map["-sortingType"] == "byCount")
    ) {

        lineByCount()
    }

    if (map["-dataType"] == "line" && (map["-sortingType"] == "natural")
    ) {

        line()
    }

//    if (map["-dataType"] == ""||map["-dataType"] ==null
//    ) {
//        println("No data type defined!")
//    }
}

fun number(input: String, output: String) {
    var count = 0
    var lines = ""
    var str = ""
    val numbers = mutableListOf<Int>()

    if (input != "null") {
        val file = File(input)
        if (file.exists()) { // checks if file exists
            lines = file.readText()
            print(lines)
            val split = lines.split("\\s+")
//            print(split)
            split.toMutableList().sort()
            count = split.size
            str = split.joinToString().replace(",", " ")
        }

    } else {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNext()) {
            val d = scanner.next().toInt()
            count++
            numbers.add(d)

        }
        scanner.close()
        numbers.sort()
        str = numbers.joinToString().replace(",", " ")
    }

    if (output != "null") {
        val workingDirectory = System.getProperty ("user.dir")
        val separator = File.separator
        println("${workingDirectory}${separator}$output")
        val myFile = File("${workingDirectory}${separator}$output" )

        if (!myFile.exists()) {
            myFile.createNewFile()
        }//file name must be indicated in parentheses
        myFile.writeText("Total numbers:$count\nSorted data: $str\n")
    } else {
        println("Total numbers:$count")
        println("Sorted data: $str")
    }
}

fun word() {
    var count = 0
    val numbers = mutableListOf<String>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val d = scanner.next().toString()
        count++
        numbers.add(d)

    }
    scanner.close()
    numbers.sort()
    var str = numbers.joinToString().replace(",", " ")
    println("Total numbers:$count")
    println("Sorted data: $str")
}

fun line() {
    var count = 0
    val numbers = mutableListOf<String>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val d = scanner.next().toString()
        count++
        numbers.add(d)

    }
    scanner.close()
    numbers.sort()
    var str = numbers.joinToString().replace(",", " ")
    println("Total numbers:$count")
    println("Sorted data: $str")
}

fun numberByCount() {
    var count = 0
    var countKey = 0
    val numbers = mutableListOf<Int>()
    val map = mutableMapOf<Int, Int>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val d = scanner.next().toInt()

        numbers.add(d)
        count++
    }

    scanner.close()

    for (i in 0 until numbers.size) {
        countKey = 1
        if (map.containsKey(numbers[i])) {
            continue
        }
        if (!map.containsKey(numbers[i])) {
            map.put(numbers[i], countKey)
        }
        for (j in i + 1 until numbers.size) {

            if (numbers[i] == numbers[j]) {
                countKey++
                map.put(numbers[i], countKey)
            }

        }

    }

    val sorted = map.toSortedMap().toList().sortedBy { (_, value) -> value }.toMap()


    println("Total numbers: $count.")
    for ((k, v) in sorted) {
        println("$k: $v time(s), ${Math.round(v.toDouble() / count.toDouble() * 100)}%")
    }
}


fun wordByCount(input: String, output: String) {
    var count = 0
    var countKey = 0
    var lines = ""
    var str = ""
    var numbers = mutableListOf<String>()
    val map = mutableMapOf<String, Int>()

    if (input != "null") {
        val file = File(input)
        if (file.exists()) { // checks if file exists
            lines = file.readText()
            print(lines)
            val split = lines.split("\\s+")
//            print(split)
            numbers = split.toMutableList()
            numbers.sort()
            count = numbers.size

        }

    } else {
        val scanner = Scanner(System.`in`)
        while (scanner.hasNext()) {
            val d = scanner.next().toString()

            numbers.add(d)
            count++
        }

        scanner.close()
    }

    for (i in 0 until numbers.size) {
        countKey = 1
        if (map.containsKey(numbers[i])) {
            continue
        }
        if (!map.containsKey(numbers[i])) {
            map.put(numbers[i], countKey)
        }
        for (j in i + 1 until numbers.size) {

            if (numbers[i] == numbers[j]) {
                countKey++
                map.put(numbers[i], countKey)
            }

        }

    }

    val sorted = map.toSortedMap().toList().sortedBy { (_, value) -> value }.toMap()

    if (output != "null") {
        val workingDirectory = System.getProperty("user.dir")
        val separator = File.separator
        println("${workingDirectory}${separator}$output")
        val myFile = File("${workingDirectory}${separator}$output")

        if (!myFile.exists()) {
            myFile.createNewFile()
        }//file name must be indicated in parentheses
        myFile.writeText("Total numbers:$count\n")
        for ((k, v) in sorted) {
            myFile.appendText("$k: $v time(s), ${Math.round(v.toDouble() / count.toDouble() * 100)}%")
        }
    } else {
        println("Total numbers: $count.")
        for ((k, v) in sorted) {
            println("$k: $v time(s), ${Math.round(v.toDouble() / count.toDouble() * 100)}%")
        }
    }
}
fun lineByCount() {
    var count = 0
    var countKey = 0
    val numbers = mutableListOf<String>()
    val map = mutableMapOf<String, Int>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val d = scanner.nextLine().toString()

        numbers.add(d)
        count++
    }

    scanner.close()

    for (i in 0 until numbers.size) {
        countKey = 1
        if (map.containsKey(numbers[i])) {
            continue
        }
        if (!map.containsKey(numbers[i])) {
            map.put(numbers[i], countKey)
        }
        for (j in i + 1 until numbers.size) {

            if (numbers[i] == numbers[j]) {
                countKey++
                map.put(numbers[i], countKey)
            }

        }

    }

    val sorted = map.toSortedMap().toList().sortedBy { (_, value) -> value }.toMap()


    println("Total numbers: $count.")
    for ((k, v) in sorted) {
        println("$k: $v time(s), ${Math.round(v.toDouble() / count.toDouble() * 100)}%")
    }
}
