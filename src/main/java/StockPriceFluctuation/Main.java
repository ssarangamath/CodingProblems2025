package StockPriceFluctuation;

public class Main {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();

        stockPrice.update(1, 10);
        stockPrice.update(2, 5);

        System.out.println("Latest Stock Price Value is :: "+ stockPrice.current());

        System.out.println("Max and Min Stock Price Values are :: "+ stockPrice.maximum() + " "+ stockPrice.minimum());

        stockPrice.update(1,3 );

        System.out.println("Max and Min Stock Price Values are :: "+ stockPrice.maximum() + " "+ stockPrice.minimum());
    }
}
