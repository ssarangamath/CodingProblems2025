package TimeBasedKVStore;

public class Main {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);

        System.out.println("value is :: " + timeMap.get("foo", 1));

        System.out.println("value is :: " + timeMap.get("foo", 3));

        timeMap.set("foo", "bar2", 4);

        System.out.println("value is :: " +timeMap.get("foo", 4));

        System.out.println("value is :: " +timeMap.get("foo", 5));
    }
}
