package es.escuelaIt.masterProgramacion.poo;

public class Rook extends Piece {

    private final static int WHITE = 9814;

    private final static int BLACK = 9820;

    public Rook(Color color) {
        super(color, Rook.WHITE, Rook.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Square square) {
        if (!origin.inColumn(destination) && !origin.inRow(destination))
            return false;
        if (!square.isEmpty() && square.getPiece().getColor() == this.color)
            return false;
        return true;
    }
}
