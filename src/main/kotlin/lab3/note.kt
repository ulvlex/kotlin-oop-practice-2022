package lab3

import java.time.LocalDate

sealed class Note(var title: String, var date: LocalDate) {

    class TextNote(
        title: String,
        val content: String,
        date: LocalDate
    ) : Note(title, date) {
        override fun toString(): String {
            return "TextNote:\n" +
                    "$title\n" +
                    "$content\n" +
                    "$date\n"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TextNote
            if (title != other.title) return false
            if (content != other.content) return false
            if (date != other.date) return false
            return true
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }

    class Task(
        title: String,
        val task: String,
        val deadline: String,
        date: LocalDate
    ) : Note(title, date) {
        override fun toString(): String {
            return "Task:\n" +
                    "$title\n" +
                    "$task ($deadline)\n" +
                    "$date\n"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Task
            if (title != other.title) return false
            if (task != other.task) return false
            if (date != other.date) return false
            if (deadline != other.deadline) return false
            return true
        }

        override fun hashCode(): Int {
            var result = task.hashCode()
            result = 31 * result + deadline.hashCode()
            return result
        }
    }

    class Link(
        title: String,
        val content: String,
        val url: String,
        date: LocalDate
    ) : Note(title, date) {
        override fun toString(): String {
            return "Link:\n" +
                    "$title\n" +
                    "$content ($url)\n" +
                    "$date\n"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Task
            if (title != other.title) return false
            if (date != other.date) return false
            return true
        }

        override fun hashCode(): Int {
            return url.hashCode()
        }
    }
}