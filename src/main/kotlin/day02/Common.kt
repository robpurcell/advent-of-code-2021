package day02

import java.io.File

fun readInput(path: String = "/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day02-input.txt"): List<String> {
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

data class Position(val horizontal: Int, val depth: Int, val aim: Int)
