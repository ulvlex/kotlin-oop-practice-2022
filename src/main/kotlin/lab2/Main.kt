package lab2

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
    val shapeCollector = ShapeCollector()
    shapeCollector.addFigure(circle1)
    shapeCollector.addFigure(triangle1)
    shapeCollector.addFigure(rectangle)
    shapeCollector.addFigure(square)
    shapeCollector.addFigure(circle2)

    //Methods of working with the class
    println("ShapeCollection = ${shapeCollector.getListFigure()}") //List output
    println("Min area = ${shapeCollector.minAreaFromList()}")
    println("Max area = ${shapeCollector.maxAreaFromList()}")
    println("Total area = ${shapeCollector.totalArea()}")
    println("Number of figures = ${shapeCollector.getSizeList()}")
    println("The desired shapes by border color = ${shapeCollector.findByBorderColor(firstColor)}")
    println("Desired shapes by fill color = ${shapeCollector.findByFillColor(secondColor)}")
    println("Shapes grouped by border color = ${shapeCollector.groupedByBorderColor()}")
    println("Shapes grouped by fill color = ${shapeCollector.groupedByFillColor()}")
    println("Shapes of a certain type = ${shapeCollector.shapesOfCertainType("Circle")}")
}