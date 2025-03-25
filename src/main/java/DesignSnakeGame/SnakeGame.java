package DesignSnakeGame;

import java.util.*;

public class SnakeGame {
    private int width;
    private int height;
    private Set<Cell> cells;
    private Deque<Cell> snake;
    private int[][] food;
    private int foodIndex;
    private int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;

        this.cells = new HashSet<>();
        this.cells.add(new Cell(0, 0));

        this.snake = new LinkedList<>();
        this.snake.add(new Cell(0, 0));
    }

    public int move(String direction) {
        if(score == -1){
            return -1;
        }

        Cell currHead = snake.peekFirst();

        Cell newHead = new Cell(currHead);

        if(direction.equals("U")){
            newHead.x = currHead.x-1;
        }else if(direction.equals("D")){
            newHead.x = currHead.x+1;
        }else if(direction.equals("L")){
            newHead.y = currHead.y-1;
        }else if(direction.equals("R")){
            newHead.y = currHead.y+1;
        }else{
            return -1;
        }

        boolean boundaryVoilated = newHead.x < 0 || newHead.x >= height || newHead.y < 0 || newHead.y >= width;

        cells.remove(snake.peekLast());

        boolean snakeBite = cells.contains(newHead);

        if(boundaryVoilated || snakeBite){
            this.score = -1;
            return score;
        }

        this.cells.add(newHead);
        this.snake.offerFirst(newHead);

        boolean foodFound = foodIndex<food.length && (newHead.x == food[foodIndex][0] && newHead.y == food[foodIndex][1]);

        if(foodFound){
            this.cells.add(snake.peekLast());
            foodIndex++;
            score++;
            return score;
        }

        this.snake.pollLast();
        return score;
    }

    static class Cell{
        int x;
        int y;

        public Cell(Cell oldCell){
            this.x = oldCell.x;
            this.y = oldCell.y;
        }

        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x && y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
