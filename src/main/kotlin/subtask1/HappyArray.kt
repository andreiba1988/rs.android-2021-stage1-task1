package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.size < 3) return sadArray

        var happyList = sadArray.toMutableList()
        var i: Int
        var isHappy = false
        while (!isHappy) {
            isHappy = true
            i = 1
            while (i < happyList.size - 1) {
                if (happyList[i] > happyList[i - 1] + happyList[i + 1]) {
                    isHappy = false
                    happyList.removeAt(i)
                }
                else i++
            }
        }

        return happyList.toIntArray()
        throw NotImplementedError("Not implemented")
    }
}
