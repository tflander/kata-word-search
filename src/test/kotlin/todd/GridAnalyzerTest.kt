package todd

import assertk.assert
import assertk.assertions.containsExactly
import org.junit.Test
import todd.support.GameExample

class GridAnalyzerTest {

    val analyzer = GridAnalyzer(WordSearch(GameExample.starTrek).grid)

    @Test
    fun `analyzer finds coordinates for the first letter of a word to find`() {
        assert(analyzer.coordinatesForFirstLetterInWord("Bones")).containsExactly(
                Pair(11, 2),
                Pair(0, 3),
                Pair(0, 6),
                Pair(11, 7),
                Pair(7, 10),
                Pair(9, 10),
                Pair(3, 11),
                Pair(6, 11),
                Pair(11, 12),
                Pair(9, 13),
                Pair(3, 14),
                Pair(14, 14)
        )
    }

    @Test
    fun `analyzer finds word horizontal forward`() {
        assert(analyzer.find("SCOTTY")).containsExactly(Pair(0,5), Pair(1,5), Pair(2,5), Pair(3,5), Pair(4,5), Pair(5,5))
    }
}