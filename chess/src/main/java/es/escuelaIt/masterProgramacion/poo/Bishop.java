package es.escuelaIt.masterProgramacion.poo;

public class Bishop extends Piece {

    private final static int WHITE = 9815;

    private final static int BLACK = 9821;

    public Bishop(Color color) {
        super(color, Bishop.WHITE, Bishop.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Movement movement) {
        return origin.inDiagonal(destination);
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
