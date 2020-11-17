package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    
    private Coordinate origin;

    private Coordinate destination;

    private MovementType type;

    private List<Coordinate> path;

    public Movement(Coordinate origin, Coordinate destination, MovementType type) {
        assert origin != null;
        assert destination != null;
        this.origin = origin;
        this.destination = destination;
        this.path = new ArrayList<>();
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
        assert this.origin.inColumn(this.destination) || this.origin.inRow(this.destination) || this.origin.inDiagonal(this.destination);
        this.path = this.origin.getInBetween(this.destination);
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
        return this.path;
	}
}
