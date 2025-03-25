package LoggerRateLimiter;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();

        System.out.println("Print Message :: " + logger.shouldPrintMessage(1, "foo"));

        System.out.println("Print Message :: " + logger.shouldPrintMessage(2, "bar"));

        System.out.println("Print Message :: " + logger.shouldPrintMessage(3, "foo"));

        System.out.println("Print Message :: " + logger.shouldPrintMessage(8, "bar"));

        System.out.println("Print Message :: " + logger.shouldPrintMessage(10, "foo"));

        System.out.println("Print Message :: " + logger.shouldPrintMessage(11, "foo"));
    }
}
