package data

class Grid(
    val width: Int,
    val height: Int,
) {
    val tiles: Array<Tile> =
        Array(width * height) { index ->
            val x = index % width
            val y = index / width
            Tile(x, y)
        }

    fun isWalkable(
        x: Int,
        y: Int,
    ): Boolean {
        if (x in 0..width && y in 0..height) {
            val index = (y * width) + x
            return tiles[index].passable
        } else {
            return false
        }
    }
}
