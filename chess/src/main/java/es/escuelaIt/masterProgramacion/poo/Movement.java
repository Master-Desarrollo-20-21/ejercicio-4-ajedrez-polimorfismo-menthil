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
		assert board != null;
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
		Piece piece = this.board.getPiece(this.origin);
		boolean isValid;
		if (this.type.equals(MovementType.CAPTURE)) {
			isValid = piece.isValidCapture(this.origin, this.destination);
		} else {
			isValid = piece.isValidMovement(this.origin, this.destination);
		}
		if (isValid) {
			if (piece.checkPath()) {
				this.path = this.origin.getInBetween(this.destination); 
			}
			return this.board.isEmptyPath(this.path);
		}
		return false;
	}
}
