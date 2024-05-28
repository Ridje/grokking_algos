import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class HashTableTest {
    private lateinit var testClass: HashTable

    @BeforeEach
    fun init() {
        testClass = HashTable()
    }

    @Test
    fun testAdd() {
        testClass.insert("myItem", "myValue")
        assertEquals(1, testClass.size)
        assertEquals(testClass.getValue("myItem"), "myValue")
    }

    @Test
    fun testAddTwice() {
        testClass.insert("1", "value_1")
        testClass.insert("2", "value_2")
        assertEquals(2, testClass.size)
        assertEquals(testClass.getValue("1"), "value_1")
        assertEquals(testClass.getValue("2"), "value_2")
    }

    @Test
    fun testAddSameKey() {
        testClass.insert("1", "value_1")
        testClass.insert("1", "value_2")
        assertEquals(1, testClass.size)
        assertEquals(testClass.getValue("1"), "value_2")
    }

    @Test
    fun testLoadFactor() {
        for (i in 1..120) {
            testClass.insert(i.toString(), "value_$i")
            assertEquals(i, testClass.size)
        }

        for (i in 1..120) {
            assertEquals(testClass.getValue(i.toString()), "value_$i")
        }

        for (i in 1..120) {
            testClass.remove(i.toString())
            assertEquals(120 - i, testClass.size)
        }

        assertEquals(0, testClass.size)

        for (i in 1..120) {
            assertEquals(testClass.getValue(i.toString()), null)
        }
    }
}