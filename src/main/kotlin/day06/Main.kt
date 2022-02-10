package day06

import java.io.File

// State managed as follows:
// 1,2,3,4,1,1,2,3 =>
// listOf(0, 3, 2, 2, 1, 0, 0, 0, 0)
// i.e. 0 0s, 3 1s, 2 2s, 2 3s, 1 4s, 5s, 6s, 7s ,8s
fun main(args: Array<String>) {
    val file = File("/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day06-input.txt")
    val input = file.readLines().map { s -> s.split(",").map {  it.toInt() }}[0]
    val indexedValues = collectInputs(input)
    val answer1 = processDays(indexedValues, 80).reduce { sum, element -> sum + element }
    println("Part 1 answer: $answer1")

    val answer2 = processDays(indexedValues, 256).reduce { sum, element -> sum + element }
    println("Part 2 answer: $answer2")
}

fun collectInputs(input: List<Int>): List<Long> {
    val indexedValues = mutableListOf(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L)
    for (i in input) {
        indexedValues[i] = indexedValues[i] + 1
    }
    return indexedValues
}

/*
Initial state: 3,4,3,1,2
After  1 day:  2,3,2,0,1
After  2 days: 1,2,1,6,0,8
After  3 days: 0,1,0,5,6,7,8

So:             0  1  2  3  4  5  6  7  8
Initial state: (0, 1, 1, 2, 1, 0, 0, 0, 0)
After  1 day:  (1, 1, 2, 1, 0, 0, 0, 0, 0)
After  2 days: (1, 2, 1, 0, 0, 0, 1, 0, 1)
After  3 days: (2, 1, 0, 0, 0, 1, 1, 1, 1)

*/
fun processDays(input: List<Long>, days: Int): List<Long> {
    val newInput = processDay(input)
    return if (days == 1) {
        newInput
    } else {
        processDays(newInput, days - 1)
    }
}

fun processDay(input: List<Long>): List<Long> {
    val zeros = input[0]
    val output = input.subList(1, 9).toMutableList()
    output.add(zeros)
    output[6] += zeros
    return output
}