import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RecursiveDivideAndConquerAlgorithmsTest {
    private val arrayToSort = intArrayOf(9, 5, 0, -2, 15, -1, -5, 2, 25, 12, -4)
    private val arraySorted = arrayToSort.sortedArray()
    private lateinit var testClass: RecursiveDivideAndConquerAlgorithms

    @BeforeEach
    fun init() {
        testClass = RecursiveDivideAndConquerAlgorithms()
    }

    @Test
    fun testSum() {
        assertEquals(arrayToSort.sum(), testClass.sum(arrayToSort))
    }

    @Test
    fun testSize() {
        assertEquals(arrayToSort.size, testClass.size(arrayToSort))
    }

    @Test
    fun testMax() {
        assertEquals(arrayToSort.max(), testClass.max(arrayToSort))
    }

    @Test
    fun testRegularCases() {
        arraySorted.forEachIndexed { index, item ->
            assertEquals(index, testClass.binarySearch(arraySorted, item))
        }
    }

    @Test
    fun testEmptyCase() {
        assertNull(testClass.binarySearch(intArrayOf(), 25))
    }

    @Test
    fun testNonExistedCase() {
        assertNull(testClass.binarySearch(arraySorted, -999))
        assertNull(testClass.binarySearch(arraySorted, 999))
    }

}