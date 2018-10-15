// Question 146 LRU Cache

class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        else {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
        }
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
        } else {
            if (map.size() >= capacity) {
                map.remove(map.keySet().iterator().next());
            }
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// Method 2: implement LinkedHashMap

class LRUCache {
    class Node {
        Node prev, next;
        int key;
        int val;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        Node() {
            this(0, 0);
        }
    }
    
    int capacity;
    int count;
    HashMap<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            map.put(key, node);
            add(node);
            count++;
        } else {
            node.val = value;
            update(node);
        }
        if (count > capacity) {
            Node del = tail.prev;
            remove(del);
            map.remove(del.key);
            count--;
        }
    }
    
    public void update(Node node) {
        remove(node);
        add(node);
    }
    
    public void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    
    public void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */