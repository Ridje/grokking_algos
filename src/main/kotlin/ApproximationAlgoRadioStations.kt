class ApproximationAlgoRadioStations {
    fun search(divisionsNeeded: Set<Division>, availableStations: Map<Station, Set<Division>>): Set<Station> {
        var remainedDivisions = divisionsNeeded.toSet()
        val resultStations = mutableSetOf<Station>()


        while (remainedDivisions.isNotEmpty()) {
            var bestStation: Station? = null
            var coveredDivisions = setOf<Division>()

            for (station in availableStations) {
                val currentCovered = remainedDivisions.intersect(station.value)
                if (coveredDivisions.size < currentCovered.size) {
                    bestStation = station.key
                    coveredDivisions = currentCovered.toSet()
                }
            }
            remainedDivisions = remainedDivisions.minus(coveredDivisions)
            if (bestStation == null) {
                break
            }
            resultStations.add(bestStation)
        }


        return resultStations
    }

    @JvmInline
    value class Station(
        val name: String
    )

    @JvmInline
    value class Division(
        val name: String
    )
}