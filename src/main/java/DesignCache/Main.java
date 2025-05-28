package DesignCache;

public class Main {
    public static void main(String[] args) {
//        ICache lruCache = new LRUCache(2);

        ICache cache = new LFUCache(2);

        System.out.println("Key is :: 2  Val is :: "+ cache.get(2));

        cache.put(2, 6);

        System.out.println("Key is :: 1  Val is :: "+ cache.get(1));

        cache.put(1, 5);
        cache.put(1, 2);

        System.out.println("Key is :: 1  Val is :: "+ cache.get(1));
        System.out.println("Key is :: 2  Val is :: "+ cache.get(2));

        cache.put(3, 7);
        System.out.println("Key is :: 3  Val is :: "+ cache.get(3));
        System.out.println("Key is :: 2  Val is :: "+ cache.get(2));
    }
}
