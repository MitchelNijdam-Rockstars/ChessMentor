import chessBoard.ChessBoard
import kotlinx.css.Float
import kotlinx.css.float
import kotlinx.css.marginLeft
import kotlinx.css.px
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import styled.css
import styled.styledDiv

external interface ChessBoardProps : RProps {
    var initialChessBoardState: ChessBoardState
}

data class ChessBoardState(val board: ChessBoard) : RState

@JsExport
class ChessBoardComponent(props: ChessBoardProps) : RComponent<ChessBoardProps, ChessBoardState>(props) {

    init {
        state = props.initialChessBoardState
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
            button {
                + "Do something"
                attrs {
                    onClickFunction = {
                        // TODO
                        /*if (state.text.isNotEmpty()) {
                            setState {
                                items += text
                                text = ""
                            }
                        }*/

                    }

                }
            }
        }
    }
}
