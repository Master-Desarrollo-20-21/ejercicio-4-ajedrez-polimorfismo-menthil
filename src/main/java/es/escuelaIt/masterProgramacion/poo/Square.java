package es.escuelaIt.masterProgramacion.poo;

public class Square {

    public final static String DARK = "::";

    public final static String LIGHT = "  ";

    private Piece piece;

    private String color;

    public Square(String color) {
        this.color = color;
        this.piece = null;
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
