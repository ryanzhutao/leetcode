import java.util.TreeSet;


public class NearbyAlmostDuplicate {

	/**
	 * @param args
	 */
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int size = nums.length;
        int i = 0;
        TreeSet<Long> set = new TreeSet<Long>(); 
        if(k > size){
            return false;
        }
        if(size < 2){
            return false;
        }
        for(i = 0; i < size; i++)
        {
            set.add((long) nums[i]);
            //need to remove
            if(i > k){
            	System.out.println("remove");
                set.remove(nums[i-k -1]);
            }
            System.out.println(i + " " + nums[i] + " " + set.size());
            if(set.size() >= 2){
            	System.out.println("more than 2");
	            if((set.last() - set.first()) <= t){
	                return true;
	            }
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, -1};
		NearbyAlmostDuplicate nad = new NearbyAlmostDuplicate();
		System.out.println(nad.containsNearbyAlmostDuplicate(nums, 1, 0));
	}

}
