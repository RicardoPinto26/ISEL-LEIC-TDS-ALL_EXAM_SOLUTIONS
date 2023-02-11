data class Occupancy(val current: Int, val capacity: Int) {
    init {
        require(capacity >= 0 && current in 0..capacity)
    }

    val isFull get() = current == capacity
    val isEmpty get() = current == 0
}

fun Occupancy.increment(): Occupancy {
    check(!isFull)
    return copy(current = current + 1)
}

fun Occupancy.decrement() = copy(current = current - 1).also { check(!isEmpty) }

