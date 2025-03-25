package AllO1DataStructure;

import java.util.*;

public class AllOne {
    Map<String, Integer> keyCounts;
    Map<Integer, Node> freqNodeMap;

    Node head;
    Node tail;

    public AllOne() {
        keyCounts = new HashMap<>();
        freqNodeMap = new HashMap<>();

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        if(keyCounts.containsKey(key)){
            // Scenario of Key with prev Freq exists

            // Get Old Freq
            int oldFreq = keyCounts.get(key);

            // Get Old Freq Node
            Node node = freqNodeMap.get(oldFreq);

            // Remove Key From Old Node
            node.keys.remove(key);

            //Check If new Freq Node exists
            int newFreq = oldFreq+1;

            Node newNode = null;

            if(freqNodeMap.containsKey(newFreq)){
                newNode = freqNodeMap.get(newFreq);
            }else{
                newNode = new Node();

                // Add New Node to right of old Node
                addToRight(node, newNode);
            }

            if(node.keys.size() == 0){
                freqNodeMap.remove(oldFreq);
                removeNode(node);
            }

            newNode.keys.add(key);
            freqNodeMap.put(newFreq, newNode);

            keyCounts.put(key, newFreq);
        }
        else {
            // Scenario of Key with Freq 1 Needs to be added
            Node firstNode;
            if(freqNodeMap.containsKey(1)){
                firstNode = freqNodeMap.get(1);
            }
            else {
                firstNode = new Node();
                addToRight(head, firstNode);
            }

            firstNode.keys.add(key);
            freqNodeMap.put(1, firstNode);

            keyCounts.put(key, 1);
        }
    }

    public void dec(String key) {
        if(!keyCounts.containsKey(key))
            return;

        int oldFreq = keyCounts.get(key);

        Node node = freqNodeMap.get(oldFreq);
        node.keys.remove(key);

        int newFreq = oldFreq-1;
        if(newFreq == 0){
            if(node.keys.size() == 0){
                freqNodeMap.remove(oldFreq);
                removeNode(node);
            }

            keyCounts.remove(key);
            return;
        }

        Node newNode = null;
        if(freqNodeMap.containsKey(newFreq)){
            newNode = freqNodeMap.get(newFreq);
        }else{
            newNode = new Node();
            addToLeft(node, newNode);
        }

        if(node.keys.size() == 0){
            freqNodeMap.remove(oldFreq);
            removeNode(node);
        }

        newNode.keys.add(key);
        freqNodeMap.put(newFreq, newNode);
        keyCounts.put(key, newFreq);
    }

    public String getMaxKey() {
       Node node = tail.prev;

       if(Objects.isNull(node) || node.keys.size() == 0)
           return "";

       return node.keys.get(0);
    }

    public String getMinKey() {
        Node node = head.next;

        if(Objects.isNull(node) || node.keys.size() == 0)
            return "";

        return node.keys.get(0);
    }

    private void removeNode(Node node){
        if(node == null)
            return;

        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        prev = null;
        next = null;
    }

    private void addToRight(Node oldNode, Node newNode){
        if(oldNode == null || newNode == null)
            return;

        Node next = oldNode.next;
        oldNode.next = newNode;
        newNode.prev = oldNode;

        newNode.next = next;
        next.prev = newNode;
    }

    private void addToLeft(Node oldNode, Node newNode){
        if(oldNode == null || newNode == null)
            return;

         Node prev = oldNode.prev;

         oldNode.prev = newNode;
         newNode.next = oldNode;

         prev.next = newNode;
         newNode.prev = prev;
    }

    static class Node{
        Node next;
        Node prev;
        List<String> keys;

        public Node(){
            keys = new ArrayList<>();
            next = null;
            prev = null;
        }
    }
}
