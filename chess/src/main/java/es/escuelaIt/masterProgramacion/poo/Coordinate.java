package es.escuelaIt.masterProgramacion.poo;

import java.util.ArrayList;
import java.util.List;

import es.escuelaIt.masterProgramacion.poo.utils.Console;
import es.escuelaIt.masterProgramacion.poo.utils.LimitedIntDialog;

public class Coordinate {

    private int row;

    private int column;

	public final static int DIMENSION = 8;

    public Coordinate() {
        this(0, 0);
    }

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }
	
	public boolean inRow(Coordinate coordinate){
		return this.row == coordinate.row;
	}
	
	public boolean inColumn(Coordinate coordinate){
		return this.column == coordinate.column;
	}
	
	public boolean inDiagonal(Coordinate coordinate){
        return  this.row - this.column == coordinate.row - coordinate.column ||
                this.row + this.column == coordinate.row + coordinate.column;
    }
    
    public int getDistance(Coordinate coordinate) {
        if (this.inDiagonal(coordinate)) {
            return Math.abs(this.getRow() - coordinate.getRow());
        }
        return Math.abs(this.getRow() - coordinate.getRow()) + Math.abs(this.getColumn() - coordinate.getColumn());
    }

    public List<Coordinate> getInBetween(Coordinate coordinate) {
        assert this.inColumn(coordinate) || this.inRow(coordinate) || this.inDiagonal(coordinate);
        if (this.inColumn(coordinate)) {
            return this.getInBetweenInColumn(coordinate);
        }
        if (this.inRow(coordinate)) {
            return this.getInBetweenInRow(coordinate);
        } else {
            return this.getInBetweenInDiagonal(coordinate);
        }
    }

    private List<Coordinate> getInBetweenInDiagonal(Coordinate coordinate) {
        assert this.inDiagonal(coordinate);
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate from;
        Coordinate to;
        if (this.getRow() > coordinate.getRow()) {
            from = coordinate;
            to = this;
        } else {
            from = this;
            to = coordinate;
        }
        for (int i = 1; i < to.getRow() - from.getRow(); i++) {
            int column = from.getColumn();
            if (from.getColumn() > to.getColumn()) {
                column -= i;
            } else {
                column += i;
            }
            coordinates.add(new Coordinate(i + from.getRow(), column));
        }
        return coordinates;
    }

    private List<Coordinate> getInBetweenInRow(Coordinate coordinate) {
        assert this.inRow(coordinate);
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate from;
        Coordinate to;
        if (this.getColumn() > coordinate.getColumn()) {
            from = coordinate;
            to = this;
        } else {
            from = this;
            to = coordinate;
        }
        for (int i = 1; i < to.getColumn() - from.getColumn(); i++) {
            coordinates.add(new Coordinate(this.getRow(), i + from.getColumn()));
        }
        return coordinates;
    }

    private List<Coordinate> getInBetweenInColumn(Coordinate coordinate) {
        assert this.inColumn(coordinate);
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate from;
        Coordinate to;
        if (this.getRow() > coordinate.getRow()) {
            from = coordinate;
            to = this;
        } else {
            from = this;
            to = coordinate;
        }
        for (int i = 1; i < to.getRow() - from.getRow(); i++) {
            coordinates.add(new Coordinate(i + from.getRow(), this.getColumn()));
        }
        return coordinates;
    }

    public void read(String title) {
        Console console = new Console();
        console.writeln(title);
        this.setRow(new LimitedIntDialog("Row?", Coordinate.DIMENSION).read() - 1);
        this.setColumn(new LimitedIntDialog("Column?", Coordinate.DIMENSION).read() - 1);
    }

    private void setColumn(int column) {
        this.column = column;
    }

    private void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (this.column != other.column)
			return false;
		if (this.row != other.row)
			return false;
		return true;
	}
}
