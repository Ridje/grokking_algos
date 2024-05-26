import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class BinarySearchTest {

    private val regularCasesArray = intArrayOf(1, 3, 5, 7, 9)
    private val emptyCaseArray = intArrayOf()
    private lateinit var testClass: BinarySearch

    @BeforeEach
    fun init() {
        testClass = BinarySearch()
    }

    @Test
    fun testRegularCases() {
        regularCasesArray.forEachIndexed { index, item ->
            assert(testClass.search(regularCasesArray, item) == index)
        }
    }

    @Test
    fun testEmptyCase() {
        assertNull(testClass.search(emptyCaseArray, 25))
    }

    @Test
    fun testNonExisedCase() {
        assertNull(testClass.search(regularCasesArray, -15))
    }
}