package es.escuelaIt.masterProgramacion.poo;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Player {

    private Color color;

    public Player(Color color) {
        this.color = color;
    }

	public void move(Board board) {
        assert board != null;
        Console console = new Console();
        boolean isValid = false;
        Coordinate origin = new Coordinate();
        Coordinate destination = new Coordinate();
        console.writeln(this + " moves");
        do {
            origin.read("Choose a piece to move:");
            isValid = board.isFull(origin, this.color);
            if (isValid) {
                destination.read("Choose an square to move:");
                isValid = board.isValidMovement(origin, destination);
            }
            if (!isValid) {
                console.writeln("Invalid movement!");
            }
        } while (!isValid);
        board.move(origin, destination);
    }
    
    public Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return this.color.toString();
    }
}
