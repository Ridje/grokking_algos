import java.util.LinkedList

class BreadthFirstSearch {
    fun search(array: Map<String, List<String>>, you: String = "you", searchCondition: (String) -> Boolean): String? {
        val searchQueue = LinkedList<String>()
        val checkedFriends = mutableSetOf<String>()
        array[you]?.forEach { friend ->
            searchQueue.offer(friend)
        }
        while (searchQueue.isNotEmpty()) {
            val friend = searchQueue.poll()
            if (searchCondition(friend)) {
                return friend
            }
            checkedFriends.add(friend)
            array[friend]?.forEach { friendsFriend ->
                if (!checkedFriends.contains(friendsFriend)) {
                    searchQueue.offer(friendsFriend)
                }
            }
        }
        return null
    }
}

