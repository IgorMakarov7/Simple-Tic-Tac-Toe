package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[][] field = new char[3][3];
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int temp = 0;
        while (true) {
            temp++;
            if (temp == 8)
                System.out.println();
            drawField(field);
            char winner = checkWhoWin(field);
            if (winner == 'X' || winner == 'O') {
                System.out.println(winner + " wins");
                break;
            } else if (winner == 'D') {
                System.out.println("Draw");
                break;
            };
            String coordinate = scanner.nextLine();
            int x;
            int y;
            try {
                x = Integer.parseInt(String.valueOf(coordinate.charAt(0)));
                y = Integer.parseInt(String.valueOf(coordinate.charAt(2)));
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (x <= 3 && y <= 3) {
                if (field[x - 1][y - 1] != 'X' && field[x - 1][y - 1] != 'O') {
                    field[x - 1][y - 1] = counter % 2 == 0 ? 'X' : 'O';
                    counter++;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }

    public static void drawField(char[][] field) {
        System.out.println("---------");
        int counter = 0;
        int indexOfArrays = 0;
        int indexOfChars = 0;
        for (int i = 0; i < 9; i++) {
            if (counter == 0) {
                System.out.print("| ");
                counter++;
            }
            if (field[indexOfArrays][indexOfChars] == 'X' || field[indexOfArrays][indexOfChars] == 'O')
                System.out.print(field[indexOfArrays][indexOfChars] + " ");
            else System.out.print("  ");
            if ((i + 1) % 3 == 0) {
                System.out.print("|\n");
                counter = 0;
            }
            indexOfChars++;
            if (indexOfChars == 3) {
                indexOfChars = 0;
                indexOfArrays++;
                if (indexOfArrays == 3) {
                    indexOfArrays = 0;
                }
            }
        }
        System.out.println("---------");
    }

    public static char checkWhoWin(char[][] field) {
        for (char[] chars : field) {
            if (chars[0] == chars[1] && chars[1] == chars[2])
                if (chars[0] == 'X' || chars[0] == 'O')
                    return chars[0];
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i] == field[1][i] && field[1][i] == field[2][i])
                if (field[0][i] == 'X' || field[0][i] == 'O')
                    return field[0][i];
        }

        if (field[0][0] == field[1][1] && field[1][1] == field[2][2])
            if (field[0][0] == 'X' || field[0][0] == 'O')
                return field[0][0];
        if (field[0][2] == field[1][1] && field[1][1] == field[2][0])
            if (field[0][2] == 'X' || field[0][2] == 'O')
                return field[0][2];
        int counter = 0;
        for (char[] chars : field) {
            for (char c : chars) {
                if (c == 'X' || c == 'O')
                    counter++;
            }
            if (counter >= 9)
                return 'D';
        }
        return '_';
    }
}
