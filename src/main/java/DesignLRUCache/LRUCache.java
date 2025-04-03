package DesignLRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, Node> map;
    Node dllHead;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        initialiseDll();
        this.capacity = capacity;
    }

    /**
     * If Map Contains Key
     *     1. Get Node from map
     *     2. remove from DLL
     *     3. Add to First
     *
     * If Map Does not contain key
     *     return -1;
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        removeFromLL(node);
        addToFirst(node);
        return node.data;
    }

    /**
     * If(capacity is reached)
     *     remove last node from dll
     *
     * If Key does not exist in map
     *     1. Insert Key and new node into map
     *     2. add new node to front of dll
     *
     * If Key exsits in map
     *    1. Get the node from map
     *    2. update the value
     *    3. remove node from dll
     *    4. add node to front of dll
     *
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            node.data = value;

            removeFromLL(node);
        }else {
            if(map.size() != 0 && map.size() == this.capacity){
                if(tail.prev != null && tail.prev != dllHead){
                    map.remove(tail.prev.key);
                    removeFromLL(tail.prev);
                }
            }

            node = new Node(value, key);
        }
        addToFirst(node);
        map.put(key, node);
    }

    private void addToFirst(Node node){
        Node next = dllHead.next;

        dllHead.next = node;
        node.prev = dllHead;

        node.next = next;
        next.prev = node;
    }

    private void removeFromLL(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
    }

    private void initialiseDll(){
        dllHead = new Node(-1, -1);

        tail = new Node(-1, -1);

        dllHead.next = tail;
        tail.prev = dllHead;
    }

    static class Node{
        Node prev;
        Node next;
        int data;
        int key;

        Node(int data, int key){
            this.data = data;
            this.prev = null;
            this.next = null;
            this.key = key;
        }
    }
}
