class LRUCache {
	
	 private Node head = new Node();
	 private Node tail = new Node();
	 private Map<Integer,Node> map;
	
	LRUCache(){
        map = new HashMap<>(2);
		head.next = tail;
		tail.prev = head;
	}

	public void remove(Node n) {
		Node next = n.next;
		Node prev = n.prev;
		next.prev = prev;
		prev.next = next;
		
	}
	
	public void add(Node n) {
		Node headNext = head.next;
		n.next = headNext;
		headNext.prev = n;
		head.next = n;
		n.prev = head;
	}
	
	public int get(int key) {
		Node n = map.get(key);
		int result = -1;
		if(n!=null) {
			remove(n);
			add(n);
			result = n.val;
		}
		return result;
	}
	
	public void put(int key, int val) {
		Node n = map.get(key);
		if(n!=null) {
			remove(n);
			n.val = val;
			add(n);
		}else {
			if(map.size()==2) {
				map.remove(tail.prev.key);
				remove(tail.prev);
				
			}
			Node n1 = new Node();
			n1.val = val;
			n1.key = key;
			map.put(key, n1);
			add(n1);
		}
		
		
	}
	
	class Node {
		
		public Node next;
		
		public Node prev;
		
		public int val;
		
		public int key;

	}
	
	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache();
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		lRUCache.get(1);    // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lRUCache.get(2);    // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lRUCache.get(1);    // return -1 (not found)
		lRUCache.get(3);    // return 3
		lRUCache.get(4);    // return 4
	}

}



// With some enhancements

class LRUCache {

    Node head = new Node();
    Node tail = new Node();
    Map<Integer,Node> map = null;
    int cap = -1;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);
        this.cap = capacity;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        int res = -1;
        if(n!=null){
            res = n.value;
            delete(n);
            add(n);
        }
        return res;
    }
    
    public void put(int key, int value) {
        Node temp = map.get(key);
        if(temp==null){
            if(map.size()==cap){
                map.remove(tail.prev.key);
                delete(tail.prev);
            }
            Node n = new Node();
            n.key = key;
            n.value = value;
            map.put(key,n);
            add(n);
        }else{
            delete(temp);
             temp.value = value;
            add(temp);
        }
    }
    
    public void add(Node n){
        Node headNext = head.next;
        head.next = n;
        n.next = headNext;
        headNext.prev = n;
        n.prev = head;
        
        
        
    }
    public void delete(Node n){
        Node next_node = n.next;
        Node prev_node = n.prev;
        prev_node.next = next_node;
        next_node.prev = prev_node;
    }
    
}

class Node {
    Node next;
    Node prev;
    int key;
    int value;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
