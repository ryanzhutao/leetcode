import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class RandomizedSet {

	HashMap<Integer, Integer> map;
    List<Integer> list;
    int cnt;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        //map contains the data and index
        map = new HashMap<Integer, Integer>();
        //list contains index and data
        list = new ArrayList<Integer>();
        cnt = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,cnt);
        list.add(cnt, val);
        cnt++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        map.remove(val);
        //swap the deleted one and the last one, this approach keeps the order
        cnt--;
        if(index!= cnt){
        	int last = list.get(cnt);
        	map.put(last, index);
        	list.set(index, last);
        }
        list.remove(cnt);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random r = new Random();
        System.out.println(list.size());
        int rn = r.nextInt(list.size());
        return list.get(rn);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet rs = new RandomizedSet();
		
		System.out.println(rs.insert(0));
		System.out.println(rs.remove(0));
		System.out.println(rs.insert(-1));
		System.out.println(rs.remove(0));
		System.out.println(rs.getRandom());
		
	}

}
