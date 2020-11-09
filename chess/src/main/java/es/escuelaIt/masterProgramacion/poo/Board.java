package es.escuelaIt.masterProgramacion.poo;

import java.util.List;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Board {

    private Square[][] squares;

    private Console console;

    public Board() {
        this.console = new Console();
        this.squares = new Square[Coordinate.DIMENSION][Coordinate.DIMENSION];
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.squares[i][j] = new Square(this.getSquareColor(i, j));
            }
        }
    }
    
    private String getSquareColor(int i, int j) {
        if ((i + j) % 2 == 0) 
            return Square.DARK;
        return Square.LIGHT;
    }

    public void show() {
        this.console.writeln();
        for (int i = Coordinate.DIMENSION - 1; i >= 0 ; i--) {
            console.write((i+1) + " ");
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                this.console.write(this.squares[i][j].toString());
            }
            this.console.writeln();
        }
        this.console.writeln();
        this.console.write("  ");
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            this.console.write(i + " ");
        }
        this.console.writeln();
        this.console.writeln();
    }

	public boolean full(Coordinate origin, Color color) {
        if (this.getSquare(origin).isEmpty()) {
            this.console.writeln("There is no piece in this square");
            return false;
        }
        if (this.getPiece(origin).getColor() != color) {
            this.console.writeln("This piece is not yours!");
            return false;
        }
        return true;
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

    public void setBoard(Player[] players) {
        int i = 0;
        this.setPiece(i, 0, new Rook(players[0].getColor()));
        this.setPiece(i, 1, new Knight(players[0].getColor()));
        this.setPiece(i, 2, new Bishop(players[0].getColor()));
        this.setPiece(i, 3, new Queen(players[0].getColor()));
        this.setPiece(i, 4, new King(players[0].getColor()));
        this.setPiece(i, 5, new Bishop(players[0].getColor()));
        this.setPiece(i, 6, new Knight(players[0].getColor()));
        this.setPiece(i, 7, new Rook(players[0].getColor()));
        for (int j = 0; j < Coordinate.DIMENSION; j++) {
            this.setPiece(1, j, new Pawn(players[0].getColor()));
            this.setPiece(Coordinate.DIMENSION - 2, j, new Pawn(players[1].getColor()));  
        }
        i = Coordinate.DIMENSION - 1;
        this.setPiece(i, 0, new Rook(players[1].getColor()));
        this.setPiece(i, 1, new Knight(players[1].getColor()));
        this.setPiece(i, 2, new Bishop(players[1].getColor()));
        this.setPiece(i, 3, new Queen(players[1].getColor()));
        this.setPiece(i, 4, new King(players[1].getColor()));
        this.setPiece(i, 5, new Bishop(players[1].getColor()));
        this.setPiece(i, 6, new Knight(players[1].getColor()));
        this.setPiece(i, 7, new Rook(players[1].getColor()));
	}

	public void move(Coordinate origin, Coordinate destination) {
        this.setPiece(destination, this.getPiece(origin));
        this.setPiece(origin, null);
    }

	public boolean isCheckmate(Color color) {
        King king = new King(color);
        for (int i = 0; i < Coordinate.DIMENSION; i++) {
            for (int j = 0; j < Coordinate.DIMENSION; j++) {
                if (!this.squares[i][j].isEmpty() && this.getPiece(i, j).equals(king)) {
                    return false;
                }
            }
        }
		return true;
	}

    private Square getSquare(Coordinate coordinate) {
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    private Piece getPiece(int i, int j) {
        return this.squares[i][j].getPiece();
    }

    private Piece getPiece(Coordinate coordinate) {
        return this.getPiece(coordinate.getRow(), coordinate.getColumn());
    }

    private void setPiece(int i, int j, Piece piece) {
        this.squares[i][j].setPiece(piece);
    }

    private void setPiece(Coordinate coordinate, Piece piece) {
        this.setPiece(coordinate.getRow(), coordinate.getColumn(), piece);
    }
}
