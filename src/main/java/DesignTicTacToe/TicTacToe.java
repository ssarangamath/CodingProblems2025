package DesignTicTacToe;

public class TicTacToe {

    int[] rows;
    int[] cols;
    int diagonal;
    int antidiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];

        diagonal = 0;
        antidiagonal = 0;
    }

    public int move(int row, int col, int player) {
        int currentplayer = (player == 1) ? 1 : -1;

        rows[row] += currentplayer;
        cols[col] += currentplayer;

        if(row == col){
            diagonal += currentplayer;
        }

        if(col == cols.length-row-1){
            antidiagonal += currentplayer;
        }

        int n = rows.length;

        if(Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                    Math.abs(diagonal) == n ||
                        Math.abs(antidiagonal) == n){
            return player;
        }
        return 0;
    }
}
