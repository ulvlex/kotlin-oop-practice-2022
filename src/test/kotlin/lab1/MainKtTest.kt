package lab1

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class MainKtTest {
    @Test
    fun bookParserTest1() {
        //first
        val books1 = "1.Солярис//Станислав Лем//1961\n" +
                "2.Три сестры//Антон Чехов//1900\n" +
                "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"
        val bookList: List<Book> = parseBooks(books1)
        assert(bookList[0].name == "Солярис" && bookList[0].authors == "Станислав Лем" && bookList[0].pubDate == 1961)
        assert(bookList[1].name == "Три сестры" && bookList[1].authors == "Антон Чехов" && bookList[1].pubDate == 1900)
        assert(bookList[2].name == "С++ Primer" && bookList[2].authors == "Стэнли Липпман, Жозе Лажуа и Барбара Э. Му" && bookList[2].pubDate == 2012)
    }

    @Test
    fun bookParserTest2() {
        //second
        val books2 = "1.Солярис//Станислав Лем//1961"
        val bookList2: List<Book> = parseBooks(books2)
        assert(bookList2[0].name == "Солярис" && bookList2[0].authors == "Станислав Лем" && bookList2[0].pubDate == 1961)
    }

    @Test
    fun bookParserTest3() {
        //third
        val books3 = "1.Солярис//Станислав Лем//1961\n" +
                "2. \n" +
                "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"

        val bookList3: List<Book> = parseBooks(books3)
        assert(bookList3.count() == 2)
        assert(bookList3[0].name == "Солярис" && bookList3[0].authors == "Станислав Лем" && bookList3[0].pubDate == 1961)
        assert(bookList3[1].name == "С++ Primer" && bookList3[1].authors == "Стэнли Липпман, Жозе Лажуа и Барбара Э. Му" && bookList3[1].pubDate == 2012)
    }
}