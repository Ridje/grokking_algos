import kotlin.random.Random

class QSort {
    fun qSort(array: IntArray): IntArray {
        if (array.size < 2) {
            return array
        }
        val pivot = array[Random.nextInt(0, array.size)]
        val less = array.filter { it < pivot }.toIntArray()
        val greater = array.filter { it > pivot }.toIntArray()
        return qSort(less) + pivot + qSort(greater)
    }
}