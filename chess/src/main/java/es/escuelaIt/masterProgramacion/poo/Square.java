package es.escuelaIt.masterProgramacion.poo;

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

	public boolean isEmpty() {
		return this.piece == null;
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
