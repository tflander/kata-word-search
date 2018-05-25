package todd

class WordSearch(board: String) {

    private val boardLines = board.split("\n")

    val wordList: List<String> = boardLines.get(0).split(",")

    fun find(word: String): List<Pair<Int, Int>> {
        return emptyList();
    }


}
