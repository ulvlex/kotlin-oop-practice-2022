package lab5

import lab2.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class GenericsShapeCollectorTest {

    private val firstColor = Color(255, 255, 255, 60)
    private val secondColor = Color(0, 0, 0, 40)

    private val circle1 = Circle(6.0, firstColor, secondColor)
    private val triangle1 = Triangle(8.0, 4.0, 7.0, secondColor, firstColor)
    private val rectangle = Rectangle(2.3, 4.5, firstColor, firstColor)
    private val square = Square(6.0, secondColor, secondColor)
    private val circle2 = Circle(12.0, secondColor, secondColor)

    @Test
    fun addAll() {
        val collection = ShapeCollector(listOf())
        val tCollection = ShapeCollector(listOf(circle1, triangle1, rectangle, square))
        collection.addAll(tCollection.getListFigure())
        assertEquals(tCollection.getListFigure(),collection.getListFigure(),)
    }

    @Test
    fun getSorted() {
        val collection = ShapeCollector(listOf(circle1, triangle1, rectangle, square))
        collection.getSorted(AreaComparator())
        val sortedList = listOf(rectangle, square, circle1, triangle1)
        assertEquals(sortedList, collection.getListFigure())
    }
}