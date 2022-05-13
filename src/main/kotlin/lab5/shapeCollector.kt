package lab5

import lab2.Color
import lab2.ColoredShape2d

class ShapeCollector<T: ColoredShape2d>(_listFigure: List<T>) {
    private val listFigure: MutableList<T>

    init{
        listFigure = _listFigure.toMutableList()
    }

    fun addFigure(figure: T) {
        listFigure.add(figure)
    }

    fun minArea(): List<T> {
        return if (listFigure.isNotEmpty()){
            val minArea = listFigure.minOf {it.calcArea()}
            listFigure.filter {it.calcArea() == minArea}
        } else emptyList()
    }

    fun maxArea(): List<T> {
        return if (listFigure.isNotEmpty()){
            val maxArea = listFigure.maxOf {it.calcArea()}
            listFigure.filter {it.calcArea() == maxArea}
        } else emptyList()
    }

    fun totalArea(): Double {
        var sumArea: Double = 0.0
        for (figure in listFigure) sumArea += figure.calcArea()
        return sumArea
    }

    fun findByBorderColor(_borderColor: Color): List<T> {
        val listFigureByBorderColor: MutableList<T> = mutableListOf()
        for (figure in listFigure) {
            if (figure.borderColor == _borderColor) listFigureByBorderColor.add(figure)
        }
        return listFigureByBorderColor
    }

    fun findByFillColor(_fillColor: Color): List<T> {
        val listFigureByFillColor: MutableList<T> = mutableListOf()
        for (figure in listFigure) {
            if (figure.fillColor == _fillColor) listFigureByFillColor.add(figure)
        }
        return listFigureByFillColor
    }

    fun getListFigure(): List<T> {
        return listFigure
    }

    fun getSizeList(): Int {
        return listFigure.size
    }

    fun groupedByBorderColor(): Map<Color, List<T>> {
        return listFigure.groupBy { it.borderColor }
    }

    fun groupedByFillColor(): Map<Color, List<T>> {
        return listFigure.groupBy { it.fillColor }
    }

    fun groupedByType(): Map<Class<Any>, List<T>> =
        listFigure.groupBy { it.javaClass }

    fun getFigure(index: Int): ColoredShape2d {
        return listFigure[index]
    }

    fun addAll(newListFigure: List<T>){
        newListFigure.forEach{
            listFigure.add(it)
        }
    }

    fun getSorted(figureComparator: Comparator<T>): List<T> {
        val sortedList = listFigure
        sortedList.sortWith(figureComparator)
        return sortedList.toList()
    }
}