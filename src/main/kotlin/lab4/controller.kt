package lab4

import lab4.ModelSerialization.serializationToFile

class Controller(private val model: Model) {
    init {
        newGame()
    }

    private fun newGame() {
        var saveGame = false
        while (model.state != State.WIN && !saveGame) {
            val input = readln()
            for (i in input.indices) {
                try {
                    when (input[i]) {
                        'w', 'ц' -> model.doMove(Actions.UP)
                        's', 'ы' -> model.doMove(Actions.DOWN)
                        'a', 'ф' -> model.doMove(Actions.LEFT)
                        'd', 'в' -> model.doMove(Actions.RIGHT)
                        'b', 'и' -> model.doMove(Actions.BREAK)
                        'e', 'у' -> {
                            println("File to save progress: ")
                            val fileName = readln()
                            serializationToFile(model.getModel(), fileName)
                       //     model.writeMazeToFile(fileName)
                            saveGame = true
                            break
                        }
                        else -> Actions.DO_NOTHING
                    }
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
    }
}