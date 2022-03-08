package day07

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day07Test {

    @Test
    fun testCalculateTotal() {
        val input = "16,1,2,0,4,2,7,1,2,14".split(",").map { i -> i.toInt()}

        assertEquals(37, calculateTotal(input, 2))
    }

    @Test
    fun testCalculateVariableBurnTotal() {
        val input = "16,1,2,0,4,2,7,1,2,14".split(",").map { i -> i.toInt()}

        assertEquals(206, calculateVariableBurnTotal(input, 2))
    }

    @Test
    fun testVariableBurn()  {
        assertEquals(1, cost(1))
        assertEquals(3, cost(2))
        assertEquals(6, cost(3))
        assertEquals(10, cost(4))
        assertEquals(15, cost(5))
    }


}