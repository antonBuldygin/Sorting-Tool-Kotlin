fun solution(strings: List<String>, str: String): Int {
    // put your code here
    var count =0
    for( stre in strings){
        if(stre==str){count++}
    }
    return count
}