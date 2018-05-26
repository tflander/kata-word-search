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

    // TODO: Grid Builder tests for invalid setup
}
