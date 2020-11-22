package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    
    private Square origin;

    private Square destination;

    private MovementType type;

    private List<Coordinate> path;

    public Movement(Square origin, Square destination) {
        assert origin != null;
        assert destination != null;
        this.origin = origin;
        this.destination = destination;
        this.path = new ArrayList<>();
        this.type = this.origin.getMovementType(this.destination);
    }

	public boolean isValid() {
		if (this.type.equals(MovementType.INVALID)) {
			return false;
		}
		return this.origin.getPiece().isValidMovement(this);
	}

	public int getDistance() {
		return this.origin.getCoordinate().getDistance(this.destination.getCoordinate());
	}

	public boolean inColumn() {
		return this.origin.getCoordinate().inColumn(this.destination.getCoordinate());
	}

	public boolean inRow() {
		return this.origin.getCoordinate().inRow(this.destination.getCoordinate());
	}

	public boolean inDiagonal() {
		return this.origin.getCoordinate().inDiagonal(this.destination.getCoordinate());
	}

	public void checkPath() {
        assert this.origin.getCoordinate().inColumn(this.destination.getCoordinate()) || this.origin.getCoordinate().inRow(this.destination.getCoordinate()) || this.origin.getCoordinate().inDiagonal(this.destination.getCoordinate());
        this.path = this.origin.getCoordinate().getInBetween(this.destination.getCoordinate());
	}

	public boolean isEmptySquare() {
		return this.type.equals(MovementType.EMPTY_SQUARE);
	}

	public int getOriginRow() {
		return this.origin.getCoordinate().getRow();
	}

	public boolean isCapture() {
		return this.type.equals(MovementType.CAPTURE);
	}

	public int getDestinationRow() {
		return this.destination.getCoordinate().getRow();
	}

	public List<Coordinate> getPath() {
        return this.path;
	}
}
