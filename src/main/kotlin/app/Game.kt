package app
import data.Direction
import data.GameState
import data.Grid
import logic.MovementSystem
import render.ConsoleRenderer

class Game(
    val state: GameState,
    val consoleRenderer: ConsoleRenderer,
    val mSystem: MovementSystem,
    var gameOver: Boolean = false,
) {
    fun play() {
        render()
        while (!gameOver) {
            val dir = gatherInput()
            handleEnemyMove()
            if (dir != null) {
                handlePlayerMove(dir)
            }
            render()
            checkGameOver()
        }
        println("You got caught!")
    }

    private fun gatherInput(): Direction? {
        val c = readLine()?.firstOrNull()
        return when (c?.lowercaseChar()) {
            'w' -> Direction.NORTH
            'a' -> Direction.WEST
            's' -> Direction.SOUTH
            'd' -> Direction.EAST
            else -> null
        }
    }

    private fun handlePlayerMove(direction: Direction) {
        mSystem.tryPlayerMove(state, direction)
    }

    private fun handleEnemyMove() {
        mSystem.moveEnemy(state)
    }

    private fun render() = consoleRenderer.printState(state)

    private fun checkGameOver() {
        val player = state.player
        val enemy = state.enemy
        val over = player.x == enemy.x && player.y == enemy.y
        this.gameOver = over
    }
}
