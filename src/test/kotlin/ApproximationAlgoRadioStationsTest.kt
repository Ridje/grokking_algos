import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ApproximationAlgoRadioStationsTest {
    private val divisionsNeeded =
        setOf(
            ApproximationAlgoRadioStations.Division("mt"),
            ApproximationAlgoRadioStations.Division("wa"),
            ApproximationAlgoRadioStations.Division("or"),
            ApproximationAlgoRadioStations.Division("id"),
            ApproximationAlgoRadioStations.Division("nv"),
            ApproximationAlgoRadioStations.Division("ut"),
            ApproximationAlgoRadioStations.Division("ca"),
            ApproximationAlgoRadioStations.Division("az"),
        )
    private val stations: Map<ApproximationAlgoRadioStations.Station, Set<ApproximationAlgoRadioStations.Division>> =
        buildMap {
            put(
                ApproximationAlgoRadioStations.Station("kone"), setOf(
                    ApproximationAlgoRadioStations.Division("id"),
                    ApproximationAlgoRadioStations.Division("nv"),
                    ApproximationAlgoRadioStations.Division("ut")
                )
            )
            put(
                ApproximationAlgoRadioStations.Station("ktwo"), setOf(
                    ApproximationAlgoRadioStations.Division("wa"),
                    ApproximationAlgoRadioStations.Division("id"),
                    ApproximationAlgoRadioStations.Division("mt")
                )
            )
            put(
                ApproximationAlgoRadioStations.Station("kthree"), setOf(
                    ApproximationAlgoRadioStations.Division("or"),
                    ApproximationAlgoRadioStations.Division("nv"),
                    ApproximationAlgoRadioStations.Division("ca")
                )
            )
            put(
                ApproximationAlgoRadioStations.Station("kfour"), setOf(
                    ApproximationAlgoRadioStations.Division("nv"),
                    ApproximationAlgoRadioStations.Division("ut"),
                )
            )
            put(
                ApproximationAlgoRadioStations.Station("kfive"), setOf(
                    ApproximationAlgoRadioStations.Division("ca"),
                    ApproximationAlgoRadioStations.Division("az"),
                )
            )
        }
    private lateinit var testClass: ApproximationAlgoRadioStations

    @BeforeEach
    fun init() {
        testClass = ApproximationAlgoRadioStations()
    }

    @Test
    fun testRegularCases() {
        assertEquals(
            setOf(
                ApproximationAlgoRadioStations.Station("ktwo"),
                ApproximationAlgoRadioStations.Station("kthree"),
                ApproximationAlgoRadioStations.Station("kone"),
                ApproximationAlgoRadioStations.Station("kfive"),
            ),
            testClass.search(divisionsNeeded, stations),
        )
    }
}