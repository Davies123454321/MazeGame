package render
import data.Grid

class ConsoleRenderer {
    fun printState(grid: Grid) {
        for (i in 0 until grid.height) {
            for (j in 0 until grid.width) {
                print("- ")
            }
            println()
        }
    }
}
