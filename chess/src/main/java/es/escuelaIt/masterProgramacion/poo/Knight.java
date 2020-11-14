package es.escuelaIt.masterProgramacion.poo;

public class Knight extends Piece {

    private final static int WHITE = 9816;

    private final static int BLACK = 9822;

    public Knight(Color color) {
        super(color, Knight.WHITE, Knight.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        assert movement != null;
        if (movement.inColumn() || movement.inRow() || movement.inDiagonal()) {
            return false;
        }
        return movement.getDistance() == 3;
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
