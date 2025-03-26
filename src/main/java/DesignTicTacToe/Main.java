package DesignTicTacToe;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);

        System.out.println("Move Output is :: " + ticTacToe.move(0, 0, 1));

        System.out.println("Move Output is :: " + ticTacToe.move(0, 2, 2));

        System.out.println("Move Output is :: " + ticTacToe.move(2, 2, 1));

        System.out.println("Move Output is :: " + ticTacToe.move(1, 1, 2));

        System.out.println("Move Output is :: " + ticTacToe.move(2, 0, 1));

        System.out.println("Move Output is :: " + ticTacToe.move(1, 0, 2));

        System.out.println("Move Output is :: " + ticTacToe.move(2, 1, 1));
    }
}
