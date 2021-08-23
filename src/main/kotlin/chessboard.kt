import chessboard.ChessBoard
import kotlinx.browser.document
import kotlinx.css.*
import kotlinx.html.id
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLTextAreaElement
import react.*
import react.dom.attrs
import react.dom.button
import react.dom.div
import react.dom.h1
import styled.css
import styled.styledDiv
import styled.styledTextArea

external interface ChessBoardProps : RProps {
    var chessBoardState: ChessBoardState
}

data class ChessBoardState(var board: ChessBoard) : RState

@JsExport
class ChessBoardComponent(props: ChessBoardProps) : RComponent<ChessBoardProps, ChessBoardState>(props) {

    init {
        state = props.chessBoardState
    }

    override fun RBuilder.render() {
        div("chessBoard") {
            var isBlackSquare = false
            var count = 1
            state.board.board.reversed().map { row ->
                row.map { piece ->
                    val squareColor = if (isBlackSquare) "blackSquare" else "whiteSquare"
                    if (count % 8 != 0) isBlackSquare = isBlackSquare.not()
                    count++

                    if (piece == null) div(squareColor) {}
                    else
                        div(squareColor) {
                            +piece.icon
                        }
                }
            }
        }
        styledDiv {
            css {
                marginLeft = 20.px
                float = Float.left
            }
            h1 {
                +"Chess Mentor"
            }
            styledTextArea {
                css {
                    width = 500.px
                    height = 300.px
                }
                attrs {
                    placeholder = "Enter PGN format to play game"
                    id = "PGN-input"
                }
            }
            button {
                +"Replay game"
                attrs {
                    onClickFunction = {
                        val pgn = (document.getElementById("PGN-input") as HTMLTextAreaElement).value

                        setState {
                            board.changeRandomSquare()
                            board.pgn = pgn

                            // TODO while(val move = board.getNextMove() != null) { doMove() sleep() }
                        }
                    }
                }
            }
        }
    }
}
