package todd

import assertk.assert
import assertk.assertions.containsExactly
import assertk.assertions.hasSize
import org.junit.Test
import todd.support.GameExample

class WordSearchTest {

    val game = WordSearch(GameExample.starTrek)

    @Test
    fun `game setup gets word list`() {
        assert(game.wordList).containsExactly("BONES", "KHAN", "KIRK", "SCOTTY", "SPOCK", "SULU", "UHURA")
    }

    @Test
    fun `setup gets 15 x 15 grid`() {
        assert(game.grid).hasSize(15)
        game.grid.forEach { line ->
            assert(line).hasSize(15)
        }
    }

    @Test
    fun `finds SCOTTY by searching horizontally forward`() {
        assert(game.find("SCOTTY")).containsExactly(Pair(0, 5), Pair(1, 5), Pair(2, 5), Pair(3, 5), Pair(4, 5), Pair(5, 5))
    }

    @Test
    fun `finds KIRK by searching horizontally backwards`() {
        assert(game.find("KIRK")).containsExactly(Pair(4, 7), Pair(3, 7), Pair(2, 7), Pair(1, 7))
    }

    @Test
    fun `finds BONES by searching vertically down`() {
        assert(game.find("BONES")).containsExactly(Pair(0, 6), Pair(0, 7), Pair(0, 8), Pair(0, 9), Pair(0, 10))
    }

    @Test
    fun `finds KHAN by searching vertically up`() {
        assert(game.find("KHAN")).containsExactly(Pair(5, 9), Pair(5, 8), Pair(5, 7), Pair(5, 6))
    }

    @Test
    fun `finds SPOCK by searching diagonally upper left to lower right`() {
        assert(game.find("SPOCK")).containsExactly(Pair(2, 1), Pair(3, 2), Pair(4, 3), Pair(5, 4), Pair(6, 5))
    }

    @Test
    fun `finds SULU by searching diagonally lower right to upper left`() {
        assert(game.find("SULU")).containsExactly(Pair(3, 3), Pair(2, 2), Pair(1, 1), Pair(0, 0))
    }

    @Test
    fun `finds UHURA by searching diagonally upper right to lower left`() {
        assert(game.find("UHURA")).containsExactly(Pair(4, 0), Pair(3, 1), Pair(2, 2), Pair(1, 3), Pair(0, 4))
    }

    // TODO: Grid Builder tests for invalid setup
}
