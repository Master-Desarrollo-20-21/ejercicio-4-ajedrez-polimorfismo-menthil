package es.escuelaIt.masterProgramacion.poo;

public class King extends Piece {

    private final static int WHITE = 9812;

    private final static int BLACK = 9818;

    public King(Color color) {
        super(color, King.WHITE, King.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        if (movement.getDistance() != 1) {
            return false;
        }
        return movement.inColumn() || movement.inRow() || movement.inDiagonal();
    }

    @Override
    public boolean isKing(Color color) {
        return this.color == color;
    }

}
