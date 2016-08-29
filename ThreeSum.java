import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
        int i = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int remaining = 0;
        int j = 0;
        int k = 0;
        int sum = 0;
        for(i = 0; i < nums.length -2; i++){
            remaining = 0 - nums[i];
            j = i + 1;
            k = nums.length -1;
            while(j < k){
                sum = nums[j] + nums[k];
                if(sum == remaining){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    res.add(list);
                    j++;
                    k--;
                    //remove dup remaining
                    while((j < k) && (nums[j] == nums[j-1])){
                        j++;
                    }
                    while((j < k) && (nums[k] == nums[k+1])){
                        k--;
                    }
                }else if(sum < remaining){
                    j++;
                }else{
                    k--;
                }
            }
            //remove dup nums[i]
            while((i+1) < nums.length && nums[i+1] == nums[i]){
                i++;
            }
            
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
