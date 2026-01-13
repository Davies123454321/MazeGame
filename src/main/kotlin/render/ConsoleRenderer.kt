package render
import data.GameState
import data.TileType

class ConsoleRenderer(
    private val emptyChar: Char = '-',
    private val wallChar: Char = '#',
    private val entityChar: Char = 'X',
) {
    fun printState(state: GameState) {
        for (y in 0 until state.grid.height) {
            for (x in 0 until state.grid.width) {
                when {
                    state.containsPlayer(x, y) -> print("X ")
                    state.containsEnemy(x, y) -> print("O ")
                    state.grid.tileAt(x, y).type == TileType.WALL -> print("# ")
                    else -> print("- ")
                }
            }
            println()
        }
    }
}
