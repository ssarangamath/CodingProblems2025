package DesignCache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache implements ICache{
    private int capacity;
    private Map<Integer, Node> map;
    private PriorityQueue<Node> nodes;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
        this.nodes = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.count - n2.count;
            }
        });
    }

    /**
     * If Map Contains Key
     *     1. Get Node from map
     *     2. Update Count
     *     3. Remove and Add to PQ
     *
     * If Map Does not contain key
     *     return -1;
     *
     * @param key
     * @return
     */
    @Override
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        this.nodes.remove(node);

        node.count = node.count+1;
        this.nodes.add(node);

        return node.data;
    }

    @Override
    public void put(int key, int value) {
        Node node;
        if(map.containsKey(key)){
            node = map.get(key);
            this.nodes.remove(node);

            node.data = value;
            node.count = node.count+1;
            this.nodes.offer(node);
        }else {
            if(this.capacity == map.size()){
                Node nodeRemoved = this.nodes.poll();
                this.map.remove(nodeRemoved.key);
            }

            node = new Node(key, value);
            this.nodes.offer(node);
        }

        map.put(key, node);
    }

    static class Node{
        int data;
        Node prev;
        Node next;
        int key;
        int count;

        public Node(int k, int v){
            this.key = k;
            this.data = v;
            this.prev = null;
            this.next = null;
            this.count = 0;
        }
    }
}
