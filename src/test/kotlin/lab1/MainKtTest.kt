package lab1

import kotlin.test.Test
import kotlin.test.assertEquals

internal class MainKtTest {
    @Test
    fun bookParserTest1() {
        //first
        val books1 =  "1.Солярис//Станислав Лем//1961\n" +
                "2.Три сестры//Антон Чехов//1900\n" +
                "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"
        val bookList: List<Book> = parseBooks(books1)
        val expected = listOf(
            Book("Солярис", "Станислав Лем", 1961),
            Book("Три сестры", "Антон Чехов", 1900),
            Book("С++ Primer", "Стэнли Липпман, Жозе Лажуа и Барбара Э. Му", 2012)
        )
        assertEquals(expected, bookList)
    }

    @Test
    fun bookParserTest2() {
        //second
        val books2 = "1.Солярис//Станислав Лем//1961"
        val bookList2: List<Book> = parseBooks(books2)
        val expected = listOf(
            Book("Солярис", "Станислав Лем", 1961)
        )
       assertEquals(expected, bookList2)
    }

    @Test
    fun bookParserTest3() {
        //third
        val books3 = "1.Солярис//Станислав Лем//1961\n" +
                "2. \n" +
                "3.С++ Primer//Стэнли Липпман, Жозе Лажуа и Барбара Э. Му//2012"

        val bookList3: List<Book> = parseBooks(books3)
        val expected = listOf(
            Book("Солярис", "Станислав Лем", 1961),
            Book("С++ Primer", "Стэнли Липпман, Жозе Лажуа и Барбара Э. Му", 2012)
        )
        assert(bookList3.count() == 2)
        assertEquals(expected, bookList3)
    }
}