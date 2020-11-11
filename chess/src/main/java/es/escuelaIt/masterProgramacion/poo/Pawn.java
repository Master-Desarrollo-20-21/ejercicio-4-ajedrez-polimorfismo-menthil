package es.escuelaIt.masterProgramacion.poo;

public class Pawn extends Piece {

    private final static int WHITE = 9817;

    private final static int BLACK = 9823;
    
    public Pawn(Color color) {
        super(color, Pawn.WHITE, Pawn.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Square square) {
        return this.isValidColumnMovement(origin, destination, square) ||
               this.isValidDiagonalMovement(origin, destination, square);
    }

    private boolean isValidDiagonalMovement(Coordinate origin, Coordinate destination, Square square) {
        if (!origin.inDiagonal(destination))
            return false;
        if (square.isEmpty() || square.getPiece().getColor() == this.color)
            return false;
        if (this.color == Color.WHITE) 
            return  origin.getDistance(destination) == 1 && (origin.getRow() + 1) == destination.getRow();
        else 
            return  origin.getDistance(destination) == 1 && (origin.getRow() - 1) == destination.getRow();
    }

    private boolean isValidColumnMovement(Coordinate origin, Coordinate destination, Square square) {
        if (!origin.inColumn(destination))
            return false;
        int distance = origin.getDistance(destination);
        if (distance > 2 || distance == 0)
            return false;
        if (distance == 2) {
            if (this.color == Color.WHITE && origin.getRow() != 1)
                return false;
            if (this.color == Color.BLACK && origin.getRow() != Coordinate.DIMENSION - 2)
                return false;
        }
        return square.isEmpty();
    }
}
