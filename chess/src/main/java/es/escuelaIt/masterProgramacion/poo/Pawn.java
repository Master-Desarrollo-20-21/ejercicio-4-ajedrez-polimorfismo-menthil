package es.escuelaIt.masterProgramacion.poo;

public class Pawn extends Piece {

    private final static int WHITE = 9817;

    private final static int BLACK = 9823;
    
    public Pawn(Color color) {
        super(color, Pawn.WHITE, Pawn.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination) {
        assert origin != null;
        assert destination != null;
        if (!origin.inColumn(destination)) {
            return false;
        }
        int distance = origin.getDistance(destination);
        if (distance > 2) {
            return false;
        }
        if (distance == 2) {
            if (this.color == Color.WHITE && origin.getRow() != 1) {
                return false;
            }
            if (this.color == Color.BLACK && origin.getRow() != Coordinate.DIMENSION - 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValidCapture(Coordinate origin, Coordinate destination) {
        assert origin != null;
        assert destination != null;
        if (!origin.inDiagonal(destination)) {
            return false;
        }
        if (this.color == Color.WHITE) {
            return origin.getDistance(destination) == 1 && (origin.getRow() + 1) == destination.getRow();
        } else {
            return origin.getDistance(destination) == 1 && (origin.getRow() - 1) == destination.getRow();
        }
    }
}
