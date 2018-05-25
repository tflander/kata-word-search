package todd

import assertk.assert
import assertk.assertions.containsExactly
import org.junit.Test
import todd.support.GameExample

class GridAnalyzerTest {

    val analyzer = GridAnalyzer(WordSearch(GameExample.starTrek).grid)

    @Test
    fun `analyzer finds coordinates for the first letter of a word to find`() {
        val coordinates: List<Pair<Int, Int>> = analyzer.coordinatesForFirstLetterInWord("Bones")
        assert(coordinates).containsExactly(
                Pair(2, 11),
                Pair(3, 0),
                Pair(6, 0),
                Pair(7, 11),
                Pair(10, 7),
                Pair(10, 9),
                Pair(11, 3),
                Pair(11, 6),
                Pair(12, 11),
                Pair(13, 9),
                Pair(14, 3),
                Pair(14, 14)
        )
    }
}