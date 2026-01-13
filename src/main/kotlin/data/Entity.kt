package data

class Entity(
    var x: Int,
    var y: Int,
    var direction: Direction,
) {
    fun changePos(
        x: Int,
        y: Int,
    ) {
        this.x = x
        this.y = y
    }

    fun changeDir(dir: Direction) {
        this.direction = dir
    }

    fun isAt(
        x: Int,
        y: Int,
    ) = x == this.x && y == this.y
}
