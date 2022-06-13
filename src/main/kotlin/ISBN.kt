class ISBN(val number: String) {


    companion object {
        fun is_valid(number: String): Boolean {
            var result: Boolean
            val valid_isbn_pattern =
                "^(?:ISBN(?:-1[03])?:? )?(?=[\\dX]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$".toRegex()
            result = number.matches(regex = valid_isbn_pattern)
            if (result){
                val digits = number.filter { it.isDigit() }
                if (digits.length == 13) {
                    var total = 0
                    for (i in 0 until digits.length - 1) {
                        total += if (i % 2 == 0) {
                            digits[i].digitToInt()
                        } else {
                            digits[i].digitToInt() * 3
                        }

                    }
                    val remainder = total % 10
                    result = if (remainder == 0 && digits.last().digitToInt() == 0) {
                        true
                    } else 10 - remainder == digits.last().digitToInt()
                } else if (digits.length==10){
                    var total = 0
                    for (i in 0 until 10) {
                        total += digits[i].digitToInt() * (10 - i)
                    }
                    result = total % 11 == 0
                }
            }

            return result
        }
    }
}