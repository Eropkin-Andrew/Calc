enum class Calc {
    ADD{
       override fun operation(first: Long, second: Long): Long = first + second
       },
    SUB{
        override fun operation(first: Long, second: Long): Long = first - second
       },
    MULT{
        override fun operation(first: Long, second: Long): Long = first * second
        },
    DIV{
        override fun operation(first: Long, second: Long): Long {
            if (second == 0L ) throw IllegalArgumentException("Can't divide by zero")
            return first / second
        }
    };
    abstract fun operation(first: Long, second: Long): Long
}