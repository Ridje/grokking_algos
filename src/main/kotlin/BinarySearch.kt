class BinarySearch {
    fun search(array: IntArray, searchValue: Int): Int? {
        if (array.isEmpty()) {
            return null
        }

        if (array.size == 1) {
            return if (array[0] == searchValue) {
                array[0]
            } else {
                null
            }
        }

        var minPosition = 0
        var maxPosition = array.size - 1

        while (minPosition <= maxPosition) {

            val midPosition = (minPosition + maxPosition) / 2
            val guessValue = array[midPosition]

            if (guessValue == searchValue) {
                return midPosition
            }

            if (guessValue > searchValue) {
                maxPosition = midPosition - 1
            } else {
                minPosition = midPosition + 1
            }
        }
        return null
    }
}