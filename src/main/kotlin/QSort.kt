class QSort {
    fun qSort(array: IntArray): IntArray {
        if (array.size < 2) {
            return array
        }
        val pivot = array[0]
        val less = array.drop(1).filter { it <= pivot }.toIntArray()
        val greater = array.drop(1).filter { it > pivot }.toIntArray()
        return qSort(less) + pivot + qSort(greater)
    }
}