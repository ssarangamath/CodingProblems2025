package DesignHitCounter;

public class Main {
    public static void main(String[] args) {
        HitCounter counter = new HitCounter();

        counter.hit(1);
        counter.hit(2);
        counter.hit(3);

        System.out.println("Number of Hits :: "+ counter.getHits(4));

        counter.hit(300);

        System.out.println("Number of Hits :: "+ counter.getHits(300));

        System.out.println("Number of Hits :: "+ counter.getHits(301));
    }
}
