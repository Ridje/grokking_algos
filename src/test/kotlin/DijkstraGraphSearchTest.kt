import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DijkstraGraphSearchTest {

    private val graph: MutableMap<String, Map<String, Int>> = mutableMapOf()

    private lateinit var testClass: DijkstraGraphSearch

    @BeforeEach
    fun init() {
        testClass = DijkstraGraphSearch()
        graph.clear()
    }

    @Test
    fun testNormalCases() {
        graph["start"] = mapOf(
            "A" to 6,
            "B" to 2,
        )
        graph["A"] = mapOf(
            "end" to 1
        )
        graph["B"] = mapOf(
            "A" to 3,
            "end" to 5,
        )
        graph["end"] = mapOf()
        assertEquals(6, testClass.findShortestPathWeighted(graph))
    }

    @Test
    fun testNormalCase71() {
        graph["start"] = mapOf(
            "A" to 5,
            "B" to 2,
        )
        graph["A"] = mapOf(
            "C" to 4,
            "D" to 2,
        )
        graph["B"] = mapOf(
            "A" to 8,
            "D" to 7,
        )
        graph["C"] = mapOf(
            "end" to 3,
            "D" to 6,
        )
        graph["D"] = mapOf(
            "end" to 1,
        )
        graph["end"] = mapOf()
        assertEquals(8, testClass.findShortestPathWeighted(graph))
    }

    @Test
    fun testNormalCaseBackCase() {
        graph["start"] = mapOf(
            "A" to 10,
        )
        graph["A"] = mapOf(
            "B" to 20,
        )
        graph["B"] = mapOf(
            "C" to 1,
            "end" to 30,
        )
        graph["C"] = mapOf(
            "A" to 1,
        )
        graph["end"] = mapOf()
        assertEquals(60, testClass.findShortestPathWeighted(graph))
    }

    @Test
    fun testNoEndAchievedEver() {
        graph["start"] = mapOf(
            "A" to 5,
            "B" to 2,
        )
        graph["A"] = mapOf(
            "C" to 4,
            "D" to 2,
        )
        graph["B"] = mapOf(
            "A" to 8,
            "D" to 7,
        )
        graph["C"] = mapOf(
            "D" to 6,
        )
        graph["D"] = mapOf()
        graph["end"] = mapOf()
        assertEquals(null, testClass.findShortestPathWeighted(graph))
    }
}