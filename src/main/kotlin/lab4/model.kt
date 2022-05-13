package lab4

import kotlinx.serialization.Serializable

interface ModelChangeListener {
    fun onModelChanged()
}

enum class Actions {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    DO_NOTHING,
    BREAK
}

enum class State {
    WIN,
    WAIT_MOVE
}

@Serializable
enum class Cell(private val textMaze: String) {
    WALL("#"),
    EMPTY("_"),
    PLAYER("P"),
    FINISH("E");

    override fun toString(): String = textMaze
}

@Serializable
class Model(private val mazeMap: MutableList<MutableList<Cell>>) {
    var state: State
    var breakFlag = false
    private var x: Int
    private var y: Int

    init {
        state = State.WAIT_MOVE
        //outside the maze
        x = -1
        y = -1

        println(
            "Welcome to the maze, you are standing on the P cell, " +
                    "to win you need to get to the E cell. \nIf you want to exit the game, " +
                    "press b, if you want to save the changes, press e. " +
                    "\nTo move, press w,a,s,d. \nGood luck."
        )

        for (indexF in 0 until mazeMap.size) {
            for (indexS in 0 until mazeMap[0].size) {
                if (mazeMap[indexF][indexS] == Cell.PLAYER) {
                    x = indexS
                    y = indexF
                    if (mazeMap[indexF][indexS] == Cell.FINISH)
                        state = State.WIN
                }
            }
        }

        if (x == -1 || y == -1) throw IllegalArgumentException("There is no player in the maze")
    }

    //Listener
    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()
    fun addModelChangeListener(listener: ModelChangeListener) = listeners.add(listener)
    private fun notifyListeners() = listeners.forEach { it.onModelChanged() }
    fun removeModelChangeListener(listener: ModelChangeListener) = listeners.remove(listener)

    //Work
    constructor(fileName: String) : this(ModelSerialization.deserializationFromFile(fileName))

    fun writeMazeToFile(fileName: String) = ModelSerialization.serializationToFile(mazeMap, fileName)

    fun doMove(currMove: Actions) {
        require(state == State.WAIT_MOVE) { "Game was finished" }
        when (currMove) {
            Actions.UP -> moveFlag(--y, x)
            Actions.DOWN -> moveFlag(++y, x)
            Actions.LEFT -> moveFlag(y, --x)
            Actions.RIGHT -> moveFlag(y, ++x)
            Actions.DO_NOTHING -> moveFlag(y, x)
            Actions.BREAK -> {
                breakFlag = true
                state = State.WIN
                println("You stopped the game")
            }
        }
        notifyListeners()
    }

    private fun moveFlag(indexF: Int, indexS: Int) {
        if (indexF >= 0 && indexS >= 0 &&
            indexF < mazeMap.size && indexS < mazeMap[0].size &&
            (mazeMap[indexF][indexS] == Cell.EMPTY || mazeMap[indexF][indexS] == Cell.FINISH)
        ) {

            if (mazeMap[indexF][indexS] == Cell.FINISH) state = State.WIN
            mazeMap[y][x] = Cell.EMPTY
            mazeMap[indexF][indexS] = Cell.PLAYER
            y = indexF
            x = indexS

        } else
            throw IllegalArgumentException("Wrong move")
    }

    override fun toString(): String { //output maze
        return buildString {
            mazeMap.forEach { line ->
                line.forEach {
                    append(it)
                }
                appendLine()
            }
        }
    }
}