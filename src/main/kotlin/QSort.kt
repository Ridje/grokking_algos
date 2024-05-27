import kotlin.random.Random

class QSort {
    fun qSort(array: IntArray): IntArray {
        if (array.size < 2) {
            return array
        }
        val pivot = array[Random.nextInt(0, array.size)]
        val (less, great) = array.partition { it < pivot }
        return qSort(less.toIntArray()) + qSort(great.toIntArray())
    }
}