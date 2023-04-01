package tictactoe;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface(new Scanner(System.in));
        char[][] initialBoard = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        Board board = new Board(initialBoard);
        ui.play(board);

    }
}
