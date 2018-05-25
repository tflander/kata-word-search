package todd

class WordSearch(board: String) {

    private val boardLines = board.split("\n")

    val wordList: List<String> = boardLines.get(0).split(",")
    val grid = GridBuilder.build(boardLines)
    val gridAnalyzer = GridAnalyzer(grid)
    fun find(word: String): List<Pair<Int, Int>> {

        return emptyList();
    }

}

class GridAnalyzer(val grid: List<List<String>>) {
    fun coordinatesForFirstLetterInWord(word: String): List<Pair<Int, Int>> {
        val firstLetterInWord = word.substring(0,1)

        var result = emptyList<Pair<Int, Int>>()
        for(r in 0 until grid.size) {
            val row = grid.get(r)
            for(c in 0 until row.size) {
                if(row.get(c) == firstLetterInWord) {
                    result += Pair(r,c)
                }
            }
        }
        return result
    }

}

object GridBuilder {

    fun build(board: List<String>): List<List<String>> {
        return board.subList(1, board.size)
                .map { line -> line.split(",") }
    }

}
