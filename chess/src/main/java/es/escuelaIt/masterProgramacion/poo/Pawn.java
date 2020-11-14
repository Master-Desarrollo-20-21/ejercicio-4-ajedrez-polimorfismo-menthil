package es.escuelaIt.masterProgramacion.poo;

public class Pawn extends Piece {

    private final static int WHITE = 9817;

    private final static int BLACK = 9823;
    
    public Pawn(Color color) {
        super(color, Pawn.WHITE, Pawn.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Movement movement) {
        return this.isValidColumnMovement(origin, destination, movement) ||
               this.isValidDiagonalMovement(origin, destination, movement);
    }

    private boolean isValidColumnMovement(Coordinate origin, Coordinate destination, Movement movement) {
        if (!origin.inColumn(destination)) {
            return false;
        }
        if (!movement.equals(Movement.EMPTY_SQUARE)) {
            return false;
        }
        int distance = origin.getDistance(destination);
        if (distance > 2 || distance == 0) {
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

    private boolean isValidDiagonalMovement(Coordinate origin, Coordinate destination, Movement movement) {
        if (!origin.inDiagonal(destination)) {
            return false;
        }
        if (!movement.equals(Movement.CAPTURE)) {
            return false;
        }
        if (this.color == Color.WHITE) {
            return  origin.getDistance(destination) == 1 && (origin.getRow() + 1) == destination.getRow();
        } else {
            return  origin.getDistance(destination) == 1 && (origin.getRow() - 1) == destination.getRow();
        }
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
