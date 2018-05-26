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

    @Test
    fun `matches EF at correct position`() {
        val matcher = ForwardHorizontalMatcher(grid, "EF")
        assert(matcher.coordinateStartsMatch(Pair(1,1))).isTrue()
    }

    @Test
    fun `does not matche EF at incorrect position`() {
        val matcher = ForwardHorizontalMatcher(grid, "EF")
        assert(matcher.coordinateStartsMatch(Pair(1,0))).isFalse()
    }

    @Test
    fun `does not match FG and does not error`() {
        val matcher = ForwardHorizontalMatcher(grid, "FG")
        assert(matcher.coordinateStartsMatch(Pair(2,1))).isFalse()
    }

    @Test
    fun `matches DEF`() {
        val matcher = ForwardHorizontalMatcher(grid, "DEF")
        assert(matcher.coordinateStartsMatch(Pair(0,1))).isTrue()
    }

    @Test
    fun `does not match DEG`() {
        val matcher = ForwardHorizontalMatcher(grid, "DEG")
        assert(matcher.coordinateStartsMatch(Pair(0,1))).isFalse()
    }
}