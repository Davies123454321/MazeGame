package logic

import data.Direction
import data.Entity
import data.GameState
import data.Grid

class MovementSystem {
    private fun canMoveForward(
        entity: Entity,
        state: GameState,
    ): Boolean {
        val d = entity.direction
        val nx = entity.x + d.dx
        val ny = entity.y + d.dy

        return state.grid.isWalkable(nx, ny)
    }

    private fun moveForward(entity: Entity) {
        val d = entity.direction
        val nx = entity.x + d.dx
        val ny = entity.y + d.dy
        entity.changePos(nx, ny)
    }

    fun tryPlayerMove(
        state: GameState,
        direction: Direction,
    ) {
        state.player.changeDir(direction)
        if (canMoveForward(state.player, state)) {
            moveForward(state.player)
        }
    }

    fun nextEnemyMove(gameState: GameState): Pair<Int, Int> {
        val grid = gameState.grid
        val enemy = gameState.enemy
        val player = gameState.player
        val shortestPath = grid.shortestDFSPath(enemy.x, enemy.y, player.x, player.y, emptySet())
        return shortestPath.get(1)
    }

    fun moveEnemy(gameState: GameState) {
        val nextMove = nextEnemyMove(gameState)
        val enemy = gameState.enemy
        val dx = (nextMove.first) - enemy.x
        val dy = (nextMove.second) - enemy.y
        val dir = Direction.fromDelta(dx, dy)
        enemy.changeDir(dir)
        moveForward(enemy)
    }
}
