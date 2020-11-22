package es.escuelaIt.masterProgramacion.poo;

public class King extends Piece {

    private final static int WHITE = 9812;

    private final static int BLACK = 9818;

    public King(Color color) {
        super(color, King.WHITE, King.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination) {
        assert origin != null;
        assert destination != null;
        if (origin.getDistance(destination) != 1) {
            return false;
        }
        return origin.inColumn(destination) || origin.inRow(destination) || origin.inDiagonal(destination);
    }

    @Override
    public boolean isKing(Color color) {
        return this.isColor(color);
    }
}
