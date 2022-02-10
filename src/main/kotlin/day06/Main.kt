package day06

import java.io.File

fun main(args: Array<String>) {
    val file = File("/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day06-input.txt")
    val input = file.readLines().map { s -> s.split(",").map {  it.toInt() }}
    val answer1 = processDays(input[0], 80)
    println("Part 1 answer: $answer1")

}

fun processDecrease(state: List<Int>): List<Int> {
    return state.map { i -> i - 1 }
}

fun countZeroes(state: List<Int>): Int {
    return state.count { i -> i == 0 }
}

fun resetZeroes(state: List<Int>): List<Int> {
    return state.toMutableList().map { i ->
        if (i == 0) {
            7
        } else {
            i
        }
    }
}

fun processState(state: List<Int>): List<Int> {
    val zeroes = countZeroes(state)
    return addFish(processDecrease(resetZeroes(state)), zeroes)
}

fun addFish(state: List<Int>, zeroes: Int): List<Int> {
    val newFish = List(zeroes) { 8 }
    val modifiedList = state.toMutableList()
    modifiedList.addAll(newFish)
    return modifiedList.toList()
}

fun processDays(state: List<Int>, days: Int) : Int {
    var modifiedState = state.toMutableList()
    for (i in 1..days) {
        modifiedState = processState(modifiedState).toMutableList()
    }
    return modifiedState.size
}

