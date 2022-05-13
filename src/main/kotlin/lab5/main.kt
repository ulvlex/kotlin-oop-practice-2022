package lab5

import lab2.*


fun main() {
    //Color
    val firstColor = Color(255, 255, 255, 60)
    val secondColor = Color(0, 0, 0, 40)

    //Creating shapes
    val circle1 = Circle(6.0, firstColor, secondColor)
    val triangle1 = Triangle(8.0, 4.0, 7.0, secondColor, firstColor)
    val rectangle = Rectangle(2.3, 4.5, firstColor, firstColor)
    val square = Square(6.0, secondColor, secondColor)
    val circle2 = Circle(12.0, secondColor, secondColor)

    //Output of all areas
    println("Squares of figures:")
    println(circle1.calcArea())
    println(triangle1.calcArea())
    println(rectangle.calcArea())
    println(square.calcArea())
    println(circle2.calcArea())

    //Creating a list of shapes
    val shapeCollector = ShapeCollector(listOf(circle1, triangle1, rectangle, square))
    println("ShapeCollection: ${shapeCollector.getListFigure()}")
    println("Size of shapeCollection: ${shapeCollector.getSizeList()}\n")

    println("Adding second circle")
    shapeCollector.addFigure(circle2)
    println("ShapeCollection: ${shapeCollector.getListFigure()}")
    println("Size of shapeCollection: ${shapeCollector.getSizeList()}\n")

    println("Total area: ${shapeCollector.totalArea()}\n")
    println("Min areas: ${shapeCollector.minArea()}\n")
    println("Max areas: ${shapeCollector.maxArea()}\n")

    println("Shapes grouped by border color = ${shapeCollector.groupedByBorderColor()}")
    println("Shapes grouped by fill color = ${shapeCollector.groupedByFillColor()}")

    println("Group by type: ${shapeCollector.groupedByType()}\n")

    println("Sorted by area: ${shapeCollector.getSorted(AreaComparator())}")
}