package lab3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.LocalDate

internal class OperationsWithNotesTest {

    @Test
    fun getAllNotes() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.getAllNotes() == listOf(work.get(0), work.get(1), work.get(2)) && work.getSize() == 3)
    }

    @Test
    fun getAllTextNotes() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.getAllTextNotes() == listOf(work.get(0), work.get(1)))
    }

    @Test
    fun getAllTasks() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        work.createTask("Homework", "Laboratory work on OOP", "2022.04.22", LocalDate.of(2022, 4 ,18))
        assert(work.getAllTasks() == listOf(work.get(3)))
    }

    @Test
    fun getAllLinks() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        work.createTask("Homework", "Laboratory work on OOP", "2022.04.22", LocalDate.of(2022, 4 ,18))
        assert(work.getAllLinks() == listOf(work.get(2)))
    }


    @Test
    fun getSortedByTitle() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.getSortedByTitle() == listOf(work.get(1), work.get(2), work.get(0)))
    }

    @Test
    fun getSortedByDate() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.getSortedByDate() == listOf(work.get(2), work.get(1), work.get(0)))
    }

    @Test
    fun removeNote() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.getSize() == 3)
        work.removeNote("Thoughts")
        assert(work.getSize() == 2)
    }

    @Test
    fun findByType() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.findByType("Link") == listOf(work.get(2)))
    }

    @Test
    fun findByTitle() {
        val work = OperationsWithNotes()
        work.createTextNote("Thoughts", "I'm in a bad mood", LocalDate.of(2022,4,22))
        work.createTextNote("Affirmations", "You will succeed, believe in yourself" , LocalDate.of(2021,9,27))
        work.createLink("Kotlin", "Isolated classes","https://kotlinlang.ru/docs/reference/sealed-classes.html", LocalDate.of(2020, 10, 17))
        assert(work.findByTitle("Thoughts") == listOf(work.get(0)))
    }
}