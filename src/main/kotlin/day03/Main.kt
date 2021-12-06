package day03

import java.io.File

fun main(args: Array<String>) {
    val puzzleInput = readInput()
    val sums = processInput(puzzleInput)
    val gamma = calculateGamma(sums)
    val epsilon = calculateEpsilon(sums)
    val answer = gamma * epsilon
    println("Part 1 sum: $sums")
    println("Part 1 gamma: $gamma")
    println("Part 1 epsilon: $epsilon")
    println("Part 1 answer: $answer")
}

private fun readInput(path: String = "/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day03-input.txt"): List<String> {
    val file = File(path)
    return file.readLines()
}

fun processLineAtIndex(line: String, position: Int): Boolean = line[position] == '1'

fun processInput(lines: List<String>): List<Pair<Int, Int>> {
    val sums = emptyList<Pair<Int, Int>>().toMutableList()
    for (i in lines[0].indices) {
        sums.add(processGivenIndex(lines, i))
    }
    return sums.toList()
}

fun processGivenIndex(lines: List<String>, i: Int): Pair<Int, Int> {
    var sums = Pair(0, 0)
    for (line in lines) {
        sums = processLine(line, i, sums)
    }
    return sums
}

fun processLine(line: String, index: Int, sums: Pair<Int, Int>): Pair<Int, Int> {
    return if (line[index] == '0') {
        Pair(sums.first + 1, sums.second)
    } else {
        Pair(sums.first, sums.second + 1)
    }
}

fun processPairs(input: Pair<Int, Int>): Int {
    return if (input.first > input.second) {
        0
    } else {
        1
    }
}

fun calculateGamma(inputs: List<Pair<Int, Int>>): Int =
    inputs.fold(0) { value: Int, input: Pair<Int, Int> -> value * 2 + processPairs(input) }

fun calculateEpsilon(inputs: List<Pair<Int, Int>>): Int =
    inputs.fold(0) { value: Int, input: Pair<Int, Int> -> value * 2 + processPairs(input).xor(1)}