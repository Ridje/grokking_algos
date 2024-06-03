class DijkstraGraphSearch {
    // graph starts with 'start'-node
    // graph destination is 'end'-node
    fun findShortestPathWeighted(graph: Map<String, Map<String, Int>>): Int? {

        // null means infinite
        val costs = mutableMapOf<String, Int?>()
        val parents = mutableMapOf<String, String?>()
        val processed = mutableSetOf<String>()

        graph["start"]?.forEach {
            costs[it.key] = it.value
            parents[it.key] = "start"
        }
        parents["end"] = null
        costs["end"] = null

        var node = findTheLowestCostNode(costs, processed)
        while (node != null) {
            val neighbors = graph[node]
            val cost = costs[node]
            neighbors?.forEach {
                val newCost = (cost ?: 0) + it.value
                val oldCost = costs[it.key]
                if (oldCost == null || oldCost > newCost) {
                    costs[it.key] = newCost
                    parents[it.key] = node
                }
            }
            processed.add(node)
            node = findTheLowestCostNode(costs, processed)
        }
        return costs["end"]
    }

    private fun findTheLowestCostNode(costs: Map<String, Int?>, processed: Set<String>): String? {
        var lowestCost: Int? = null
        var lowestCostNode: String? = null

        for (node in costs) {
            val cost = node.value
            if (cost != null && (lowestCost == null || cost < lowestCost) && !processed.contains(node.key)) {
                lowestCost = cost
                lowestCostNode = node.key
            }
        }
        return lowestCostNode
    }
}