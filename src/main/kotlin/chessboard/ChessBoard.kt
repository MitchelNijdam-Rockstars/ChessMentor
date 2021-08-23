package chessboard

import chessboard.PieceColor.BLACK
import chessboard.PieceColor.WHITE
import kotlin.reflect.KClass

val initialChessBoard = ChessBoard(
    mutableListOf(
        mutableListOf(
            Rook(WHITE),
            Knight(WHITE),
            Bishop(WHITE),
            Queen(WHITE),
            King(WHITE),
            Bishop(WHITE),
            Knight(WHITE),
            Rook(WHITE)
        ),
        mutableListOf(
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE),
            Pawn(WHITE)
        ),
        mutableListOf(null, null, null, null, null, null, null, null),
        mutableListOf(null, null, null, null, null, null, null, null),
        mutableListOf(null, null, null, null, null, null, null, null),
        mutableListOf(null, null, null, null, null, null, null, null),
        mutableListOf(
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK),
            Pawn(BLACK)
        ),
        mutableListOf(
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

class ChessBoard(val board: MutableList<MutableList<Piece?>>) {
    private var currentIndex: Int = 0
    var pgn: String? = null
        set(value) {
            field = value
            parsedPgn = parsePgn(value)
        }

    private fun parsePgn(value: String?): List<Move> {
        if (value == null) return emptyList()

        val moves = mutableListOf<Move>()

        // TODO: parse pgn to moves like below
        moves += Move(Bishop::class, "a2")
        return moves
    }

    private lateinit var parsedPgn: List<Move>

    fun changeRandomSquare() {
        val rank = (0 until board.size).random()
        val file = (0 until board[rank].size).random()
        board[rank][file] = listOf(Bishop(BLACK), Pawn(WHITE), King(BLACK), Queen(WHITE)).random()
    }

    fun getNextMove(): Move {
        val move = parsedPgn[currentIndex]
        currentIndex++
        return move
    }


}

data class Move(val piece: KClass<out Piece>, val destinationSquare: String)

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
        get() = if (color == WHITE) whiteIcon else blackIcon
}

class Pawn(override val color: PieceColor) : Piece("Pawn", 1, "♟", "♙", color)
class Knight(override val color: PieceColor) : Piece("Knight", 3, "♞", "♘", color)
class Bishop(override val color: PieceColor) : Piece("Bishop", 3, "♝", "♗", color)
class Rook(override val color: PieceColor) : Piece("Rook", 5, "♜", "♖", color)
class Queen(override val color: PieceColor) : Piece("Queen", 9, "♛", "♕", color)
class King(override val color: PieceColor) : Piece("King", 100, "♚", "♔", color)
