package data

class Entity(
    var x: Int,
    var y: Int,
    val direction: Direction,
) {
    fun changePos(
        x: Int,
        y: Int,
    ) {
        this.x = x
        this.y = y
    }
}
