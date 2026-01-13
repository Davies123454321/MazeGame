package app

import data.Direction
import data.Entity
import data.GameState
import data.Grid
import logic.MovementSystem
import render.ConsoleRenderer

fun main() {
    val board = Grid(4, 4)
    val player = Entity(0, 0, Direction.EAST)
    val enemy = Entity(board.width - 1, board.height - 1, Direction.EAST)
    val initalState = GameState(board, player, enemy)
    val renderer = ConsoleRenderer()
    val movementSystem = MovementSystem()
    val game = Game(initalState, renderer, movementSystem)
    game.play()
}
