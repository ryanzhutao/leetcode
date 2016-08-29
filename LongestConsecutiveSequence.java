import java.util.HashSet;
import java.util.Set;


public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
        int maxlen = 0;
        int i = 0;
        int tmp = 0;
        int currentlen = 0;
        Set<Integer> sets = new HashSet<Integer>();
        for(i = 0; i < nums.length; i++){
            sets.add(nums[i]);
        }
        for(i = 0; i < nums.length; i++){
            currentlen = 1;
            tmp = nums[i];
            tmp --;
            while(sets.contains(tmp)){
                sets.remove(tmp);
                currentlen ++;
                tmp --;
            }
            tmp = nums[i];
            tmp ++;
            while(sets.contains(tmp)){
                sets.remove(tmp);
                currentlen ++;
                tmp ++;
            }
            if(currentlen > maxlen){
                maxlen = currentlen;
            }
            
        }
        return maxlen;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
