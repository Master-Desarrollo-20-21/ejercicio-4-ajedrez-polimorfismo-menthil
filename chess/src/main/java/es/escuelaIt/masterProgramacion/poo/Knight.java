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
    public boolean isValidMovement(Coordinate origin, Coordinate destination, Movement movement) {
        if (origin.inColumn(destination) || origin.inRow(destination) || origin.inDiagonal(destination)) {
            return false;
        }
        return origin.getDistance(destination) == 3;
    }

    @Override
    public List<Coordinate> getCoordinates(Coordinate origin, Coordinate destination) {
        return new ArrayList<>();
    }

    @Override
    public boolean isKing(Color color) {
        return false;
    }
}
