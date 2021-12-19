package day04

import java.io.File

fun main(args: Array<String>) {
    val inputFile = File("/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day04-input.txt")
    val numberInput = createGameNumbers(inputFile)
    val boards = createBoards(inputFile)

    val (winningBoardNumber, lastNumberCalled) = playGame(numberInput, boards)
    val answer = findScore(boards[winningBoardNumber], lastNumberCalled)
    println("Part 1 answer: $answer")
}

typealias Board = List<MutableList<Pair<Int, Boolean>>>

fun createGameNumbers(inputFile: File): List<Int> {
    return inputFile.readLines()[0].split(",").map { s -> s.toInt() }
}

fun createBoard(boardDefinition: String): Board {
    val board = mutableListOf<MutableList<Pair<Int, Boolean>>>()
    for (rowDef in boardDefinition.trim().lines()) {
        val row = mutableListOf<Pair<Int, Boolean>>()
        for (column in rowDef.trim().split("""\s+""".toRegex())) {
            row.add(Pair(column.toInt(), false))
        }
        board.add(row)
    }
    return board
}

fun createBoards(inputFile: File): MutableList<Board> {
    val boardDefs = inputFile.readText().split("\n\n")
    val boards = mutableListOf<Board>()
    for (def in boardDefs.subList(1, boardDefs.size)) {
        boards.add(createBoard(def))
    }
    return boards
}

fun playGame(numbers: List<Int>, boards: List<Board>): Pair<Int, Int> {
    numbers.forEach { n ->
        boards.withIndex().forEach { (i, b) ->
            playNumber(n, b)
            if (testBoard(b)) {
                return Pair(i, n)
            }
        }
    }
    return Pair(0, 0)
}

fun playNumber(number: Int, board: Board) {
    board.forEach { r ->
        r.withIndex().forEach { (i, c) ->
            if (c.first == number) {
                r[i] = Pair(number, true)
            }
        }
    }
}

fun testBoard(board: Board): Boolean {
    for (r in board) {
        var count = 0
        r.forEach { c ->
            if (c.second) {
                count++
            }
        }
        if (count == r.size) {
            return true
        }
    }

    for (j in 0..board.size - 1) {
        var count = 0
        for (i in board.indices) {
            if (board[i][j].second) {
                count++
            }
        }
        if (count == board.size) {
            return true
        }
    }

    return false
}

fun findScore(board: Board, lastNumberCalled: Int): Int {
    var score = 0
    board.forEach { r ->
        r.forEach { c ->
            if (!c.second) {
                score += c.first
            }
        }
    }
    return score * lastNumberCalled
}