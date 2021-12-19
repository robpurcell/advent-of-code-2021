package day04

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class Day04Test {

    @Test
    fun testCreateBoard() {
        val boardDef = """
            |22 13 17 11  0
            |8  2 23  4 24
            |21  9 14 16  7
            |6 10  3 18  5
            |1 12 20 15 19
        """.trimMargin()

        val board = createBoard(boardDef)

        assertEquals(board[0][0].first, 22)
        assertEquals(board[4][4].first, 19)
    }

    @Test
    fun testProcessFile() {
        val inputFile = File("/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day04-sample.txt")
        val numberInput = createGameNumbers(inputFile)
        assertEquals(numberInput[0].toInt(), 7)

        val boards = createBoards(inputFile)
        assertEquals(3, boards.size)
    }

    @Test
    fun testPlayNumber() {
        val boardDef = """
            |22 13 17 11  0
            |8  2 23  4 24
            |21  9 14 16  7
            |6 10  3 18  5
            |1 12 20 15 19
        """.trimMargin()

        val board = createBoard(boardDef)

        playNumber(13, board)
        println(board)
    }
    @Test
    fun testWin() {
        val boardDef = "13"
        val board = createBoard(boardDef)
        playNumber(13, board)
        assertTrue(testBoard(board))
    }

    @Test
    fun testCheckColumns() {
        val boardDef = """
            |22 13 17 11  0
            |8  2 23  4 24
            |21  9 14 16  7
            |6 10  3 18  5
            |1 12 20 15 19
        """.trimMargin()

        val board = createBoard(boardDef)
        playGame(listOf(22, 8, 21, 6, 1), listOf(board))

        assertTrue(testBoard(board))
    }

    @Test
    fun testCheckRows() {
        val boardDef = """
            |22 13 17 11  0
            |8  2 23  4 24
            |21  9 14 16  7
            |6 10  3 18  5
            |1 12 20 15 19
        """.trimMargin()

        val board = createBoard(boardDef)
        playGame(listOf(22, 13, 17, 11, 0), listOf(board))

        assertTrue(testBoard(board))
    }

    @Test
    fun testPlaySample() {
        val inputFile = File("/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day04-sample.txt")
        val numberInput = createGameNumbers(inputFile)
        val boards = createBoards(inputFile)

        assertEquals(Pair(2, 24), playGame(numberInput, boards))
        assertEquals(4512, findScore(boards[2], 24))
    }

}