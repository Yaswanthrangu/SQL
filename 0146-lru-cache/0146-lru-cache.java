import java.util.HashMap;

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private HashMap<Integer, Node> mp;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        mp = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            remove(node);
            insert(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node node = mp.get(key);
            remove(node);
            node.val = value; // Update value
            insert(node);
        } else {
            if (mp.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }
    }

    private void insert(Node newNode) {
        mp.put(newNode.key, newNode);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void remove(Node node) {
        mp.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
