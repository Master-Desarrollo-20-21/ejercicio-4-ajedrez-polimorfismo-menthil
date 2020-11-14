package es.escuelaIt.masterProgramacion.poo;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Square {

    public final static String DARK = "::";

    public final static String LIGHT = "  ";

    private Piece piece;

    private String color;

    private Coordinate coordinate;

    public Square(Coordinate coordinate) {
        this.piece = null;
        this.coordinate = coordinate;
        if ((this.coordinate.getRow() + this.coordinate.getColumn()) % 2 == 0) {
            this.color = Square.DARK;
        } else {
            this.color = Square.LIGHT;
        }
    }

    public boolean isFull(Color color) {
        Console console = new Console();
        if (this.isEmpty()) {
            console.writeln("There is no piece in this square");
            return false;
        }
        if (!this.getPiece().isColor(color)) {
            console.writeln("This piece is not yours!");
            return false;
        }
        return true;
    }

	public boolean isEmpty() {
		return this.piece == null;
	}
    
    public void move(Square square) {
        square.setPiece(this.getPiece());
        this.piece = null;
    }

	public boolean isKing(Color color) {
        if (!this.isEmpty()) {
            return this.getPiece().isKing(color);
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
            return this.color;
        return this.piece.toString();
    }
}
