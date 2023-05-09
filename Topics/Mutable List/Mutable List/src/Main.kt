fun names(namesList: List<String>): List<String> {
    var count = 0
    val nameCount = mutableListOf<String>()
    val checkedName = mutableSetOf<String>()
    //
    // add your code here
    //
    for (i in 0..namesList.size - 1) {
        if (checkedName.contains(namesList[i])) {
            continue
        } else checkedName.add(namesList[i])
        for (j in i..namesList.size - 1) {

            if (namesList[i] == namesList[j]) {
                count++

            }
        }

        nameCount.add("The name ${namesList[i]} is repeated $count times")
        count = 0

    }
    return nameCount
}