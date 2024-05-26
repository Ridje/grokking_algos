import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class SelectionSortTest {

    private val arrayToSort = intArrayOf(9, 5, 0, -2, 15, -1, -5, 2, 25, 12, -4)
    private lateinit var testClass: SelectionSort

    @BeforeEach
    fun init() {
        testClass = SelectionSort()
    }

    @Test
    fun testRegularCases() {
        assertArrayEquals(testClass.sortBySmallest(arrayToSort), intArrayOf(-5, -4, -2, -1, 0, 2, 5, 9, 12, 15, 25))
    }
}