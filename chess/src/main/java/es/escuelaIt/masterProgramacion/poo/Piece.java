package es.escuelaIt.masterProgramacion.poo;


public abstract class Piece {
    
    protected Color color;

    protected String symbol;

    public Piece(Color color, int whiteUnicode, int blackUnicode) {
        this.color = color;
        int colorUnicode;
        if (this.color == Color.WHITE) {
            colorUnicode = whiteUnicode;
        } else {
            colorUnicode = blackUnicode;
        }
        this.symbol = new String(Character.toChars(colorUnicode));
    }

	public boolean isColor(Color color) {
		return this.color.equals(color);
    }

    public boolean isColor(Piece piece) {
        assert piece != null;
        return this.isColor(piece.color);
    }

    public abstract boolean isValidMovement(Coordinate origin, Coordinate destination);

    public boolean isValidCapture(Coordinate origin, Coordinate destination) {
        assert origin != null;
        assert destination != null;
        return this.isValidMovement(origin, destination);
    }

    public boolean checkPath() {
        return true;
    }
    
    public boolean isKing(Color color) {
        return false;
    }

    @Override
    public String toString() {
        return this.symbol + "_";
    }
}
