import java.util.Hashtable;



public class LRUCache1 {
	
	private class Node {
		private int key;
		private Node next;
		private Node pre;
		public Node(int key) {
			super();
			this.key = key;
		}

		public void setPre(Node pre) {
			this.pre = pre;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	Hashtable<Integer, Integer> hash;
	Node head;
	Node tail;
	int capacity;
	int num;
	
	
	public LRUCache1(int capacity) {
		hash = new Hashtable<Integer, Integer>(capacity);
		//lruList = new LinkedList<Integer>();
		head = tail = null;
		this.capacity = capacity;
		num = 0;
    }
    
	public void addtoTail(int key) {
		if(head == null) {
			head = new Node(key);
			tail = head;
			head.setNext(tail);
			head.setPre(null);
			tail.setPre(head);
			tail.setNext(null);
		}
		else {
			Node node = new Node(key);
			node.setPre(tail);
			node.setNext(null);
			tail.setNext(node);
			tail = tail.next;
		}
	}
	
	public int removeHead() {
		int key = head.key;
		head = head.next;
		head.setPre(null);
		return key;
	}
	
	public void removeKey(int k) {
		if(head == null) {
			return;
		}
		
		if(head.key == k) {
			if(head == tail) {
			    head = tail = null;
			}else {
				head = head.next;
				head.setPre(null);
			}
		}
		if(tail.key == k) {
			tail = tail.pre;
			tail.setNext(null);
		}
		Node node = head.next;
		while (node != tail) {
			if(node.key == k) {
				node.pre.setNext(node.next);
				node.next.setPre(node.pre);
				break;
			}
			node = node.next;
		}
			
	}
	
	public int get(int key) {
    	int value = -1;
    	if(hash.containsKey(key)) {
	    	value = hash.get(key);
	    	removeKey(key);
	    	addtoTail(key);
    	}

    	return value;
    }
    
    public void set(int key, int value) {
    	int removekey;
    	if(num < capacity) {
    		if(hash.containsKey(key))
    		{
    			removeKey(key);
    		}else {
    			num ++;
    		}
    			
    	}else {
    		if(hash.containsKey(key))
    		{
    			removeKey(key);

    		}else {
    			removekey = removeHead(); 
	    		hash.remove(removekey);
    		}
    	}
    	hash.put(key, value);
    	addtoTail(key);
    }
    
    public void print()
    {
    	int size = 0;
    	if (head == null)
    		return;
    	Node node = head;
    	while(node != null) {
    		System.out.print(node.key + " ");
    		node = node.next;
    		size ++;
    	}
    	System.out.println("");
    	System.out.println("Size is " + size);
    }
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lru = new LRUCache(10);
		int i;
		/**
		for(i = 0; i < 10; i++) {
			lru.set(i, i+1);
		}
		lru.print();
		for(i = 0; i < 5; i++) {
			lru.set(i, i+1);
		}
		*/
		lru.set(2, 1);
		System.out.println(lru.get(2));
		lru.print();
	}
	


}
