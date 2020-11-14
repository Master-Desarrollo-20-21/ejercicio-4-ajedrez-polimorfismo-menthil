package es.escuelaIt.masterProgramacion.poo;

public class Pawn extends Piece {

    private final static int WHITE = 9817;

    private final static int BLACK = 9823;
    
    public Pawn(Color color) {
        super(color, Pawn.WHITE, Pawn.BLACK);
    }

    @Override
    public boolean isValidMovement(Movement movement) {
        assert movement != null;
        return this.isValidColumnMovement(movement) ||
               this.isValidDiagonalMovement(movement);
    }

    private boolean isValidColumnMovement(Movement movement) {
        assert movement != null;
        if (!movement.inColumn()) {
            return false;
        }
        if (!movement.isEmptySquare()) {
            return false;
        }
        int distance = movement.getDistance();
        if (distance > 2 || distance == 0) {
            return false;
        }
        if (distance == 2) {
            movement.checkPath();
            if (this.color == Color.WHITE && movement.getOriginRow() != 1) {
                return false;
            }
            if (this.color == Color.BLACK && movement.getOriginRow() != Coordinate.DIMENSION - 2) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidDiagonalMovement(Movement movement) {
        assert movement != null;
        if (!movement.inDiagonal()) {
            return false;
        }
        if (!movement.isCapture()) {
            return false;
        }
        if (this.color == Color.WHITE) {
            return  movement.getDistance() == 1 && (movement.getOriginRow() + 1) == movement.getDestinationRow();
        } else {
            return  movement.getDistance() == 1 && (movement.getOriginRow() - 1) == movement.getDestinationRow();
        }
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
