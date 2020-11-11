package es.escuelaIt.masterProgramacion.poo;

public class Bishop extends Piece {

    private final static int WHITE = 9815;

    private final static int BLACK = 9821;

    public Bishop(Color color) {
        super(color, Bishop.WHITE, Bishop.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Square square) {
        if (!origin.inDiagonal(destination))
            return false;
        if (!square.isEmpty() && square.getPiece().getColor() == this.color)
            return false;
        return true;
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
