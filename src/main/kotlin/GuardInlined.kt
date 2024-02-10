package de.maschmi.blog

class GuardInlined(private val adapter: Adapter) {

    fun functionOneUsingAdapter(): Result<String> {
        return inlinedGuard {
            adapter.methodToBeGuarded("FunctionOne")
        }

    }

    fun functionTwoUsingAdapter(): Result<String> {
        return inlinedGuard {
            adapter.methodToBeGuarded("FunctionTwo")
        }
    }

    private inline fun <T> inlinedGuard(guardedCall: () -> T): Result<T> {
        try {
            val result = guardedCall.invoke()
            return Result.success(result)
        } catch (ex: Exception) {
            return Result.failure(ex)
        }
    }

}