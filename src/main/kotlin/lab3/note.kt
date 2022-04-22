package lab3

import java.time.LocalDate

sealed class Note(var title: String, var date: LocalDate) {

    class TextNote(
        title: String,
        private val content: String,
        date: LocalDate
    ) : Note(title, date) {
        override fun toString(): String {
            return "TextNote:\n" +
                    "$title\n" +
                    "$content\n" +
                    "$date\n"
        }
    }

    class Task(
        title: String,
        private val task: String,
        private val deadline: String,
        date: LocalDate
    ) : Note(title, date) {
        override fun toString(): String {
            return "Task:\n" +
                    "$title\n" +
                    "$task ($deadline)\n" +
                    "$date\n"
        }
    }

    class Link(
        title: String,
        private val content: String,
        private val url: String,
        date: LocalDate
    ) : Note(title, date) {
        override fun toString(): String {
            return "Link:\n" +
                    "$title\n" +
                    "$content ($url)\n" +
                    "$date\n"
        }
    }
}