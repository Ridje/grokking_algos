import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class BreadthFirstSearchTest {
    private val searchNormal = mapOf(
        "you" to listOf(
            "john",
            "amanda",
            "kate",
        ),
        "amanda" to listOf(
            "zet",
            "marian"
        ),
        "kate" to listOf(
            "margo",
            "cnidarian"
        )
    )

    private val searchLoop = mapOf(
        "you" to listOf(
            "john",
            "amanda",
            "kate",
        ),
        "amanda" to listOf(
            "zet",
            "marian"
        ),
        "kate" to listOf(
            "margo",
            "cnidarian"
        ),
        "marian" to listOf(
            "amanda",
            "amanda",
            "amanda",
            "kate",
            "california"
        )
    )

    private lateinit var testClass: BreadthFirstSearch

    @BeforeEach
    fun init() {
        testClass = BreadthFirstSearch()
    }

    @Test
    fun testNormalSearchCase() {
        assertEquals("margo", testClass.search(searchNormal) { friend -> friend == "margo" })
    }

    @Test
    fun testCycledSearchCase() {
        assertEquals("california", testClass.search(searchLoop) { friend -> friend == "california" })
    }

    @Test
    fun testNonExistedSearchNormalCase() {
        assertEquals(null, testClass.search(searchNormal) { friend -> friend == "katarina" })
    }

    @Test
    fun testNonExistedSearchCycledLoopCase() {
        assertEquals(null, testClass.search(searchLoop) { friend -> friend == "katarina" })
    }
}