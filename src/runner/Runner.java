package runner;

import game.Board;
import static game.Direction.*;

public final class Runner {

    private final Board board;

    public Runner() {
        board = Board.create();
    }


    public void play() {
        System.out.println("I want to play!");

        board.move(DOWN);
    }

    private static void addNumberToTheBoard() {
    }

}
