package de.maschmi.blog

fun main() {
    inlined()
    notInlined()
}

private fun inlined() {
    val adapterForInline = Adapter()
    val guardInlined = GuardInlined(adapterForInline)
    println("Inlined")
    guardInlined.functionOneUsingAdapter()
        .onSuccess { println("Success $it") }
        .onFailure { println("Error ${it.message}") }
    guardInlined.functionTwoUsingAdapter()
        .onSuccess { println("Success $it") }
        .onFailure { println("Error ${it.message}") }

}

private fun notInlined() {
    val adapterForInline = Adapter()
    val guard = Guard(adapterForInline)
    println("Not Inlined")
    guard.functionOneUsingAdapter()
        .onSuccess { println("Success $it") }
        .onFailure { println("Error ${it.message}") }
    guard.functionTwoUsingAdapter().onSuccess { println("Success $it") }
        .onFailure { println("Error ${it.message}") }

}
