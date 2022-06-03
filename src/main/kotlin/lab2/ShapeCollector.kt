package lab2

class ShapeCollector {
    private val listFigure: MutableList<ColoredShape2d> = mutableListOf()

    fun addFigure(figure: ColoredShape2d) {
        listFigure.add(figure)
    }

    fun minAreaFromList(): ColoredShape2d {
        var minArea = Double.MAX_VALUE
        var num = 0
        for ((index,figure) in listFigure.withIndex()) {
            if (minArea < figure.calcArea()) {
                minArea = figure.calcArea()
                num = index
            }
        }
        return listFigure[num]
    }

    fun maxAreaFromList(): ColoredShape2d {
        var maxArea: Double = 0.0
        var num = 0
        for ((index,figure) in listFigure.withIndex()) {
            if (maxArea < figure.calcArea()) {
                maxArea = figure.calcArea()
                num = index
            }
        }

        return listFigure[num]
    }

    fun totalArea(): Double {
        var sumArea: Double = 0.0
        for (figure in listFigure) sumArea += figure.calcArea()
        return sumArea
    }

    fun findByBorderColor(_borderColor: Color): List<ColoredShape2d> {
        val listFigureByBorderColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.borderColor == _borderColor) listFigureByBorderColor.add(figure)
        }
        return listFigureByBorderColor
    }

    fun findByFillColor(_fillColor: Color): List<ColoredShape2d> {
        val listFigureByFillColor: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.fillColor == _fillColor) listFigureByFillColor.add(figure)
        }
        return listFigureByFillColor
    }

    fun getListFigure(): List<ColoredShape2d> {
        return listFigure
    }

    fun getSizeList(): Int {
        return listFigure.size
    }

    fun groupedByBorderColor(): Map<Color, List<ColoredShape2d>> {
        return listFigure.groupBy { it.borderColor }
    }

    fun groupedByFillColor(): Map<Color, List<ColoredShape2d>> {
        return listFigure.groupBy { it.fillColor }
    }

    fun shapesOfCertainType(shapeClass: Class<out ColoredShape2d>): List<ColoredShape2d> {
        return listFigure.filterIsInstance(shapeClass)
    }

    fun getFigure(index: Int): ColoredShape2d {
        return listFigure[index]
    }
}
