# Chess Game

## Task Description

Chess is a two-player strategy board game played on a chessboard, 
gameboard with 64 squares arranged in an 8×8 grid.

The objective is to checkmate the opponent's king by placing it 
under an inescapable threat of capture.
 
The set of rules can be found here: \
https://en.wikipedia.org/wiki/Chess#Rules
 
## Use cases

To make the castling, the user must select the king first. \
If a pawn reaches the end of the board, his promotion is automatically made to queen.

After a user clicks a tile, the tile should be highlighted having a green border.

![chessboard](https://user-images.githubusercontent.com/22919331/34906080-66fee7c6-f86e-11e7-9f60-81b20f44019b.png)

To move a piece the player needs to select the piece he wants to move and the spot he wants to move it. If the move is not correct, nothing will happen and he must repet the action again until he makes a valid move.

After a piece is captured it will appear in the right panel in the side of the player whose piece was captured.

![capture](https://user-images.githubusercontent.com/22919331/34906104-0c821c7c-f86f-11e7-8726-20a9b53bb172.PNG)

If a player is in check the king tile should have a red background

![chess](https://user-images.githubusercontent.com/22919331/34906111-37af39f2-f86f-11e7-9cc1-4fe396aa94dd.png)

If a player is in checkmate or is in stalemate, a popup should appear

![check](https://user-images.githubusercontent.com/22919331/34906155-dbf804ee-f86f-11e7-9f02-e3d7291d6a42.png)

## Class diagram

![uml](https://user-images.githubusercontent.com/22919331/34907273-bf6a7612-f884-11e7-8649-201c64b1cd28.PNG)

The application also has 2 classes for the gui implementation: Table and TablePanel

The class Board has an important method and that is the method move method. The class Piece is an abstract class and Pawn, Rook, King, Queen, Bishop, Knight extend this class and implement the abstract method possibleMoves and override the method isMoveValid.

## Implementation details

For the gui I used Java Swing, everyTile has an mouseListener on it and the Table class exstends Observable and has an Observer to know when the state variable from Board changes.

When you click a tile from where you want to move and a tile where you want to move, the method `move` from Board is called. In this method I first check if the selected piece belongs to the current player this method checks if the move is valid(calls the method from the piece class) then calls the method `validateMove` from board.
In the method `validateMove` I move the piece and check if after this move the player is in check, if it is, the piece is moved back and the player must make another move, if the move is valid the method` makeMove` is called.

In the method `makeMove`, the move is made on the board and the lastMove and currentPlayer fields are updated. If the moved piece was a Pawn and reached the end of the board, it is promoted to Queen.


After the move was made on the board, at the end of the `move` method I change the state of the game. I have an enum with 4 state: NORMAL, CHECK, CHECKMATE, STALEMATE. I verify if the kingTile is threatened by another piece, then I change the state of the game to CHECK. After that I check if the method `checkIfCheckMate` returns true. If it returns true I change the state to CHECKMATE. In the method `checkIfCheckMate` first I remove the king from the board(because I use the method `isThreatenTile` and the King can not threat a tile if he will end up in check after) , then I verify if the tile where the piece the king is attacked by is threatened by another piece with the `isThreatenTile` method. If that piece can't be taken by another piece, I call a method `checkIfNoThreat` which calls one of the methods `checkIfNoThreatOnLine` or `checkIfNoThreatOnDiagonal` depending on the coordinates from fromTile and toTile. I put the king back on the board and then I calculate all his possibleMoves, if there are no possible moves, then we are in checkmate. If we are not in check or checkmate, I verify if there are any possible moves for any of the current player pieces, if not the state of the game changes to STALEMATE.

After a move was made, the result is returend in the method move and in this method I check if the updated currentPlayer is now in check, in checkmate or in stalemate. To do this i use the function `isThreatenTile` for the kingTile.

For the Pawn I have a special method `movePawn` and there I check if the pawn can make the move en passant.

`public boolean isThreatenTile(Color threatenedColor, Tile threatenedTile, boolean canPawnAttack)` \
This function checks if the threanedTile is threaned by any piece. To do this, I make 2 direction arrays, one for the row direction and one for the column direction, then I make an array for every type of piece instead of the Knight with the positions in which it can attack. The knight has a special method because he can jump spaces so it doesn't matter if between the knight and the piece there is an friendly piece. After creating the array I make 2 for loops one for every direction and one for every step you can take in that direction and if I find a piece I check if it can attack the current tile, if not I move to the next direction. The parameter canPawnAttack is needed because with this function is also used in the method checkIfNoThreat used to check if the current player is in check mate.

In the `checkIfNoThreat` method I take every tile from the King to the piece who keeps the player in check and see if it is threatened, because that means a piece can move in the way of that piece and the king and the king wouldn't be in check anymore. In this situation the pawn cannot attack those tiles, because they are empty.

The method `checkIfClearWay` checks if there is no piece between the piece position and the tile it wants to move to.

I included in the tests directory some unit tests for checkmate, stalemate, piece moves and for the castling
## Further improvments

1. Make a Move class with 2 attributes, fromTile and toTile and make in board an arraylist of moves to keep the move history, this way I wouldn't need the lastMove attribute anymore.
2. Highlight on the board all possible moves a piece can make
3. Allow the player to choose in what to transform the pawn when it reaches the end of the board instead of promoting it into a queen automatically.
