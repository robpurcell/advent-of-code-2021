package day03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class Day03Test {

    @Test
    fun testProcessLineAtIndex() {
        val input = "00110011"

        assertFalse(processLineAtIndex(input, 0))
        assertFalse(processLineAtIndex(input, 1))
        assertTrue(processLineAtIndex(input, 2))
        assertTrue(processLineAtIndex(input, 3))
        assertFalse(processLineAtIndex(input, 4))
        assertFalse(processLineAtIndex(input, 5))
        assertTrue(processLineAtIndex(input, 6))
        assertTrue(processLineAtIndex(input, 7))
    }

    @Test
    fun testProcessLine() {
        val zeroResult = processLine("00110011", 0, Pair(0, 0))
        assertEquals(Pair(1, 0), zeroResult)
        val oneResult = processLine("00110011", 2, Pair(0, 0))
        assertEquals(Pair(0, 1), oneResult)
    }

    @Test
    fun testProcessGivenIndex() {
        val input = listOf("00110011", "11000011")

        assertEquals(Pair(1, 1), processGivenIndex(input, 0))
        assertEquals(Pair(1, 1), processGivenIndex(input, 1))
        assertEquals(Pair(1, 1), processGivenIndex(input, 2))
        assertEquals(Pair(1, 1), processGivenIndex(input, 3))
        assertEquals(Pair(2, 0), processGivenIndex(input, 4))
        assertEquals(Pair(2, 0), processGivenIndex(input, 5))
        assertEquals(Pair(0, 2), processGivenIndex(input, 6))
        assertEquals(Pair(0, 2), processGivenIndex(input, 7))
    }
}