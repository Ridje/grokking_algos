import java.util.*

class HashTable(
    private val loadFactor: Float = 0.7f,
    initSize: Int = 10
) {
    private var container: Array<LinkedList<Pair<String, String>>> = Array(initSize) { LinkedList() }
    private var _size = 0
        set(value) {
            field = value
            if (_size.toFloat() / container.size > loadFactor) {
                rearrangeTable()
            }
        }
    val size get() = _size

    fun insert(key: String, value: String) {
        val hash = calculateHash(key)
        val cell = calculateCell(hash)
        val cellList = container[cell]
        val insertingKey = Pair(key, value)
        val linkedListIndex = cellList.indexOfFirst { it.first == key }
        if (linkedListIndex != -1) {
            cellList[linkedListIndex] = insertingKey
        } else {
            cellList.add(insertingKey)
            _size++
        }
    }

    fun remove(key: String) {
        val hash = calculateHash(key)
        val cell = calculateCell(hash)
        val cellList = container[cell]
        val linkedListIndex = cellList.indexOfFirst { it.first == key }
        if (linkedListIndex != -1) {
            cellList.removeAt(linkedListIndex)
            _size--
        }
    }

    fun getValue(key: String): String? {
        val hash = calculateHash(key)
        val cell = calculateCell(hash)
        val cellList = container[cell]
        return cellList.firstOrNull { it.first == key }?.second
    }

    private fun rearrangeTable() {
        val oldContainer = container.copyOf()
        container = Array(oldContainer.size * 2) { LinkedList() }
        _size = 0
        oldContainer.flatMap { it }.forEach { pair ->
            insert(pair.first, pair.second)
        }
    }

    private fun calculateHash(key: String): Int {
        var hash = 5381
        for (char in key) {
            hash = (hash * 33) + char.code
        }
        return hash
    }

    private fun calculateCell(hash: Int): Int {
        return hash % container.size
    }
}