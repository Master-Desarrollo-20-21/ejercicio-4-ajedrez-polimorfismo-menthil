package es.escuelaIt.masterProgramacion.poo;

public class Knight extends Piece {

    private final static int WHITE = 9816;

    private final static int BLACK = 9822;

    public Knight(Color color) {
        super(color, Knight.WHITE, Knight.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination) {
        assert origin != null;
        assert destination != null;
        if (origin.inColumn(destination) || origin.inRow(destination) || origin.inDiagonal(destination)) {
            return false;
        }
        return origin.getDistance(destination) == 3;
    }

    @Override
    public boolean checkPath() {
        return false;
    }
}
