package todd

class WordSearch(board: String) {

    private val boardLines = board.split("\n")

    val wordList: List<String> = boardLines.get(0).split(",")
    val grid = GridBuilder.build(boardLines)
    private val gridAnalyzer = GridAnalyzer(grid)

    fun find(word: String): List<Pair<Int, Int>> {
        return gridAnalyzer.find(word)
    }

}

class GridAnalyzer(val grid: List<List<String>>) {

    fun find(word: String): List<Pair<Int, Int>> {
        for(x in -1..1) {
            for(y in -1..1) {
                if(x != 0 || y != 0) {
                    val matchesForDirection = findMatchesForDirection(word, Pair(x, y))
                    if (matchesForDirection.isNotEmpty()) {
                        return matchesForDirection
                    }
                }
            }
        }
        return emptyList()
    }

    fun coordinatesForFirstLetterInWord(word: String): List<Pair<Int, Int>> {
        val firstLetterInWord = word.substring(0, 1)

        // TODO: refactor imperative logic
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

    private fun findMatchesForDirection(word: String, direction: Pair<Int, Int>): List<Pair<Int, Int>> {
        val matcher = WordMatcher(grid, word, direction)
        val matchesForDirection = coordinatesForFirstLetterInWord(word).filter { coord -> matcher.coordinateStartsMatch(coord) }
        if (matchesForDirection.isEmpty()) {
            return emptyList()
        } else {
            val firstMatch = matchesForDirection.get(0)
            return List<Pair<Int, Int>>(word.length) { it -> Pair(firstMatch.first + (it * direction.first), firstMatch.second + (it * direction.second)) }
        }
    }

}

class WordMatcher(private val grid: List<List<String>>, val word: String, val direction: Pair<Int, Int>) {

    fun coordinateStartsMatch(startingCoordinate: Pair<Int, Int>): Boolean {

        if (isEndingCoordinateOutOfBounds(startingCoordinate)) return false

        for (i in 0 until word.length) {
            if (word[i] != grid.get(startingCoordinate.second + (i * direction.second)).get(startingCoordinate.first + (i * direction.first))[0]) {
                return false
            }
        }
        return true
    }

    private fun isEndingCoordinateOutOfBounds(coordinate: Pair<Int, Int>): Boolean {
        val horizontalBorder = coordinate.first + (direction.first * word.length)
        val verticalBorder = coordinate.second + (direction.second * word.length)
        if (horizontalBorder > grid[0].size ||
                horizontalBorder < -1 ||
                verticalBorder > grid.size ||
                verticalBorder < -1) {
            return true
        }
        return false
    }
}

object GridBuilder {

    fun build(board: List<String>): List<List<String>> {
        return board.subList(1, board.size)
                .map { line -> line.split(",") }
    }

}
