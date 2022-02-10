package day06

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day06Test {
    @Test
    fun testProcessDecrease() {
        val input = listOf(3, 4, 3, 1, 2)
        val expected = listOf(2, 3, 2, 0, 1)
        assertEquals(expected, processDecrease(input))
    }

    @Test
    fun testCountZeroes() {
        val input = listOf(2, 0, 2, 0, 1)
        assertEquals(2, countZeroes(input))
    }

    @Test
    fun testResetZeroes() {
        val input = listOf(2, 0, 2, 0, 1)
        val expected = listOf(2, 7, 2, 7, 1)
        assertEquals(expected, resetZeroes(input))
    }

    @Test
    fun testAddFish() {
        val input = listOf(2, 0, 2, 0, 1)
        val expected = listOf(2, 0, 2, 0, 1, 8, 8, 8)
        assertEquals(expected, addFish(input, 3))
    }

    @Test
    fun testProcessState() {
        val initialState = listOf(3, 4, 3, 1, 2)
        val day1State = listOf(2, 3, 2, 0, 1)
        val day2State = listOf(1, 2, 1, 6, 0, 8)
        assertEquals(day1State, processState(initialState))
        assertEquals(day2State, processState(day1State))
    }

    @Test
    fun processDays() {
        val initialState = listOf(3, 4, 3, 1, 2)
        assertEquals(26, day06.processDays(initialState, 18))
        assertEquals(5934, day06.processDays(initialState, 80))
        day06.processDays(initialState, 256)
//        assertEquals(26984457539, day06.processDays(initialState, 256))
    }

    @Test
    fun printMaxInt() {
        println(Int.MAX_VALUE)
    }

}