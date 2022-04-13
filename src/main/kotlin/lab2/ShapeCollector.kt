package lab2

class ShapeCollector {
    private val listFigure: MutableList<ColoredShape2d> = mutableListOf()

    fun addFigure(figure: ColoredShape2d) {
        listFigure.add(figure)
    }

    fun minAreaFromList(): Double {
        var minArea = Double.MAX_VALUE
        for (figure in listFigure) {
            if (minArea > figure.calcArea()) minArea = figure.calcArea()
        }
        return minArea
    }

    fun maxAreaFromList(): Double {
        var maxArea: Double = 0.0
        for (figure in listFigure) {
            if (maxArea < figure.calcArea()) maxArea = figure.calcArea()
        }
        return maxArea
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

    fun shapesOfCertainType(type: String): List<ColoredShape2d> {
        val listFigureType: MutableList<ColoredShape2d> = mutableListOf()
        for (figure in listFigure) {
            if (figure.javaClass.name.substringBefore('(').substringAfter('.') == type) listFigureType.add(figure)
        }
        return listFigureType
    }

    fun getFigure(index: Int): ColoredShape2d {
        return listFigure[index]
    }
}
