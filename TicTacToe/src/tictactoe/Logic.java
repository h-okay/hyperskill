package tictactoe;

public class Logic {

    public static boolean checkRows(Board board, char icon) {
        for (char[] row : board.getBoard()) {
            if (row[0] == icon && row[1] == icon && row[2] == icon) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumns(Board board, char icon) {
        char[][] current = board.getBoard();
        for (int i = 0; i < 3; i++) {
            if (current[0][i] == icon && current[1][i] == icon && current[2][i] == icon) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(Board board, char icon) {
        char[][] current = board.getBoard();
        if ((current[0][0] == icon && current[1][1] == icon && current[2][2] == icon) ||
                (current[0][2] == icon && current[1][1] == icon && current[2][0] == icon)) {
            return true;
        }
        return false;
    }

    public static boolean checkAll(Board board, char icon) {
        return checkRows(board, icon) || checkColumns(board, icon) || checkDiagonal(board, icon);
    }

    public static boolean isPossible(Board board) {
        int xCount = 0;
        int oCount = 0;
        for (char[] row : board.getBoard()) {
            for (char col : row) {
                if (col == 'X') {
                    xCount++;
                }
                if (col == 'O') {
                    oCount++;
                }
            }
        }
        if (Math.abs(xCount - oCount) >= 2) {
            return false;
        }
        return true;
    }
}
