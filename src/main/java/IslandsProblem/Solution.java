package IslandsProblem;

public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i<rows; i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    traverse(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void traverse(int i, int j, char[][] grid){
        if(i<0 || j< 0 || i>= grid.length || j>= grid[0].length){
            return;
        }

        if(grid[i][j] != '1')
            return;

        grid[i][j] = '0';

        traverse(i-1, j, grid);
        traverse(i+1, j, grid);
        traverse(i, j-1, grid);
        traverse(i, j+1, grid);
    }
}
