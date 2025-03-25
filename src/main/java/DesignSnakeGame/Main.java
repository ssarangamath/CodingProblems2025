package DesignSnakeGame;

public class Main {
    public static void main(String[] args) {

        int[][] food = {{1,2},{0,1}};

        SnakeGame snakeGame = new SnakeGame(3, 2, food);

        System.out.println("Score is :: "+snakeGame.move("R"));

        System.out.println("Score is :: "+snakeGame.move("D"));

        System.out.println("Score is :: "+snakeGame.move("R"));

        System.out.println("Score is :: "+snakeGame.move("U"));

        System.out.println("Score is :: "+snakeGame.move("L"));

        System.out.println("Score is :: "+snakeGame.move("U"));
    }
}
