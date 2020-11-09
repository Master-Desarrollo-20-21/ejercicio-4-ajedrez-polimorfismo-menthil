package es.escuelaIt.masterProgramacion.poo;

public class Chess {

    private void play() {
        Game game = new Game();
        do {
            game.play();
        } while (game.isResumed());
    }

    public static void main(String[] args) {
        new Chess().play();
    }
}
