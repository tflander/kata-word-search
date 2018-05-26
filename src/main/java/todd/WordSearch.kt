package todd

class WordSearch(board: String) {

    private val boardLines = board.split("\n")

    val wordList: List<String> = boardLines.get(0).split(",")
    val grid = GridBuilder.build(boardLines)
    val gridAnalyzer = GridAnalyzer(grid)

    fun find(word: String): List<Pair<Int, Int>> {
        val coordinatesForFirstLetterInWord = gridAnalyzer.coordinatesForFirstLetterInWord(word)
        return gridAnalyzer.find(word)
    }

}

class GridAnalyzer(val grid: List<List<String>>) {
    fun coordinatesForFirstLetterInWord(word: String): List<Pair<Int, Int>> {
        val firstLetterInWord = word.substring(0, 1)

        // TODO: refactor imperitive logic
        var result = emptyList<Pair<Int, Int>>()
        for (r in 0 until grid.size) {
            val row = grid.get(r)
            for (c in 0 until row.size) {
                if (row.get(c) == firstLetterInWord) {
                    result += Pair(c, r)
                }
            }
        }
        return result
    }

    fun find(word: String): List<Pair<Int, Int>> {
        val startingCoordinates = coordinatesForFirstLetterInWord(word)

        val matcher = ForwardHorizontalMatcher(grid, word)
        val matchesHorizontalForward = startingCoordinates.filter { coord -> matcher.coordinateStartsMatch(coord) }
        if(matchesHorizontalForward.isEmpty()) {
            return emptyList()
        } else {
            val firstMatch = matchesHorizontalForward.get(0)
            return List<Pair<Int, Int>>(word.length) { it -> Pair(firstMatch.first + it, firstMatch.second) }
        }
    }

}

class ForwardHorizontalMatcher(private val grid: List<List<String>>, val word: String) {

    fun coordinateStartsMatch(coordinate: Pair<Int, Int>): Boolean {
        val direction = Pair(1, 0)

        // TODO: honor direction
        if (coordinate.first + word.length > grid[0].size) {
            return false
        }

        for (i in 1 until word.length) {
            if (word[i] != grid.get(coordinate.second + (i * direction.second)).get(coordinate.first + (i * direction.first))[0]) {
                return false
            }
        }
        return true
    }
}

object GridBuilder {

    fun build(board: List<String>): List<List<String>> {
        return board.subList(1, board.size)
                .map { line -> line.split(",") }
    }

}
