package todd

import org.junit.Test
import assertk.assert
import assertk.assertions.*
import org.junit.Ignore

class WordSearchTest {

    val game = WordSearch(
            """BONES,KHAN,KIRK,SCOTTY,SPOCK,SULU,UHURA
U,M,K,H,U,L,K,I,N,V,J,O,C,W,E
L,L,S,H,K,Z,Z,W,Z,C,G,J,U,Y,G
H,S,U,P,J,P,R,J,D,H,S,B,X,T,G
B,R,J,S,O,E,Q,E,T,I,K,K,G,L,E
A,Y,O,A,G,C,I,R,D,Q,H,R,T,C,D
S,C,O,T,T,Y,K,Z,R,E,P,P,X,P,F
B,L,Q,S,L,N,E,E,E,V,U,L,F,M,Z
O,K,R,I,K,A,M,M,R,M,F,B,A,P,P
N,U,I,I,Y,H,Q,M,E,M,Q,R,Y,F,S
E,Y,Z,Y,G,K,Q,J,P,C,Q,W,Y,A,K
S,J,F,Z,M,Q,I,B,D,B,E,M,K,W,D
T,G,L,B,H,C,B,E,C,H,T,O,Y,I,K
O,J,Y,E,U,L,N,C,C,L,Y,B,Z,U,H
W,Z,M,I,S,U,K,U,R,B,I,D,U,X,S
K,Y,L,B,Q,Q,P,M,D,F,C,K,E,A,B
"""
    )
/*
BONES: (0,6),(0,7),(0,8),(0,9),(0,10)
KHAN: (5,9),(5,8),(5,7),(5,6)
KIRK: (4,7),(3,7),(2,7),(1,7)
SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)
SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)
SULU: (3,3),(2,2),(1,1),(0,0)
UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)

 */
    @Test
    fun `game setup gets word list`() {
        assert(game.wordList).containsExactly("BONES", "KHAN", "KIRK", "SCOTTY", "SPOCK", "SULU", "UHURA")
    }

    @Test
    @Ignore // TODO: code this
    fun `finds SCOTTY by searching horizontally forward`() {
        assert(game.find("SCOTTY")).containsExactly(Pair(0,5), Pair(1,5), Pair(2,5), Pair(3,5), Pair(4,5), Pair(5,5))
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
