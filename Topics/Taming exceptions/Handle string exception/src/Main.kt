fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    if(index>word.length-1||index<0){
        println("There isn't such an element in the given string, please fix the index!")
       return
    }
    println(word[index])

}