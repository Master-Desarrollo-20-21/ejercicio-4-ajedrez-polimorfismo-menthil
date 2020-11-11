package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    private final static int WHITE = 9812;

    private final static int BLACK = 9818;

    public King(Color color) {
        super(color, King.WHITE, King.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Square square) {
        if (!origin.inColumn(destination) && !origin.inRow(destination) && !origin.inDiagonal(destination))
            return false;
        if (origin.getDistance(destination) != 1)
            return false;
        if (!square.isEmpty() && square.getPiece().getColor() == this.color)
            return false;
        return true;
    }

    @Override
    public List<Coordinate> getCoordinates(Coordinate origin, Coordinate destination) {
        return new ArrayList<>();
    }

}
