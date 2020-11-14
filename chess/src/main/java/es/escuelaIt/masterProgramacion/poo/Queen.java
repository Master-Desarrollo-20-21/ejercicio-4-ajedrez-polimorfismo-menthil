package es.escuelaIt.masterProgramacion.poo;

public class Queen extends Piece {

    private final static int WHITE = 9813;

    private final static int BLACK = 9819;

    public Queen(Color color) {
        super(color, Queen.WHITE, Queen.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        assert movement != null;
        if (movement.inColumn() || movement.inRow() || movement.inDiagonal()) {
            movement.checkPath();
            return true;
        }
        return false;
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
