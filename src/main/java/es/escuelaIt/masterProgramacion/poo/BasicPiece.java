package es.escuelaIt.masterProgramacion.poo;

import java.util.List;

public abstract class BasicPiece implements Piece {
    
    protected Color color;

    protected String symbol;

    public BasicPiece(Color color) {
        this.color = color;
        this.symbol = " ";
    }

    public BasicPiece(Color color, int whiteUnicode, int blackUnicode) {
        this(color);
        int colorUnicode;
        if (this.color == Color.WHITE) {
            colorUnicode = whiteUnicode;
        } else {
            colorUnicode = blackUnicode;
        }
        this.symbol = new String(Character.toChars(colorUnicode));
    }

    public BasicPiece(Color color, String white, String black) {
        this(color);
        String symbol;
        if (this.color == Color.WHITE) {
            symbol = white;
        } else {
            symbol = black;
        }
        this.symbol = symbol;
    }

    @Override
    public abstract boolean isValidMovement(Coordinate origin, Coordinate destination, Square square);

    @Override
    public List<Coordinate> getCoordinates(Coordinate origin, Coordinate destination) {
        return origin.getInBetween(destination);
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.symbol + "_";
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicPiece other = (BasicPiece) obj;
		if (this.color != other.color)
			return false;
		return true;
	}
}
