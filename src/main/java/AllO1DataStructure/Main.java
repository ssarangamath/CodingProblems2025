package AllO1DataStructure;

public class Main {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        allOne.inc("hello");

        allOne.inc("hello");

        System.out.println(allOne.getMaxKey());

        System.out.println(allOne.getMinKey());

        allOne.dec("hello");

        allOne.inc("leet");
        allOne.inc("leet");

        System.out.println(allOne.getMaxKey());

        System.out.println(allOne.getMinKey());
    }
}
