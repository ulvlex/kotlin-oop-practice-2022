package lab1

fun oldestBook(list: List<Book>): Int {
    var minDate: Int = Int.MAX_VALUE
    var curName = ""

    for (i in list) {
        if (minDate > i.pubDate) {
            minDate = i.pubDate
            curName = i.name
        }
    }
    return minDate
}

fun newestBook(list: List<Book>): Int {
    var maxDate = 0
    var curName = ""

    for (i in list) {
        if (maxDate < i.pubDate) {
            maxDate = i.pubDate
            curName = i.name
        }
    }
    return maxDate
}

fun longestTitle(list: List<Book>): String {
    var maxLen = 0
    var curName = ""

    for (i in list) {
        if (maxLen < i.name.count()) {
            maxLen = i.name.count()
            curName = i.name
        }
    }
    return curName
}

fun shortestTitle(list: List<Book>): String {
    var minLen: Int = Int.MAX_VALUE
    var curName = ""

    for (i in list) {
        if (minLen > i.name.count()) {
            minLen = i.name.count()
            curName = i.name
        }
    }
    return curName
}