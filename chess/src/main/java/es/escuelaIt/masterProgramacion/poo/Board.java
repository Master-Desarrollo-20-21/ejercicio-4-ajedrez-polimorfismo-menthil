package es.escuelaIt.masterProgramacion.poo;

import java.util.List;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Board {

    private Square[][] squares;

    public Board() {
        this.squares = new Square[Coordinate.DIMENSION][Coordinate.DIMENSION];
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.squares[i][j] = new Square(new Coordinate(i, j));
            }
        }
        this.setBoard();
    }

    public void setBoard() {
        for (Color color : Color.values()) {
            int initialRow = color.getInitialRow();
            Piece pieces[] = {
                new Rook(color), new Knight(color), new Bishop(color), new Queen(color),
                new King(color), new Bishop(color), new Knight(color), new Rook(color) 
            };
            for (int i = 0; i < pieces.length; i++) {
                this.setPiece(new Coordinate(initialRow, i), pieces[i]);
            }
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.setPiece(new Coordinate(initialRow + color.getIncrement(), j), new Pawn(color));
            }
        }
    }
    
    public void show() {
        Console console = new Console();
        console.writeln();
        for (int i = Coordinate.DIMENSION - 1; i >= 0 ; i--) {
            console.write((i+1) + " ");
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                console.write(this.getSquare(new Coordinate(i, j)).toString());
            }
            console.writeln();
        }
        console.writeln();
        console.write("  ");
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            console.write(i + " ");
        }
        console.writeln();
        console.writeln();
    }

	public boolean isFull(Coordinate origin, Color color) {
        return this.getSquare(origin).isFull(color);
	}

	public boolean isValidMovement(Coordinate origin, Coordinate destination) {
        Piece piece = this.getPiece(origin);
        Square square = this.getSquare(destination);
        if (piece.isValidMovement(origin, destination, square)) {
            List<Coordinate> coordinates = piece.getCoordinates(origin, destination);
            return this.isEmptyPath(coordinates);
        }
        return false;
    }

	private boolean isEmptyPath(List<Coordinate> coordinates) {
        for (Coordinate coordinate : coordinates) {
            if (!this.getSquare(coordinate).isEmpty())
                return false;
        }
        return true;
    }

	public void move(Coordinate origin, Coordinate destination) {
        this.getSquare(origin).move(this.getSquare(destination));
    }

	public boolean isCheckmate(Color color) {
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                if (this.getSquare(new Coordinate(i, j)).isKing(color)) {
                    return false;
                }
            }
        }
		return true;
    }
    

    

    private Square getSquare(Coordinate coordinate) {
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    private Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    private void setPiece(Coordinate coordinate, Piece piece) {
        this.getSquare(coordinate).setPiece(piece);
    }
}
