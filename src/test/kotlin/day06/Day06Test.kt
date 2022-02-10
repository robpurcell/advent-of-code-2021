package day06

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day06Test {
    @Test
    fun testProcessDay1() {
        val input = listOf<Long>(0, 1, 1, 2, 1, 0, 0, 0, 0)
        val expected = listOf<Long>(1, 1, 2, 1, 0, 0, 0, 0, 0)

        assertEquals(expected, processDay(input))
    }

    @Test
    fun testProcessDay2() {
        val input = listOf<Long>(1, 1, 2, 1, 0, 0, 0, 0, 0)
        val expected = listOf<Long>(1, 2, 1, 0, 0, 0, 1, 0, 1)

        assertEquals(expected, processDay(input))
    }

    @Test
    fun testProcessDay3() {
        val input = listOf<Long>(1, 2, 1, 0, 0, 0, 1, 0, 1)
        val expected = listOf<Long>(2, 1, 0, 0, 0, 1, 1, 1, 1)

        assertEquals(expected, processDay(input))
    }

    @Test
    fun testProcessDays1() {
        val input = listOf<Long>(0, 1, 1, 2, 1, 0, 0, 0, 0)
        val expected = listOf<Long>(1, 1, 2, 1, 0, 0, 0, 0, 0)

        assertEquals(expected, processDays(input, 1))
    }

    @Test
    fun testProcessDays2() {
        val input = listOf<Long>(0, 1, 1, 2, 1, 0, 0, 0, 0)
        val expected = listOf<Long>(1, 2, 1, 0, 0, 0, 1, 0, 1)

        assertEquals(expected, processDays(input, 2))
    }

    @Test
    fun testProcessDays3() {
        val input = listOf<Long>(0, 1, 1, 2, 1, 0, 0, 0, 0)
        val expected = listOf<Long>(2, 1, 0, 0, 0, 1, 1, 1, 1)

        assertEquals(expected, processDays(input, 3))
    }

    @Test
    fun testCollectInputs() {
        val input = listOf(1, 2, 3, 4, 1, 1, 2, 3)
        val expected = listOf<Long>(0, 3, 2, 2, 1, 0, 0, 0, 0)

        assertEquals(expected, collectInputs(input))
    }

}