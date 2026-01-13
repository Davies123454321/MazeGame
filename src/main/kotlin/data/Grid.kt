package data

class Grid(
    val width: Int,
    val height: Int,
) {
    private val tiles: Array<Tile> = Array(width * height) { Tile(TileType.FLOOR) }

    fun tileAt(
        x: Int,
        y: Int,
    ): Tile = tiles[y * width + x]

    fun isWalkable(
        x: Int,
        y: Int,
    ): Boolean {
        if (x in 0 until width && y in 0 until height) {
            val index = (y * width) + x
            return tiles[index].type == TileType.FLOOR
        } else {
            return false
        }
    }

    fun getNeighbours(
        x: Int,
        y: Int,
    ): List<Pair<Int, Int>> {
//        val output = mutableListOf<Pair<Int, Int>>()
//        for (i in (x - 1)..(x + 1)) {
//            for (j in (y - 1)..(y + 1)) {
//                if (i == x && j == y) continue
//                if (isWalkable(i, j)) {
//                    output.add(i to j)
//                }
//            }
//        }
//        return output    USE ONCE DIAGONALS ARE ADDED
        return listOf(
            x - 1 to y,
            x + 1 to y,
            x to y + 1,
            x to y - 1,
        ).filter { isWalkable(it.first, it.second) }
    }

    fun shortestPath(
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int,
        travalled: Set<Pair<Int, Int>>,
    ): List<Pair<Int, Int>> {
        if (x1 == x2 && y1 == y2) {
            return listOf(x2 to y2)
        }

        val neighbours = getNeighbours(x1, y1).filter { !travalled.contains(it) }
        val shortestPaths = neighbours.map { shortestPath(it.first, it.second, x2, y2, travalled.plus(x1 to y1)) }
        val shortestPath = shortestPaths.minByOrNull { it.size } ?: emptyList()
        return listOf(x1 to y1) + shortestPath
    }
}
