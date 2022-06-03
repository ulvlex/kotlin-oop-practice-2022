package lab3

import java.time.LocalDate

fun main(){
    val work = OperationsWithNotes()
    work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
    work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
    work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
    work.createLink("Kotlin", "Class Date","https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Date.html", LocalDate.of(2021, 5, 12))
    work.createTask("Homework", "Laboratory work on OOP", "2022.04.22", LocalDate.of(2022, 4 ,18))

    println("All Notes: ${work.getAllNotes()}")
    println("All TextNotes: ${work.getAllTextNotes()}")
    println("All Links: ${work.getAllLinks()}")
    println("All Tasks: ${work.getAllTasks()}")

    println("Notes sorted by title: ${work.getSortedByTitle()}")
    println("Notes sorted by date: ${work.getSortedByDate()}")

    println("Notes found by title (Thoughts): ${work.findByTitle("Thoughts")}")
    println("Notes found by type (Task): ${work.findByType("Task")}")

    work.removeNote(work[0])

    println("Note without first note: ")
    println("${work.getAllNotes()}")
}