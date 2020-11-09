package es.escuelaIt.masterProgramacion.poo;

import java.util.List;

public interface Piece {

	public Color getColor();

	public boolean isValidMovement(Coordinate origin, Coordinate destination, Square square);

	public List<Coordinate> getCoordinates(Coordinate origin, Coordinate destination);

}
