package lab1

fun parseBooks(books: String): List<Book> {
    var cnt = 2
    var workBooks: String = books
    var name: String
    var authors: String
    var pubDate: Int
    val bookList: MutableList<Book> = mutableListOf()

    workBooks = workBooks.drop(2) //removing the space
    while (workBooks.isNotBlank()) {
        if (workBooks.substringBefore('\n').substringAfter('.').isBlank()) {
            cnt += workBooks.substringBefore('\n').substringAfter('.').count() + 3
            workBooks = workBooks.drop(workBooks.substringBefore('\n').substringAfter('.').count() + 3)
        } else {
            //name
            name = workBooks.substringBefore('/')
            cnt += name.count() + 2
            workBooks = workBooks.drop(name.count() + 2)

            //author
            authors = workBooks.substringBefore('/')
            cnt += authors.count() + 2
            workBooks = workBooks.drop(authors.count() + 2)

            //publication date
            pubDate = workBooks.substringBefore('\n').toInt()
            cnt += pubDate.toString().count() + 3
            workBooks = workBooks.drop(pubDate.toString().count() + 3)
            val newBook = Book(name, authors, pubDate)

            bookList.add(newBook)
        }
    }
    return bookList
}