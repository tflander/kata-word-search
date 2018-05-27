package todd

import org.junit.Test
import assertk.assert
import assertk.assertions.*

class ForwardHorizontalMatcherTest {

    val simple = """
A,B,C
D,E,F
G,H,I"""

    val grid = WordSearch(simple).grid
    val forwardDirection = Pair(1, 0)
    val backwardDirection = Pair(-1, 0)

    @Test
    fun `does not match at incorrect position`() {
        val matcher = ForwardHorizontalMatcher(grid, "EF", forwardDirection)
        assert(matcher.coordinateStartsMatch(Pair(1,0))).isFalse()
    }

    @Test
    fun `matches EF forward horizonal at correct position`() {
        val matcher = ForwardHorizontalMatcher(grid, "EF", forwardDirection)
        assert(matcher.coordinateStartsMatch(Pair(1,1))).isTrue()
    }

    @Test
    fun `forward horizonal matching does not error with out of bounds`() {
        val matcher = ForwardHorizontalMatcher(grid, "FG", forwardDirection)
        assert(matcher.coordinateStartsMatch(Pair(2,1))).isFalse()
    }

    @Test
    fun `matches FE backward horizontal at correct position`() {
        val matcher = ForwardHorizontalMatcher(grid, "ED", backwardDirection)
        assert(matcher.coordinateStartsMatch(Pair(1,1))).isTrue()
    }

    @Test
    fun `backward horizonal matching does not error with out of bounds`() {
        val matcher = ForwardHorizontalMatcher(grid, "DC", backwardDirection)
        assert(matcher.coordinateStartsMatch(Pair(0,1))).isFalse()
    }

}