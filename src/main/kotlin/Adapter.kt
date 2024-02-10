package de.maschmi.blog

import kotlin.random.Random

class Adapter {

    private val rnd = Random(1)

    fun methodToBeGuarded(arg: String): String {
       return if (rnd.nextBoolean()) {
           throw RuntimeException("Error")
       } else {
           arg
       }
    }
}