package lab4

import lab4.ModelSerialization.deserializationFromFile

fun main() {
    val fileName = "C:\\Users\\ASUS\\Desktop\\Занятия\\ООП\\kotlin-oop-practice-2022\\src\\main\\kotlin\\lab4\\maze.txt"
    val maze = deserializationFromFile(fileName)
    ConsoleUI(maze)
    Controller(maze)
}