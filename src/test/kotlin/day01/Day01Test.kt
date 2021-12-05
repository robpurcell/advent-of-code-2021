package day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day01Test {
    val input = listOf(
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263,
    )

    @Test
    fun testProcessingList() {
        val input = listOf(
            100,
            200,
            300
        )

        assertEquals(
            listOf(
                Pair(0, 100),
                Pair(100, 200),
                Pair(200, 300)
            ), createPairs(input)
        )
    }

    @Test
    fun testCountDepthsIncreasing() {
        val depthPairs = createPairs(input)
        assertEquals(countDepthIncreases(depthPairs.subList(1, depthPairs.size)), 7)
    }

    @Test
    fun testCreateTriples() {
        assertEquals(
            listOf(
                Triple(199, 200, 208),
                Triple(200, 208, 210),
                Triple(208, 210, 200),
                Triple(210, 200, 207),
                Triple(200, 207, 240),
                Triple(207, 240, 269),
                Triple(240, 269, 260),
                Triple(269, 260, 263)
            ), createTriples(input)
        )
    }

    @Test
    fun testSumTriple() {
        assertEquals(607, Triple(199, 200, 208).toList().sum())
    }

    @Test
    fun testSumOfMeasurements() {
        assertEquals(
            listOf(
                607,
                618,
                618,
                617,
                647,
                716,
                769,
                792
            ), sumOfMeasurements(createTriples(input))
        )
    }

    @Test
    fun testCountMeasurementIncreases() {
        println(countSlidingWindowMeasurementIncreases(sumOfMeasurements(createTriples(input))))
    }

}

