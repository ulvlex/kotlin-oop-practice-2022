package lab3

import java.time.LocalDate

class OperationsWithNotes() : NoteService {

    private val notes: MutableList<Note> = mutableListOf()

    override fun getAllNotes(): List<Note> {
        return notes
    }

    override fun getAllTextNotes(): List<Note.TextNote> {
        val textNote: MutableList<Note.TextNote> = mutableListOf()
        for (note in notes) {
            if (note.javaClass == Note.TextNote::class.java) textNote.add(note as Note.TextNote)
        }
        return textNote
    }

    override fun getAllTasks(): List<Note.Task> {
        val tasks: MutableList<Note.Task> = mutableListOf()
        for (note in notes) {
            if (note.javaClass == Note.Task::class.java) tasks.add(note as Note.Task)
        }
        return tasks
    }

    override fun getAllLinks(): List<Note.Link> {
        val links: MutableList<Note.Link> = mutableListOf()
        for (note in notes) {
            if (note.javaClass == Note.Link::class.java) links.add(note as Note.Link)
        }
        return links
    }

    override fun createTextNote(title: String, content: String, date: LocalDate): Note.TextNote {
        val text = Note.TextNote(title, content, date)
        notes.add(text)
        return text
    }

    override fun createTask(title: String, task: String, deadline: String, date: LocalDate): Note.Task {
        val task = Note.Task(title, task, deadline, date)
        notes.add(task)
        return task
    }

    override fun createLink(title: String, content: String, url: String, date: LocalDate): Note.Link {
        val link = Note.Link(title, content, url, date)
        notes.add(link)
        return link
    }

    override fun getSortedByTitle(): List<Note> {
        if (notes.isEmpty()) throw Exception("No entries added")
        else return notes.sortedBy { it.title }
    }

    override fun getSortedByDate(): List<Note> {
        if (notes.isEmpty()) throw Exception("No entries added")
        else return notes.sortedBy { it.date }
    }

    override fun removeNote(note: Note) {
        notes.remove(note)
    }

    override fun findByType(type: String): List<Note> {
        val notesByType: MutableList<Note> = mutableListOf()
        for (note in notes) {
            if (note.javaClass.simpleName == type) notesByType.add(note)
        }
        return notesByType
    }

    override fun findByTitle(title: String): List<Note> {
        val notesByTitle: MutableList<Note> = mutableListOf()
        for (note in notes) {
            if (note.title == title) notesByTitle.add(note)
        }
        return notesByTitle
    }

    operator fun get(index: Int): Note {
        return notes[index]
    }

    fun getSize(): Int{
        return notes.size
    }
}