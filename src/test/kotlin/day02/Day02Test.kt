package day02

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day02Test {
    val input = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    )

    @Test
    fun testProcessCommands() {
        assertEquals(
            listOf(
                Pair("forward", 5),
                Pair("down", 5),
                Pair("forward", 8),
                Pair("up", 3),
                Pair("down", 8),
                Pair("forward", 2)
            ), processCommandsFile(input)
        )
    }

    @Test
    fun testMoveForward() {
        assertEquals(Position(5, 0), moveShip(Position(0,0), Pair("forward", 5)))
    }

    @Test
    fun testMoveDown() {
        assertEquals(Position(5, 5), moveShip(Position(5,0), Pair("down", 5)))
    }

    @Test
    fun testMoveUp() {
        assertEquals(Position(5, 0), moveShip(Position(5,5), Pair("up", 5)))
    }

    @Test
    fun testNavigate() {
        val input = listOf(
            Pair("forward", 5),
            Pair("down", 5),
            Pair("up", 5)
        )

        assertEquals(Position(5, 0), navigate(input))
    }

}

