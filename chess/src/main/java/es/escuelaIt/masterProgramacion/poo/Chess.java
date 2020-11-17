package es.escuelaIt.masterProgramacion.poo;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Chess {

    private Board board;

    private Player[] players;

    private int turn;

    public Chess() {
        this.players = new Player[2];
        for (Color color : Color.values()) {
            this.players[color.ordinal()] = new Player(color);
        }
        this.turn = 0;
    }

    private void play() {
        Console console = new Console();
        do {
            this.board = new Board();
            do {
                this.board.show();
                this.getCurrentPlayer().move(this.board);
                this.nextTurn();
            } while (!this.isCheckmate());
            this.nextTurn();
            console.writeln(this.getCurrentPlayer().toString() + " wins!!!");
        } while (this.isResumed());
    }

    private Player getCurrentPlayer() {
        return this.players[this.turn];
    }

    private void nextTurn() {
        this.turn = (this.turn + 1) % 2;
    }

    private boolean isCheckmate() {
        return this.board.isCheckmate(this.getCurrentPlayer().getColor());
    }

    public boolean isResumed() {
        String answer = "";
        Console console = new Console();
        do {
            answer = console.readString("Do you want to play another game (y/n)?");
        } while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n"));
        return answer.equals("y");
    }

    public static void main(String[] args) {
        new Chess().play();
    }
}
