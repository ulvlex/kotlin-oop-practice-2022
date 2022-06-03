package lab2

import kotlin.math.PI
import kotlin.math.sqrt

data class Circle(
    private val radius: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
    override fun calcArea(): Double {
        if (radius <= 0) throw IllegalArgumentException("Radius should be positive")
        return PI * radius * radius
    }

    fun getProperties(): String {
        return "Radius = $radius, borderColor = $borderColor, fillColor = $fillColor"
    }
}

data class Square(
    private val side: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
    override fun calcArea(): Double {
        if (side <= 0) throw IllegalArgumentException("Radius should be positive")
        return side * side
    }

    fun getProperties(): String {
        return "Side = $side, borderColor = $borderColor, fillColor = $fillColor"
    }
}

data class Rectangle(
    private val firstSide: Double,
    private val secondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
    override fun calcArea(): Double {
        if (firstSide <= 0 || secondSide <= 0) throw IllegalArgumentException("Sides should be positive")
        return firstSide * secondSide
    }

    fun getProperties(): String {
        return "FirstSide = $firstSide, secondSide = $secondSide, borderColor = $borderColor, fillColor = $fillColor"
    }
}

data class Triangle(
    private val firstSide: Double,
    private val secondSide: Double,
    private val thirdSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {
    private val halfMeter = firstSide + secondSide + thirdSide
    override fun calcArea(): Double {
        if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0) throw IllegalArgumentException("Sides should be positive")
        //Checking for existence
        if (firstSide + secondSide < thirdSide ||
            firstSide + thirdSide < secondSide ||
            thirdSide + secondSide < firstSide
        ) throw IllegalArgumentException("There is no such triangle")
        return sqrt(halfMeter * (halfMeter - firstSide) * (halfMeter - secondSide) * (halfMeter - thirdSide))
    }

    fun getProperties(): String {
        return "FirstSide = $firstSide, secondSide = $secondSide, thirdSide = $thirdSide, borderColor = $borderColor, fillColor = $fillColor"
    }
}

