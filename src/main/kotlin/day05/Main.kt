package day05

import java.io.File

fun main(args: Array<String>) {

}

private fun readInput(path: String = "/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day01-input.txt"): List<Line> {
    val file = File(path)
    return file.readLines().map { processLine(it) }
}

typealias Line = Pair<Pair<Int, Int>, Pair<Int, Int>>
typealias Grid = List<List<Int>>

fun processLine(input: String): Line {
    val coordinates = input.split(" -> ")
    val x1 = coordinates[0].split(",")[0].toInt()
    val y1 = coordinates[0].split(",")[1].toInt()
    val x2 = coordinates[1].split(",")[0].toInt()
    val y2 = coordinates[1].split(",")[1].toInt()
    return Line(Pair(x1, y1), Pair(x2, y2))
}

fun plotLines(lines: List<Line>, grid: Grid) {

}

fun createGrid(): Grid {
    return MutableList(1000) { it -> MutableList(1000) { 0 } }
}



