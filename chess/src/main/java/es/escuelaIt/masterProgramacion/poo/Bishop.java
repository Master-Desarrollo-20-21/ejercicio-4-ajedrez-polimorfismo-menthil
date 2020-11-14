package es.escuelaIt.masterProgramacion.poo;

public class Bishop extends Piece {

    private final static int WHITE = 9815;

    private final static int BLACK = 9821;

    public Bishop(Color color) {
        super(color, Bishop.WHITE, Bishop.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        movement.checkPath();
        return movement.inDiagonal();
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
