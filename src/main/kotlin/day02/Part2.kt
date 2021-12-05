package day02

fun main(args: Array<String>) {
    val input = processCommandsFile(readInput())
    val finalLocation = navigate(input)
    val result = finalLocation.horizontal * finalLocation.depth
    println("Part 2 Final Location: $finalLocation")
    println("Part 2 Answer: $result")
}

fun navigate(input: List<Pair<String, Int>>): Position =
    input.fold(Position(0, 0, 0)) { p: Position, i: Pair<String, Int> -> moveShip(p, i) }


fun moveShip(position: Position, command: Pair<String, Int>): Position {
    return when (command.first) {
        "forward" -> forward(position, command.second)
        "up" -> up(position, command.second)
        "down" -> down(position, command.second)
        else -> throw UnsupportedOperationException("Unknown command!")
    }
}

fun forward(position: Position, increment: Int): Position {
    return Position(position.horizontal + increment, position.depth + position.aim * increment, position.aim)
}

fun down(position: Position, increment: Int): Position {
    return Position(position.horizontal, position.depth, position.aim + increment)
}

fun up(position: Position, increment: Int): Position {
    return Position(position.horizontal, position.depth, position.aim - increment)
}
