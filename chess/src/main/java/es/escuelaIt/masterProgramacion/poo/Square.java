package es.escuelaIt.masterProgramacion.poo;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Square {

    public final static String DARK = "::";

    public final static String LIGHT = "  ";

    private Piece piece;

    private String background;

    private Coordinate coordinate;

    public Square(Coordinate coordinate) {
        this.piece = null;
        this.coordinate = coordinate;
        if ((this.coordinate.getRow() + this.coordinate.getColumn()) % 2 == 0) {
            this.background = Square.DARK;
        } else {
            this.background = Square.LIGHT;
        }
    }

    public boolean isFull(Color color) {
        Console console = new Console();
        if (this.isEmpty()) {
            console.writeln("There is no piece in this square");
            return false;
        }
        if (!this.piece.isColor(color)) {
            console.writeln("This piece is not yours!");
            return false;
        }
        return true;
    }

	public boolean isEmpty() {
		return this.piece == null;
    }
    
    public boolean isValidMovement(Square square) {
        return this.piece.isValidMovement(this.coordinate, square.coordinate, square);
    }
    
    public void move(Square square) {
        square.piece = this.piece;
        this.piece = null;
    }

	public boolean isKing(Color color) {
        if (!this.isEmpty()) {
            return this.piece.isKing(color);
        }
		return false;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return this.background;
        return this.piece.toString();
    }
}
