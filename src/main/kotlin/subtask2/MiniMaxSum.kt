package subtask2

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
        var elementSum = 0
        var min: Int
        var max = 0

        for (item in input) {
            elementSum += item
        }
        min = elementSum
        for (item in input) {
            val currentSum = elementSum - item

            if (currentSum > max) {
                max = currentSum
            } else if (currentSum < min) {
                min = currentSum
            }
        }
        return intArrayOf(min, max)
        throw NotImplementedError("Not implemented")
    }
}
