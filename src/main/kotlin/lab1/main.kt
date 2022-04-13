package lab1

fun parseBooks(books: String) : List<Book> {
    var cnt = 2
    var workBooks : String = books
    var name : String
    var authors : String
    var pubDate : String
    val bookList: MutableList<Book> = mutableListOf()

    workBooks = workBooks.drop(2) //removing the space
    while (workBooks.isNotBlank()){

        //name
        name = workBooks.substringBefore('/')
        cnt += name.count() + 2
        workBooks = workBooks.drop(name.count() + 2)

        //author
        authors = workBooks.substringBefore('/')
        cnt += authors.count() + 2
        workBooks = workBooks.drop(authors.count() + 2)

        //publication date
        pubDate = workBooks.substringBefore('\n')
        cnt += pubDate.count() + 3
        workBooks = workBooks.drop(pubDate.count() + 3)
        val newBook = Book(name, authors, pubDate)

        bookList.add(newBook)
    }
    return bookList
}

fun oldestBook(list: List<Book>){
    var minDate : Int  = Int.MAX_VALUE
    var curName = ""

    for (i in list) {
        if (minDate > i.pubDate.toInt()) {
            minDate = i.pubDate.toInt()
            curName = i.name
        }
    }
    println("The newest book is \"$curName\" of $minDate")
}

fun newestBook(list: List<Book>){
    var maxDate = 0
    var curName = ""

    for (i in list) {
        if (maxDate < i.pubDate.toInt()) {
            maxDate = i.pubDate.toInt()
            curName = i.name
        }
    }
    println("The oldest book is \"$curName\" of $maxDate")
}

fun longestTitle(list: List<Book>){
    var maxLen = 0
    var curName = ""

    for (i in list) {
        if (maxLen < i.name.count()) {
            maxLen = i.name.count()
            curName = i.name
        }
    }
    println("The longest title of the book \"$curName\"")
}

fun shortestTitle(list: List<Book>){
    var minLen : Int = Int.MAX_VALUE
    var curName = ""

    for (i in list) {
        if (minLen > i.name.count()) {
            minLen = i.name.count()
            curName = i.name
        }
    }
    println("The shortest title of the book \"$curName\"")
}

fun main(){
    val stringBook: String = "1.Собачье сердце//Михаил Булгаков//1925\n" +
            "2.Дети капитана Гранта//Жюль Верн//1868\n" +
            "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"
    val list: List<Book> = parseBooks(stringBook)

    newestBook(list)
    oldestBook(list)
    shortestTitle(list)
    longestTitle(list)

}