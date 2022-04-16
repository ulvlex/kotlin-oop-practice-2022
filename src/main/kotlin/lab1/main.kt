package lab1

fun main() {
    val stringBook: String = "1.Собачье сердце//Михаил Булгаков//1925\n" +
            "2.Дети капитана Гранта//Жюль Верн//1868\n" +
            "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"
    val list: List<Book> = parseBooks(stringBook)


    println("The newest book of ${newestBook(list)}")
    println("The oldest book of ${oldestBook(list)}")
    println("The shortest title of the book \"${shortestTitle(list)}\"")
    println("The longest title of the book \"${longestTitle(list)}\"")
}