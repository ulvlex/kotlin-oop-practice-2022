package lab2

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class ShapeCollectorTest {

    @Test
    fun addFigure() {
        val color1 = Color(255, 255, 255, 5)
        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color1, color1 )

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)

        assert(shapeCollector.getSizeList() == 2)
        assert( shapeCollector.getFigure(0).javaClass.name.substringBefore('(').substringAfter('.') == "Circle")
    }

    @Test
    fun minAreaFromList() {
        val color1 = Color(255, 255, 255, 5)
        val shape1 = Rectangle(3.0, 5.0, color1, color1)
        val shape2 = Rectangle( 2.0, 3.0, color1, color1 )

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)

        assert(shapeCollector.minAreaFromList() == 6.0)
    }

    @Test
    fun maxAreaFromList() {
        val color1 = Color(255, 255, 255, 5)
        val shape1 = Rectangle(3.0, 5.0, color1, color1)
        val shape2 = Rectangle( 2.0, 3.0, color1, color1 )

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)

        assert(shapeCollector.maxAreaFromList() == 15.0)
    }

    @Test
    fun totalArea() {
        val color1 = Color(255, 255, 255, 5)
        val shape1 = Rectangle(3.0, 5.0, color1, color1)
        val shape2 = Rectangle( 2.0, 3.0, color1, color1 )

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)

        assert(shapeCollector.totalArea() == 21.0)
    }

    @Test
    fun findByBorderColor() {
        val color1 = Color(255, 255, 255, 5)
        val color2 = Color(0, 0, 0, 40)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color2, color2 )
        val shape3 = Circle(6.0, color1, color2)

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)
        shapeCollector.addFigure(shape3)

        assert(shapeCollector.findByBorderColor(color1) == listOf(shape1, shape3))
    }

    @Test
    fun findByFillColor() {
        val color1 = Color(255, 255, 255, 5)
        val color2 = Color(0, 0, 0, 40)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color2, color2 )
        val shape3 = Circle(6.0, color1, color2)

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)
        shapeCollector.addFigure(shape3)

        assert(shapeCollector.findByFillColor(color2) == listOf(shape2, shape3))
    }

    @Test
    fun getListFigure() {
        val color1 = Color(255, 255, 255, 5)
        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color1, color1 )

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)

        assert(shapeCollector.getListFigure() == listOf(shape1, shape2))
    }

    @Test
    fun getSizeList() {
        val color1 = Color(255, 255, 255, 5)
        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color1, color1 )

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)

        assert(shapeCollector.getSizeList() == 2)
    }

    @Test
    fun groupedByBorderColor() {
        val color1 = Color(255, 255, 255, 5)
        val color2 = Color(0, 0, 0, 40)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color2, color2 )
        val shape3 = Circle(6.0, color1, color2)

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)
        shapeCollector.addFigure(shape3)

        assert(shapeCollector.groupedByBorderColor() == mapOf(color1 to listOf(shape1, shape3), color2 to listOf(shape2)))
    }

    @Test
    fun groupedByFillColor() {
        val color1 = Color(255, 255, 255, 5)
        val color2 = Color(0, 0, 0, 40)

        val shape1 = Circle(3.0, color1, color1)
        val shape2 = Triangle( 2.0, 3.0, 4.0, color2, color2 )
        val shape3 = Circle(6.0, color1, color2)

        val shapeCollector = ShapeCollector<Any>()
        shapeCollector.addFigure(shape1)
        shapeCollector.addFigure(shape2)
        shapeCollector.addFigure(shape3)

        assert(shapeCollector.groupedByFillColor() == mapOf(color1 to listOf(shape1), color2 to listOf(shape2, shape3)))
    }
}