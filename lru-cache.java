# LRU Cache
class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

    public Node getTail() {
        return tail.prev;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    DoublyLinkedList cache;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoublyLinkedList();
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            cache.removeNode(node);
            cache.addToFront(node);
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            cache.removeNode(node);
            node.value = value;
            cache.addToFront(node);
        }else{
            if(map.size() >= capacity) {
                Node tailNode = cache.getTail();
                map.remove(tailNode.key);
                cache.removeNode(tailNode);
            }

            Node node = new Node(key, value);
            map.put(key, node);
            cache.addToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */