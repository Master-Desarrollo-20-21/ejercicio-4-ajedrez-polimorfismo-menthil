package es.escuelaIt.masterProgramacion.poo;

public class Queen extends Piece {

    private final static int WHITE = 9813;

    private final static int BLACK = 9819;

    public Queen(Color color) {
        super(color, Queen.WHITE, Queen.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        movement.checkPath();
        return movement.inColumn() || movement.inRow() || movement.inDiagonal();
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
