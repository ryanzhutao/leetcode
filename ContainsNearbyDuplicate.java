import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;


public class ContainsNearbyDuplicate {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, ArrayList<Integer>> table = new HashMap<Integer, ArrayList<Integer>>();
        int i = 0;
        ArrayList<Integer> list = null;
        int prev = 0;
        int curr = 0;
        for(i = 0; i < nums.length; i++){
            list = table.get(nums[i]);
            if(list == null){
                list = new ArrayList<Integer>();
            }
            //add index
            list.add(i);
            table.put(nums[i], list);
        }
        Set<Integer> keys = table.keySet();
        
        for(Integer key: keys){
            list = table.get(key);
            Collections.sort(list);
            prev = list.get(0);
            for(i = 1; i < list.size(); i++){
                curr = list.get(i);
                if((curr - prev)<= k){
                    return true;
                }
                prev = curr;
            }
        }
        return false;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainsNearbyDuplicate cnd = new ContainsNearbyDuplicate();
		int[] nums = {-1, -1};
		System.out.println(cnd.containsNearbyDuplicate(nums, 1));
	}

}
