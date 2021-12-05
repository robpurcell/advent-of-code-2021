package day01

import java.io.File

fun main(args: Array<String>) {
    val puzzleInput = readInput()
    val answer1 = countDepthIncreases(createPairs(puzzleInput.subList(1, puzzleInput.size)))
    println("Part 1 answer: $answer1")

    val answer2 = countSlidingWindowMeasurementIncreases(sumOfMeasurements(createTriples(puzzleInput)))
    println("Part 2 answer: $answer2")
}

fun createPairs(depths: List<Int>): List<Pair<Int, Int>> {
    return createPairs(depths, listOf(Pair(0, depths.first())), 0)
}

private fun createPairs(depths: List<Int>, pairsOfDepths: List<Pair<Int, Int>>, index: Int): List<Pair<Int, Int>> {
    return if (index >= depths.size - 1) {
        pairsOfDepths
    } else {
        val newList = buildList() {
            addAll(pairsOfDepths)
            add(Pair(depths[index], depths[index + 1]))
        }
        createPairs(depths, newList, index + 1)
    }
}

fun countDepthIncreases(depths: List<Pair<Int, Int>>): Int {
    var count = 0
    for (d in depths) {
        if (d.first < d.second) {
            count++
        }
    }
    return count
}

private fun readInput(path: String = "/Users/rob/Development/source/github/advent-of-code-2021/src/test/resources/day01-input.txt"): List<Int> {
    val file = File(path)
    return file.readLines().map { it.toInt() }
}

fun createTriples(depths: List<Int>): List<Triple<Int, Int, Int>> {
    return createTriples(depths, emptyList(), 0)
}

private fun createTriples(depths: List<Int>, triplesOfDepths: List<Triple<Int, Int, Int>>, index: Int): List<Triple<Int, Int, Int>> {
    return if (index >= depths.size - 2) {
        triplesOfDepths
    } else {
        val newList = buildList() {
            addAll(triplesOfDepths)
            add(Triple(depths[index], depths[index + 1], depths[index + 2]))
        }
        createTriples(depths, newList, index + 1)
    }
}

fun sumOfMeasurements(triplesOfDepths: List<Triple<Int, Int, Int>>): List<Int> {
    val sums = emptyList<Int>().toMutableList()
    for(t in triplesOfDepths) {
        sums.add(t.toList().sum())
    }
    return sums
}

fun countSlidingWindowMeasurementIncreases(measurements: List<Int>): Int {
    val measurementPairs = createPairs(measurements)
    return countDepthIncreases(measurementPairs.subList(1, measurementPairs.size))
}