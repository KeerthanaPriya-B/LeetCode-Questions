//recording: 27th june Hashing 5 time(1:00:00)
//TC: O(1)  SC: O(N)

class Node {

	//key -> app ID
	//value -> feature, EX: brightness
	int key;
	int value;
	
	Node next;
	Node prev;

	Node() {
		this.key = 0;
		this.value = 0;
		this.next = null;
		this.prev = null;
	}
	Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

class LRUCache {

    Node head;
	Node tail;
    
	int limit;
	HashMap<Integer, Node> cache;
    
    public LRUCache(int capacity) {
        
        limit = capacity;
		cache = new HashMap<>();
		
		head = new Node();
		tail = new Node();

		head.next = tail;
		tail.prev = head;
    }
    
    public int get(int key) {
        
        if(cache.containsKey(key) == false)
			return -1;
		
		Node node = cache.get(key);
		int data = node.value;
		moveToLast(node);
		return data;
    }
    
    public void put(int key, int value) {
        
        if(cache.containsKey(key)) {
            //doubly LL has this application, hence moveToLast - most recently used
            Node node = cache.get(key);

            node.value = value;
            moveToLast(node);
		}
		else {
			//seen for the first time
			Node node = new Node(key, value);
			
			if(cache.size() == limit) {
				//removing least recently used application
				Node LRU_node = head.next;
				
				removeNode(LRU_node);
				cache.remove(LRU_node.key);
			}
			addLast(node);
			cache.put(key, node);
		}
    }
    
    	//TC: O(1)
	//add application to the Most recent position
	public void addLast(Node node) {
		Node prevNode = tail.prev;

		prevNode.next = node;
		node.prev = prevNode;

		node.next = tail;
		tail.prev = node;
	}

	//TC: O(1)
	//remove application from cache
	public void removeNode(Node node) {
		Node prevNode = node.prev;
		Node nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;

		node.next = null;
		node.prev = null;
	}

	//TC: O(1)
	//move application to Most recent position
	public void moveToLast(Node node) {
		removeNode(node);
		addLast(node);
	}

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */