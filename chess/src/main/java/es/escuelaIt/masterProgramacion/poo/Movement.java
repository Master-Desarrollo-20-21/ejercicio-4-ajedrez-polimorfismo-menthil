package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    
    private Coordinate origin;

	private Coordinate destination;
	
	private Board board;

    private MovementType type;

    private List<Coordinate> path;

    public Movement(Coordinate origin, Coordinate destination, Board board) {
        assert origin != null;
        assert destination != null;
        this.origin = origin;
		this.destination = destination;
		this.board = board;
        this.path = new ArrayList<>();
        this.type = this.board.getMovementType(this.origin, this.destination);
    }

	public boolean isValid() {
		if (this.type.equals(MovementType.INVALID)) {
			return false;
		}
		if (!this.board.getPiece(this.origin).isValidMovement(this)) {
			return false;
		}
		return this.board.isEmptyPath(this.getPath());
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
