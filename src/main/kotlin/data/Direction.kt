package data

enum class Direction(
    val dx: Int,
    val dy: Int,
) {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0),
    ;

    companion object {
        private val lookup =
            entries.associateBy { it.dx to it.dy }

        fun fromDelta(
            dx: Int,
            dy: Int,
        ): Direction = lookup[dx to dy] ?: error("direction doesnt correspond")
    }
}
