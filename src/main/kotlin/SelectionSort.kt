class SelectionSort {
    fun sortBySmallest(array: IntArray): IntArray {
        for (index in array.indices) {
            val smallestIndex = findSmallestIndex(array, index)
            val currentValue = array[index]
            array[index] = array[smallestIndex]
            array[smallestIndex] = currentValue
        }
        return array
    }

    private fun findSmallestIndex(array: IntArray, startFromIndex: Int): Int {
        var smallest = array[startFromIndex]
        var smallestIndex = startFromIndex
        for (index in startFromIndex..<array.size) {
            if (array[index] < smallest) {
                smallest = array[index]
                smallestIndex = index
            }
        }

        return smallestIndex
    }
}