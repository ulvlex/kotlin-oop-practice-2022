package lab3

import java.time.LocalDate

interface NoteService {
    fun getAllNotes(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTasks(): List<Note.Task>
    fun getAllLinks(): List<Note.Link>

    fun createTextNote(title: String, content: String, date: LocalDate): Note.TextNote
    fun createTask(title: String, task: String, deadline: String, date: LocalDate): Note.Task
    fun createLink(title: String, content: String, url: String, date: LocalDate): Note.Link

    fun getSortedByTitle(): List<Note>
    fun getSortedByDate(): List<Note>

    fun removeNote(title: String)

    fun findByType(type: String): List<Note>
    fun findByTitle(title: String): List<Note>
}
