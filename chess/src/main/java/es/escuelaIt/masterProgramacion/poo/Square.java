package es.escuelaIt.masterProgramacion.poo;

import java.util.List;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Square {

    public final static String DARK = "::";

    public final static String LIGHT = "  ";

    private Piece piece;

    private String background;

    private Coordinate coordinate;

    public Square(Coordinate coordinate) {
        assert coordinate != null;
        this.piece = null;
        this.coordinate = coordinate;
        if ((this.coordinate.getRow() + this.coordinate.getColumn()) % 2 == 0) {
            this.background = Square.DARK;
        } else {
            this.background = Square.LIGHT;
        }
    }

    public boolean isFull(Color color) {
        Console console = new Console();
        if (this.isEmpty()) {
            console.writeln("There is no piece in this square");
            return false;
        }
        if (!this.piece.isColor(color)) {
            console.writeln("This piece is not yours!");
            return false;
        }
        return true;
    }

	public boolean isEmpty() {
		return this.piece == null;
    }
    
    public boolean isValidMovement(Square square) {
        assert square != null;
        Movement movement = null;
        if (square.isEmpty()) {
            movement = this.createEmptyMovement(square);
        } else {
            if (!square.piece.isColor(this.piece)) {
                movement = this.createCaptureMovement(square);
            } else {
                return false;
            }
        }
        return this.piece.isValidMovement(movement);
    }

    private Movement createEmptyMovement(Square square) {
        assert square != null;
        assert square.isEmpty();
        return this.createMovement(square, MovementType.EMPTY_SQUARE);
    }

    private Movement createCaptureMovement(Square square) {
        assert square != null;
        assert !square.piece.isColor(this.piece);
        return this.createMovement(square, MovementType.CAPTURE);
    }

    private Movement createMovement(Square square, MovementType movementType) {
        assert square != null;
        return new Movement(this.getCoordinate(), square.getCoordinate(), movementType);
    }
    
    private Movement createMovement(Square square) {
        assert square != null;
        assert square.isEmpty() || !square.piece.isColor(this.piece);
        if (square.isEmpty()) {
            return this.createEmptyMovement(square);
        }
        return this.createCaptureMovement(square);
    }

	public List<Coordinate> getPath(Square square) {
        assert square != null;
        assert this.isValidMovement(square);
        return this.createMovement(square).getPath();
    }

    public void move(Square square) {
        assert square != null;
        square.piece = this.piece;
        this.piece = null;
    }

	public boolean isKing(Color color) {
        if (!this.isEmpty()) {
            return this.piece.isKing(color);
        }
		return false;
    }
    
    private Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return this.background;
        return this.piece.toString();
    }
}
