package todd

import org.junit.Test
import assertk.assert
import assertk.assertions.*
import org.junit.Ignore
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
        assert(game.find("SCOTTY")).containsExactly(Pair(0,5), Pair(1,5), Pair(2,5), Pair(3,5), Pair(4,5), Pair(5,5))
    }

    @Test
    fun `finds KIRK by searching horizontally backwards`() {
        assert(game.find("KIRK")).containsExactly(Pair(4,7), Pair(3,7), Pair(2,7), Pair(1,7))
    }

    // TODO: Grid Builder tests for invalid setup
}
