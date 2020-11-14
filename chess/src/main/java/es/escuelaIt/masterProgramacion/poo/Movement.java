package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    
    private Coordinate origin;

    private Coordinate destination;

    private MovementType type;

    private boolean checkPath;

    public Movement(Coordinate origin, Coordinate destination) {
        this.origin = origin;
        this.destination = destination;
        this.checkPath = false;
        this.type = MovementType.INVALID;
    }

	public void setType(MovementType type) {
        this.type = type;
	}

	public int getDistance() {
		return this.origin.getDistance(this.destination);
	}

	public boolean inColumn() {
		return this.origin.inColumn(this.destination);
	}

	public boolean inRow() {
		return this.origin.inRow(this.destination);
	}

	public boolean inDiagonal() {
		return this.origin.inDiagonal(this.destination);
	}

	public void checkPath() {
        this.checkPath = true;
	}

	public boolean isEmptySquare() {
		return this.type.equals(MovementType.EMPTY_SQUARE);
	}

	public int getOriginRow() {
		return this.origin.getRow();
	}

	public boolean isCapture() {
		return this.type.equals(MovementType.CAPTURE);
	}

	public int getDestinationRow() {
		return this.destination.getRow();
	}

	public List<Coordinate> getPath() {
        if (this.checkPath) {
            return this.origin.getInBetween(this.destination);
        }
        return new ArrayList<>();
	}
}
