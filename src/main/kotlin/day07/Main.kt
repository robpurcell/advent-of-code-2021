package day07

import java.io.File

fun main() {
    val inputNumbers = readInput()
    val sum = inputNumbers.reduce { sum, element -> sum + element }
    val average = sum / inputNumbers.size

    for (i in inputNumbers.minOf { it }..inputNumbers.maxOf { it }) {
        val total = calculateTotal(inputNumbers, i)
        println("$i -> $total")
    }

    val result1 = findMin(inputNumbers, average)
    println("Part 1 Result: $result1")

    val result2 = findVariableBurnMin(inputNumbers, average)
    println("Part 2 Result: $result2")
}

private fun readInput(path: String = "/Users/rob/Development/source/advent-of-code-2021/src/test/resources/day07-input.txt"): List<Int> {
    val file = File(path)
    return file.readLines()[0].split(",").map { it.toInt() }
}

fun calculateTotal(numbers: List<Int>, hPos: Int): Int {
    return numbers.fold(0) { sum, element -> sum + kotlin.math.abs(element - hPos) }
}

fun calculateVariableBurnTotal(numbers: List<Int>, hPos: Int): Int {
    return numbers.fold(0) { sum, element -> sum + cost(kotlin.math.abs(element - hPos)) }
}

fun findMin(numbers: List<Int>, hPos: Int): Int {
    val totalPositive = calculateTotal(numbers, hPos + 1)
    val totalNegative = calculateTotal(numbers, hPos - 1)

    return if (totalPositive > totalNegative) {
        findMin(numbers, totalNegative, hPos - 1)
    } else {
        findMin(numbers, totalPositive, hPos + 1)
    }
}

fun findMin(numbers: List<Int>, currentMin: Int, hPos: Int): Int {
    val totalPositive = calculateTotal(numbers, hPos + 1)
    val totalNegative = calculateTotal(numbers, hPos - 1)

    return if (totalPositive > currentMin && totalNegative > currentMin) {
        currentMin
    }
    else if (totalPositive > currentMin) {
        findMin(numbers, totalNegative, hPos - 1)
    }
    else {
        findMin(numbers, totalPositive, hPos -1)
    }
}

fun findVariableBurnMin(numbers: List<Int>, hPos: Int): Int {
    val totalPositive = calculateVariableBurnTotal(numbers, hPos + 1)
    val totalNegative = calculateVariableBurnTotal(numbers, hPos - 1)

    return if (totalPositive > totalNegative) {
        findVariableBurnMin(numbers, totalNegative, hPos - 1)
    } else {
        findVariableBurnMin(numbers, totalPositive, hPos + 1)
    }
}

fun findVariableBurnMin(numbers: List<Int>, currentMin: Int, hPos: Int): Int {
    val totalPositive = calculateVariableBurnTotal(numbers, hPos + 1)
    val totalNegative = calculateVariableBurnTotal(numbers, hPos - 1)

    return if (totalPositive > currentMin && totalNegative > currentMin) {
        currentMin
    }
    else if (totalPositive > currentMin) {
        findVariableBurnMin(numbers, totalNegative, hPos - 1)
    }
    else {
        findVariableBurnMin(numbers, totalPositive, hPos -1)
    }
}

fun cost(v: Int): Int {
    return cost(v, 0)
}

fun cost(v: Int, acc: Int): Int {
    if (v == 0) {
        return acc
    }
    return cost(v - 1, acc + v)
}