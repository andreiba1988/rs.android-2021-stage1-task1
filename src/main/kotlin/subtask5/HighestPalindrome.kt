package subtask5

class HighestPalindrome {

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        val str = digitString.toCharArray()
        if (n % 2 == 1) return "-1"
        val numberOfUnpaired = getNumberOfUnpaired(str)
        if (numberOfUnpaired > k && k != 1) return "-1"
        val numberOfReplace = k - numberOfUnpaired
        for (i in 0 until numberOfReplace) {
            val minIndex = getMinimal(str)
            str.setPairValue(minIndex, '9')
        }
        for (i in 0 until k - numberOfReplace * 2) {
            val max = getMax(str)
            val maxValue = str[max]
            str.setPairValue(max, maxValue)
        }
        return str.joinToString("")
        throw NotImplementedError("Not implemented")
    }

    private fun getMinimal(digitString: CharArray): Int {
        var min = Int.MAX_VALUE
        var minIndex = 0
        for (i in digitString.indices) {
            if (digitString.isMirrorSame(i)) continue
            else {
                if (digitString[i].toInt() < min) {
                    minIndex = i
                    min = digitString[i].toInt()
                }
                if (digitString.getMirror(i).toInt() < min) {
                    minIndex = digitString.getMirrorIndex(i)
                    min = digitString[minIndex].toInt()
                }
            }
        }
        return minIndex
    }

    private fun getMax(digitString: CharArray): Int {
        var max = Int.MIN_VALUE
        var maxIndex = 0
        for (i in digitString.indices) {
            if (digitString.isMirrorSame(i)) continue
            else {
                if (digitString[i].toInt() > max) {
                    maxIndex = i
                    max = digitString[i].toInt()
                }
                if (digitString.getMirror(i).toInt() > max) {
                    maxIndex = digitString.getMirrorIndex(i)
                    max = digitString[maxIndex].toInt()
                }
            }
        }
        return maxIndex
    }

    private fun CharArray.setPairValue(index: Int, value: Char) {
        val pairIndex = if (index >= (this.size / 2)) ((this.size) - (index -1)) else ((this.size) - 1) - index
        this[pairIndex] = value
        this[index] = value
    }

    private fun getNumberOfUnpaired(digitString: CharArray): Int {
        var pairCount = 0
        for (i in 0 until digitString.size / 2) {
            if (!digitString.isMirrorSame(i)) pairCount++
        }
        return pairCount
    }

    private fun CharArray.getMirror(index: Int): Char {
        return this[this.lastIndex - index]
    }

    private fun CharArray.getMirrorIndex(index: Int): Int {
        return this.lastIndex - index
    }

    private fun CharArray.isMirrorSame(index: Int): Boolean {
        return this[index] == this.getMirror(index)
    }
}
