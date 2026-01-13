package data

class GameState(
    val grid: Grid,
    val player: Entity,
    val enemy: Entity,
) {
    fun containsPlayer(
        x: Int,
        y: Int,
    ): Boolean = player.isAt(x, y)

    fun containsEnemy(
        x: Int,
        y: Int,
    ): Boolean = enemy.isAt(x, y)
}
