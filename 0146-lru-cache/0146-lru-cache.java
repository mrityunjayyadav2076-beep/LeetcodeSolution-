class Node {
    int key;
    int value;
    Node previous;
    Node next;

    Node() {
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private int currentSize;
    private int maxCapacity;
    private Node dummyHead;  
    private Node dummyTail;  
    private Map<Integer, Node> cacheMap;  

    
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.currentSize = 0;
      
        this.dummyHead = new Node();
        this.dummyTail = new Node();
      
        dummyHead.next = dummyTail;
        dummyTail.previous = dummyHead;
      
        this.cacheMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
      
        Node targetNode = cacheMap.get(key);
      
        removeNodeFromList(targetNode);
        addNodeToHead(targetNode);
      
        return targetNode.value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node existingNode = cacheMap.get(key);
          
            removeNodeFromList(existingNode);
          
            existingNode.value = value;
          
            addNodeToHead(existingNode);
        } 
        
        else {
            Node newNode = new Node(key, value);
          
            cacheMap.put(key, newNode);
          
            addNodeToHead(newNode);
          
            currentSize++;
          
            if (currentSize > maxCapacity) {
                Node lruNode = dummyTail.previous;
              
                cacheMap.remove(lruNode.key);
              
                removeNodeFromList(lruNode);
              
                currentSize--;
            }
        }
    }

    private void removeNodeFromList(Node node) {
        node.previous.next = node.next;
      
        node.next.previous = node.previous;
    }

    private void addNodeToHead(Node node) {
        
        node.next = dummyHead.next;
        node.previous = dummyHead;
      
        dummyHead.next = node;
      
        node.next.previous = node;
    }
}
