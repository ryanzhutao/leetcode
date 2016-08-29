import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;


public class LRUCache {

	Hashtable<Integer, Integer> hash;
	LinkedList<Integer> lruList;
	int capacity;
	int num;
	
	
	public LRUCache(int capacity) {
		hash = new Hashtable<Integer, Integer>(capacity);
		//lruList = new LinkedList<Integer>();
		lruList = new LinkedList<Integer>();
		this.capacity = capacity;
		num = 0;
    }
    
	public int get(int key) {
    	int value = -1;
    	if(hash.containsKey(key)) {
	    	value = hash.get(key);
	    	lruList.remove(new Integer(key));
	    	lruList.addLast(key);
    	}

    	return value;
    }
    
    public void set(int key, int value) {
    	int removeKey;
    	if(num < capacity) {
    		if(hash.containsKey(key))
    		{
    			lruList.remove(new Integer(key));
    		}else {
    			num ++;
    		}
    			
    	}else {
    		if(hash.containsKey(key))
    		{
    			lruList.remove(new Integer(key));

    		}else {
	    		removeKey = lruList.removeFirst();
	    		hash.remove(removeKey);
    		}
    	}
    	hash.put(key, value);
		lruList.addLast(key);
    }
    
    public void print()
    {
    	System.out.println("Size is: " + lruList.size());
    	Iterator<Integer> itr = lruList.iterator();
    	while(itr.hasNext()) {
    		System.out.print(itr.next()+" ");
    	}
    	System.out.println("");
    }
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lru = new LRUCache(10);
		int i;
		for(i = 0; i < 10; i++) {
			lru.set(i, i+1);
		}
		lru.print();
		for(i = 0; i < 5; i++) {
			lru.set(i, i+1);
		}
		lru.print();
	}

}
