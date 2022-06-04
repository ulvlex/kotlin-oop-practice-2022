package lab4

class ConsoleUI(private val model: Model) {
    init {
        println(
            "Welcome to the maze, you are standing on the P cell, " +
                    "to win you need to get to the E cell. \nIf you want to exit the game, " +
                    "press b, if you want to save the changes, press e. " +
                    "\nTo move, press w,a,s,d. \nGood luck."
        )

        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        model.addModelChangeListener(listener)
        repaint()
    }

    private fun repaint() {
        println(model)
        if (model.state == State.WIN && !model.breakFlag) println("You WIN")
    }
}