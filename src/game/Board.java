package game;

import game.exceptions.EndOfGameException;

import java.util.*;

public class Board {

    private static final int BOARD_SIZE = 4;

    private int[][] board;
    private final Set<Direction> possibleMoves;
    private int freeFields;
    private static final Random random = new Random();

    private Board() {
        board = new int[BOARD_SIZE][BOARD_SIZE];
        possibleMoves = new HashSet<>(4);
        freeFields = 16;
        addNumber();
    }

    public static Board create() {
        return new Board();
    }

    private void addNumber() {
        if (freeFields <= 0) {
            throw new EndOfGameException();
        }
        int tempRow = random.nextInt(BOARD_SIZE + 1);
        int tempColumn = random.nextInt(BOARD_SIZE + 1);
        board[tempRow][tempColumn] = random.nextBoolean() ? 2 : 4;
        ++freeFields;
        setPossibleMoves();
    }

    private void setPossibleMoves() {

    }

    public boolean move(Direction direction) {
        if (isMovePossible(direction)) {

            addNumber();
        }
        return false;
    }

    private boolean isMovePossible(Direction direction) {
        switch (direction) {
            case UP:
                isSideFree(Direction.UP);
        }
        return false;
    }


    private boolean isSideFree(Direction direction) {
        switch (direction) {
            case UP:
                return isRowFree(0);
            case DOWN:
                return isRowFree(BOARD_SIZE - 1);
            case LEFT:
                return isColumnFree(0);
            case RIGHT:
                return isColumnFree(BOARD_SIZE - 1);
            default:
                return false;

        }
    }
    private boolean isRowFree(int row) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[row][i] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isColumnFree(int column) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (board[i][column] != 0) {
                return false;
            }
        }
        return true;
    }

    enum LineType {
        COLUMN, ROW;
    }
}
