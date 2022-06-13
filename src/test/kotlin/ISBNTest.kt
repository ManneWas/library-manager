import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ISBNTest {

    @ParameterizedTest(name = "Correctly validates {0}")
    @ValueSource(
        strings = ["ISBN 978-0-596-52068-7", "ISBN-13: 978-0-596-52068-7", "978 0 596 52068 7", "9780596520687", "ISBN-10 0-596-52068-9", "0-596-52068-9"]
    )
    fun valid_isbn(isbn: String) {
        assert(ISBN.is_valid(isbn))
    }


    @ParameterizedTest(name = "Correctly invalidates {0}")
    @ValueSource(
        strings = ["ISBN 978-0-596-52068-", "ISBN-13: 978-0-596-068-7", "9123417", "hello jon", "ISBN-10 1596-52068-9", "0-596-5268-9", "0-596-52068-5"]
    )
    fun invalid_isbn(isbn: String) {
        assert(!ISBN.is_valid(isbn))
    }
}