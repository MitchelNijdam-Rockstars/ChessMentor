package chessBoard

import chessBoard.PieceColor.BLACK
import chessBoard.PieceColor.WHITE

val initialChessBoard = ChessBoard(
    listOf(
        listOf(
            Rook(WHITE),
            Knight(WHITE),
            Bishop(WHITE),
            Queen(WHITE),
            King(WHITE),
            Bishop(WHITE),
            Knight(WHITE),
            Rook(WHITE)
        ),
        listOf(
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE)
        ),
        listOf(null, null, null, null, null, null, null, null),
        listOf(null, null, null, null, null, null, null, null),
        listOf(null, null, null, null, null, null, null, null),
        listOf(null, null, null, null, null, null, null, null),
        listOf(
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK)
        ),
        listOf(
            Rook(BLACK),
            Knight(BLACK),
            Bishop(BLACK),
            Queen(BLACK),
            King(BLACK),
            Bishop(BLACK),
            Knight(BLACK),
            Rook(BLACK)
        ),
    )
)

class ChessBoard(val board: List<List<Piece?>>)

enum class PieceColor {
    BLACK, WHITE
}

open class Piece(
    val name: String,
    val value: Int,
    private val blackIcon: String,
    private val whiteIcon: String,
    open val color: PieceColor
) {
    val icon: String
        get() = if(color == WHITE) whiteIcon else blackIcon
}

class Pawn(override val color: PieceColor) : Piece("Pawn", 1, "♟", "♙", color)
class Knight(override val color: PieceColor) : Piece("Knight", 3, "♞", "♘", color)
class Bishop(override val color: PieceColor) : Piece("Bishop", 3, "♝", "♗", color)
class Rook(override val color: PieceColor) : Piece("Rook", 5, "♜", "♖", color)
class Queen(override val color: PieceColor) : Piece("Queen", 9, "♛", "♕", color)
class King(override val color: PieceColor) : Piece("King", 100, "♚", "♔", color)
