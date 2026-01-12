package app
import data.Grid
import render.ConsoleRenderer

class Game(
    val board: Grid,
    val consoleRenderer: ConsoleRenderer,
) {
    fun play() {
        consoleRenderer.printState(board)
    }
}
