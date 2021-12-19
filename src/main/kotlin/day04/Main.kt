package day04

import java.io.File

fun main(args: Array<String>) {
    val inputFile = File("/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day04-input.txt")
    val numberInput = createGameNumbers(inputFile)
    val boards = createBoards(inputFile)

    val completionSequence = playGame(numberInput, boards)
    val firstScore = completionSequence.first().third
    println("Part 1 answer: $firstScore")
    val lastScore = completionSequence.last().third
    println("Part 2 answer: $lastScore")
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

fun playGame(numbers: List<Int>, boards: List<Board>): List<Triple<Int, Int, Int>> {
    val completionSequence = mutableListOf<Triple<Int, Int, Int>>()
    numbers.forEach { n ->
        boards.withIndex().forEach { (i, b) ->
            playNumber(n, b)
            if (testBoard(b)) {
                if (!indexesInCompletionSequence(completionSequence).contains(i)) {
                    completionSequence.add(Triple(i, n, findScore(b, n)))
                }
            }
        }
    }
    return completionSequence
}

fun indexesInCompletionSequence(seq: List<Triple<Int, Int, Int>>): List<Int> {
    return seq.map{ t -> t.first}
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