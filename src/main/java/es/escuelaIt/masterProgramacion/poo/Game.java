package es.escuelaIt.masterProgramacion.poo;

import es.escuelaIt.masterProgramacion.poo.utils.Console;

public class Game {

    private Board board;

    private Player[] players;

    private int turn;

    private Console console;

    public Game() {
        this.board = new Board();
        this.players = new Player[2];
        this.players[0] = new Player(Color.WHITE);
        this.players[1] = new Player(Color.BLACK);
        this.turn = 0;
        this.console = new Console();
    }

    public void play() {
        this.board.setBoard(this.players);
        do {
            this.board.show();
            this.getCurrentPlayer().move(this.board);
            this.nextTurn();
        } while (!this.isCheckmate());
        this.nextTurn();
        this.console.writeln(this.getCurrentPlayer().toString() + " wins!!!");
    }

    private void nextTurn() {
        this.turn = (this.turn + 1) % 2;
    }

    private Player getCurrentPlayer() {
        return this.players[this.turn];
    }

    private boolean isCheckmate() {
        return this.board.isCheckmate(getCurrentPlayer().getColor());
    }

    public boolean isResumed() {
        String answer = "";
        do {
            answer = this.console.readString("Do you want to play another game (y/n)?");
        } while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n"));
        return answer.equals("y");
    }
}
