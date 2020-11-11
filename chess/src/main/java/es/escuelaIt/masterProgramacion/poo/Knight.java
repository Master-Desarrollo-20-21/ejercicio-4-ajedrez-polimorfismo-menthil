package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    private final static int WHITE = 9816;

    private final static int BLACK = 9822;

    public Knight(Color color) {
        super(color, Knight.WHITE, Knight.BLACK);
    }

    @Override
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Square square) {
        if (origin.inColumn(destination) || origin.inRow(destination) || origin.inDiagonal(destination))
            return false;
        if (origin.getDistance(destination) != 3)
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
