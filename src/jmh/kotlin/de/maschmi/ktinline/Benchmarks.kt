package de.maschmi.ktinline

import de.maschmi.blog.Adapter
import de.maschmi.blog.Guard
import de.maschmi.blog.GuardInlined
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class Benchmarks {

    private val adapterForInline = Adapter()
    private val guardInlined = GuardInlined(adapterForInline)

    private val adapterForNotInline = Adapter()
    private val guard = Guard(adapterForNotInline)

    private val adapter = Adapter()

    @Benchmark
    fun baseline(blackhole: Blackhole) {
        try {
            blackhole.consume(adapter.methodToBeGuarded("test"))
        } catch (ex: RuntimeException) {
            blackhole.consume(ex)
        }
    }

    @Benchmark
    fun inlined(blackhole: Blackhole) {
        val result = guardInlined.functionTwoUsingAdapter()
        blackhole.consume(result)
    }

    @Benchmark
    fun notInlined(blackhole: Blackhole) {
        val result = guard.functionTwoUsingAdapter()
        blackhole.consume(result)
    }
}
