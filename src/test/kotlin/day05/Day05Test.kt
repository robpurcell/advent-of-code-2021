package day05

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day05Test {
    @Test
    fun testProcessLine() {
        val input = "0,9 -> 5,9"
        val expected = Line(Pair(0, 9), Pair(5, 9))
        assertEquals(expected, processLine(input))
    }
}