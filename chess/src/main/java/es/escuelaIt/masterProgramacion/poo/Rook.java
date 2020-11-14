package es.escuelaIt.masterProgramacion.poo;

public class Rook extends Piece {

    private final static int WHITE = 9814;

    private final static int BLACK = 9820;

    public Rook(Color color) {
        super(color, Rook.WHITE, Rook.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        movement.checkPath();
        return movement.inColumn() || movement.inRow();
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
