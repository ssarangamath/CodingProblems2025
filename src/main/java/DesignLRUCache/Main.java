package DesignLRUCache;

public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);

        System.out.println("Key is :: 2  Val is :: "+ lruCache.get(2));

        lruCache.put(2, 6);

        System.out.println("Key is :: 1  Val is :: "+ lruCache.get(1));

        lruCache.put(1, 5);
        lruCache.put(1, 2);

        System.out.println("Key is :: 1  Val is :: "+ lruCache.get(1));
        System.out.println("Key is :: 2  Val is :: "+ lruCache.get(2));

    }
}
