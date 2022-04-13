package lab2

data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val transparency: Int
) {
    init {
        if (red < 0 || red > 255) error("incorrect red value")
        if (green < 0 || green > 255) error("incorrect green value")
        if (blue < 0 || blue > 255) error("incorrect blue value")
        if (transparency < 0 || transparency > 100) error("incorrect transparency value")
    }
}
