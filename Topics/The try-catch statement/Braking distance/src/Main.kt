import kotlin.Exception

fun calculateBrakingDistance(v1: String, a: String): Int {

    var s = -1
    try {

        s = -v1.toInt() * v1.toInt() / (2 * a.toInt())

    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        return s
    } catch (e: Exception) {
       println( e.message)
        return s

    }
    return s
    // write your code here
}