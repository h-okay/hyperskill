package tictactoe;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;
    private char turn;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.turn = 'X';
    }

    public void passTurn() {
        if (this.turn == 'X') {
            this.turn = 'O';
            return;
        }
        this.turn = 'X';
    }

    public void play(Board board) {

        int[] coords = new int[2];

        while (true) {

            board.draw();
            String input = this.scanner.nextLine();

            try {

                coords[0] = Integer.parseInt(input.split(" ")[0]) - 1;
                coords[1] = Integer.parseInt(input.split(" ")[1]) - 1;

                if (!board.isAvailable(coords)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }

                board.setIcon(coords, this.turn);
                if (Logic.checkAll(board, this.turn)) {
                    board.draw();
                    System.out.printf("%s wins", this.turn);
                    break;
                }

                if (!board.hasEmptyCells()) {
                    System.out.printf("Draw%n");
                }

                passTurn();

            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }

}
