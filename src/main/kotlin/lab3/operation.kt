package lab3

import java.time.LocalDate

class OperationsWithNotes() : NoteService {

    private val notes: MutableList<Note> = mutableListOf()

    override fun getAllNotes(): List<Note> {
        if (notes.isEmpty()) throw Exception("No entries added")
        else return notes
    }

    override fun getAllTextNotes(): List<Note.TextNote> {
        if (notes.isEmpty()) throw Exception("No entries added")
        else {
            val textNote: MutableList<Note.TextNote> = mutableListOf()
            for (note in notes) {
                if (note.javaClass.simpleName == "TextNote") textNote.add(note as Note.TextNote)
            }
            return textNote
        }
    }

    override fun getAllTasks(): List<Note.Task> {
        if (notes.isEmpty()) throw Exception("No entries added")
        else {
            val tasks: MutableList<Note.Task> = mutableListOf()
            for (note in notes) {
                if (note.javaClass.simpleName == "Task") tasks.add(note as Note.Task)
            }
            return tasks
        }

    }

    override fun getAllLinks(): List<Note.Link> {
        if (notes.isEmpty()) throw Exception("No entries added")
        else {
            val links: MutableList<Note.Link> = mutableListOf()
            for (note in notes) {
                if (note.javaClass.simpleName == "Link") links.add(note as Note.Link)
            }
            return links
        }

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
        require(notes.isNotEmpty()) { "There are no Notes" }
        if (notes.isEmpty()) throw Exception("No entries added")
        else return notes.sortedBy { it.date }
    }

    override fun removeNote(title: String) {
        notes.removeIf { it.title == title }
    }

    override fun findByType(type: String): List<Note> {
        if (notes.isEmpty()) throw Exception("No entries added 1")
        else {
            val notesByType: MutableList<Note> = mutableListOf()
            for (note in notes) {
                if (note.javaClass.simpleName == type) notesByType.add(note)
            }
            return notesByType
        }
    }

    override fun findByTitle(title: String): List<Note> {
        if (notes.isEmpty()) throw Exception("No entries added 2")
        else {
            val notesByTitle: MutableList<Note> = mutableListOf()
            for (note in notes) {
                if (note.title == title) notesByTitle.add(note)
            }
            return notesByTitle
        }
    }

    fun get(index: Int): Note {
        return notes[index]
    }

    fun getSize(): Int{
        return notes.size
    }
}