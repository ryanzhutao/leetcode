
public class PeekingIterator implements Iterator<Integer>{

	/**
	 * @param args
	 */
	
	Iterator<Integer> iter;
    //peak is the next one
    Integer peek;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
	    if(iter.hasNext()){
	        peek = iter.next();
	    }else{
	        peek = null;
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	
	public Integer next() {
	    if(peek == null){
	        throw new java.util.NoSuchElementException(); 
	    }
	    int current = peek;
	    if(iter.hasNext()){
	        peek = iter.next();
	    }else{
	        peek = null;
	    }
	    return current;
	}

	public boolean hasNext() {
	    return (peek != null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
