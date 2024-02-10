package de.maschmi.blog

class Guard(private val adapter: Adapter) {

    fun functionOneUsingAdapter(): Result<String> {
        return guard {
            adapter.methodToBeGuarded("FunctionOne")
        }
    }

    fun functionTwoUsingAdapter(): Result<String> {
        return guard {
            adapter.methodToBeGuarded("FunctionTwo")
        }
    }

    private fun <T> guard(guardedCall: () -> T): Result<T> {
        try {
            val result = guardedCall.invoke()
            return Result.success(result)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

}