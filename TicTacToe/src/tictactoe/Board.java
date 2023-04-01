package tictactoe;

public class Board {

    private char[][] board;

    public Board(char[][] initialBoard) {
        this.board = initialBoard;
    }

    public char[][] getBoard() {
        return this.board;
    }

    public boolean isAvailable(int[] coords) {
        return this.board[coords[0]][coords[1]] == ' ';
    }

    public void setIcon(int[] coords, char icon) {
        this.board[coords[0]][coords[1]] = icon;
    }

    public boolean hasEmptyCells() {
        StringBuilder plays = new StringBuilder();
        for (char[] row : this.board) {
            for (char col : row) {
                plays.append(col);
            }
        }
        return plays.toString().contains(" ");
    }

    public void draw() {
        System.out.println("---------");
        for (char[] row : this.board) {
            System.out.print("| ");
            for (char column : row) {
                System.out.print(column + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

}
