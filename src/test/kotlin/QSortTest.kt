import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class QSortTest {
    private val arrayToSort = intArrayOf(9, 5, 0, -2, 15, -1, -5, 2, 25, 12, -4)
    private lateinit var testClass: QSort

    @BeforeEach
    fun init() {
        testClass = QSort()
    }

    @Test
    fun testRegularCases() {
        assertArrayEquals(testClass.qSort(arrayToSort), arrayToSort.sortedArray())
    }
}