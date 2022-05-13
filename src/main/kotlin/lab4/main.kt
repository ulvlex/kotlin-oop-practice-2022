package lab4

fun main() {
    val fileName = "C:\\Users\\ASUS\\Desktop\\Занятия\\ООП\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\maze.txt"
    val maze = Model(fileName)
    ConsoleUI(maze)
    Controller(maze)
}