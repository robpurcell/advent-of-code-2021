package day03

import java.io.File

fun main(args: Array<String>) {
    val puzzleInput = readInput()
    val sums = processInput(puzzleInput)
    val gamma = calculateGamma(sums)
    val epsilon = calculateEpsilon(sums)
    val powerConsumption = gamma * epsilon
    println("Part 1 sum: $sums")
    println("Part 1 gamma: $gamma")
    println("Part 1 epsilon: $epsilon")
    println("Part 1 answer: $powerConsumption")

    val oxygen = calculateOxygenGeneratorRating(puzzleInput)
    val co2 = calculateCO2ScrubberRating(puzzleInput)
    val lifeSupportRating = oxygen * co2
    println("Part 2 oxygen: $oxygen")
    println("Part 2 co2: $co2")
    println("Part 2 Life Support Rating: $lifeSupportRating")
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
    inputs.fold(0) { value: Int, input: Pair<Int, Int> -> value * 2 + processPairs(input).xor(1) }

fun calculateOxygenGeneratorRating(lines: List<String>): Int {
    val oxygen = calculateOxygen(lines)
    return oxygen.toInt(2)
}

fun calculateOxygen(lines: List<String>): String {
    return calculateOxygen(lines, 0)
}

private fun calculateOxygen(lines: List<String>, index: Int): String {
    return if (lines.size == 1) {
        lines[0]
    } else {
        val discriminator = processInput(lines)[index]
        return if (discriminator.first > discriminator.second) {
            calculateOxygen(lines.filter { l -> l[index] == '0' }, index + 1)
        } else {
            calculateOxygen(lines.filter { l -> l[index] == '1' }, index + 1)
        }
    }
}

fun calculateCO2ScrubberRating(lines: List<String>): Int {
    val co2 = calculateCO2(lines)
    return co2.toInt(2)
}

fun calculateCO2(lines: List<String>): String {
    return calculateCO2(lines, 0)
}

private fun calculateCO2(lines: List<String>, index: Int): String {
    return if (lines.size == 1) {
        lines[0]
    } else {
        val discriminator = processInput(lines)[index]
        return if (discriminator.first <= discriminator.second) {
            calculateCO2(lines.filter { l -> l[index] == '0' }, index + 1)
        } else {
            calculateCO2(lines.filter { l -> l[index] == '1' }, index + 1)
        }
    }
}