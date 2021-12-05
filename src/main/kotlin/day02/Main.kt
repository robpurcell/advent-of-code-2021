package day02

import java.io.File

fun main(args: Array<String>) {
    val input = processCommandsFile(readInput())
    val finalLocation = navigate(input)
    val result = finalLocation.horizontal * finalLocation.depth
    println("Part 1 Final Location: $finalLocation")
    println("Part 1 Answer: $result")
}

fun navigate(input: List<Pair<String, Int>>): Position =
    input.fold(Position(0, 0)) { p: Position, i: Pair<String, Int> -> moveShip(p, i) }

fun forward(position: Position, increment: Int): Position {
    return Position(position.horizontal + increment, position.depth)
}

fun down(position: Position, increment: Int): Position {
    return Position(position.horizontal, position.depth + increment)
}

fun up(position: Position, increment: Int): Position {
    return Position(position.horizontal, position.depth - increment)
}

data class Position(val horizontal: Int, val depth: Int)

private fun readInput(path: String = "/Users/rob/Development/source/github/advent-of-code-2021/src/test/resources/day02-input.txt"): List<String> {
    val file = File(path)
    return file.readLines()
}

fun processCommandsFile(commands: List<String>): List<Pair<String, Int>> {
    val output = emptyList<Pair<String, Int>>().toMutableList()

    for (c in commands) {
        val direction = c.split(" ").first()
        val magnitude = c.split(" ").last().toInt()
        output.add(Pair(direction, magnitude))
    }
    return output
}

fun moveShip(position: Position, command: Pair<String, Int>): Position {
    return when (command.first) {
        "forward" -> forward(position, command.second)
        "up" -> up(position, command.second)
        "down" -> down(position, command.second)
        else -> throw UnsupportedOperationException("Unknown command!")
    }
}


