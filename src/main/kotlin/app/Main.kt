package app

import data.Grid
import render.ConsoleRenderer

fun main() {
    val board = Grid(10, 10)
    val renderer = ConsoleRenderer()
    val game = Game(board, renderer)
    game.play()
}
