package lab4

class ConsoleUI(private val model: Model) {
    init {
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