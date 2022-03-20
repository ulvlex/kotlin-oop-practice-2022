package lab1

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class MainKtTest
{
    @Test
    fun bookParserTest(){
        val books = "1.Солярис//Станислав Лем//1961\n" +
                "2.Три сестры//Антон Чехов//1900\n" +
                "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"

        val bookList:List<Book> = parseBooks(books)

        assertEquals(bookList[0]._name, "Солярис")
        assertEquals(bookList[0]._authors, "Станислав Лем")
        assertEquals(bookList[0]._pubDate, "1961")
        assertEquals(bookList[1]._name, "Три сестры")
        assertEquals(bookList[1]._authors, "Антон Чехов")
        assertEquals(bookList[1]._pubDate, "1900")
        assertEquals(bookList[2]._name, "С++ Primer")
        assertEquals(bookList[2]._authors, "Стэнли Липпман, Жозе Лажуа и Барбара Э. Му")
        assertEquals(bookList[2]._pubDate, "2012")
    }
}