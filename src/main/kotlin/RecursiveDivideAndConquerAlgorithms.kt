class RecursiveDivideAndConquerAlgorithms {
    fun sum(array: IntArray): Int {
        return if (array.isEmpty()) {
            0
        } else {
            array[0] + sum(array.sliceArray(1..<array.size))
        }

    }

    fun size(array: IntArray): Int {
        return if (array.isEmpty()) {
            0
        } else {
            1 + size(array.sliceArray(1..<array.size))
        }
    }

    fun max(array: IntArray): Int? {
        return if (array.isEmpty()) {
            null
        } else if (array.size == 1) {
            array[0]
        } else if (array.size == 2) {
            kotlin.math.max(array[0], array[1])
        } else {
            kotlin.math.max(
                array[0],
                max(array.sliceArray(1..<array.size))!!
            )
        }
    }

    fun binarySearch(array: IntArray, searchValue: Int, minValue: Int = 0, maxValue: Int = array.size - 1): Int? {
        if (array.isEmpty()) {
            return null
        }

        if (array.size == 1 || minValue >= maxValue) {
            return if (array[minValue] == searchValue) {
                minValue
            } else {
                null
            }
        }

        val indexPosition = (minValue + maxValue) / 2
        val guessValue = array[indexPosition]
        return if (guessValue == searchValue) {
            indexPosition
        } else {
            return if (guessValue > searchValue) {
                binarySearch(array, searchValue, minValue = minValue, maxValue = indexPosition - 1)
            } else {
                binarySearch(array, searchValue, minValue = indexPosition + 1, maxValue = maxValue)
            }
        }
    }

}