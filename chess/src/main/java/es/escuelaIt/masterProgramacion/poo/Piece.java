package es.escuelaIt.masterProgramacion.poo;


public abstract class Piece {
    
    protected Color color;

    protected String symbol;

    public Piece(Color color) {
        this.color = color;
        this.symbol = " ";
    }

    public Piece(Color color, int whiteUnicode, int blackUnicode) {
        this(color);
        int colorUnicode;
        if (this.color == Color.WHITE) {
            colorUnicode = whiteUnicode;
        } else {
            colorUnicode = blackUnicode;
        }
        this.symbol = new String(Character.toChars(colorUnicode));
    }

    public Piece(Color color, String white, String black) {
        this(color);
        String symbol;
        if (this.color == Color.WHITE) {
            symbol = white;
        } else {
            symbol = black;
        }
        this.symbol = symbol;
    }

	public boolean isColor(Color color) {
		return this.color == color;
    }

    public abstract boolean isValidMovement(Movement movement);
    
    public abstract boolean isKing(Color color);

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
		Piece other = (Piece) obj;
		if (this.color != other.color)
			return false;
		return true;
	}
}
