package day02

fun main(args: Array<String>) {
    val input = processCommandsFile(readInput())
    val finalLocation = navigateBasic(input)
    val result = finalLocation.horizontal * finalLocation.depth
    println("Part 1 Final Location: $finalLocation")
    println("Part 1 Answer: $result")
}

fun navigateBasic(input: List<Pair<String, Int>>): Position =
    input.fold(Position(0, 0, 0)) { p: Position, i: Pair<String, Int> -> moveShipBasic(p, i) }

fun moveShipBasic(position: Position, command: Pair<String, Int>): Position {
    return when (command.first) {
        "forward" -> forwardBasic(position, command.second)
        "up" -> upBasic(position, command.second)
        "down" -> downBasic(position, command.second)
        else -> throw UnsupportedOperationException("Unknown command!")
    }
}

fun forwardBasic(position: Position, increment: Int): Position {
    return Position(position.horizontal + increment, position.depth, 0)
}

fun downBasic(position: Position, increment: Int): Position {
    return Position(position.horizontal, position.depth + increment, 0)
}

fun upBasic(position: Position, increment: Int): Position {
    return Position(position.horizontal, position.depth - increment, 0)
}
