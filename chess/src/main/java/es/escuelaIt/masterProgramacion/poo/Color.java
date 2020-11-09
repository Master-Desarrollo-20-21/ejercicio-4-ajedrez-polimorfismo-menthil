package es.escuelaIt.masterProgramacion.poo;

public enum Color {
    
    WHITE,
    BLACK;

    public int getInitialRow() {
        if (this.ordinal() == 0) {
            return 0;
        }
        return Coordinate.DIMENSION - 1;
    }

    public int getIncrement() {
        if (this.ordinal() == 0) {
            return 1;
        }
        return -1;
    }
}
