import java.util.Arrays;


public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		int i = 0;
        int sum = 0;
        int closetsum = 0;
        int diff = 0;
        int absdiff = 0;
        int mindiff = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        Arrays.sort(nums);
        for(i = 0; i < nums.length -2; i++){
            j = i + 1;
            k = nums.length -1;
           
            while(j < k){
            	sum = nums[i] + nums[j] + nums[k];
                diff = target - sum;
                if(diff == 0){
                    return sum;
                }else if(diff > 0){
                    j++;
                }else{
                    k--;
                }
                absdiff = Math.abs(diff);
                if(absdiff < mindiff){
                    mindiff = absdiff;
                    closetsum = sum;
                }
            }
            
            while(((i+1)<nums.length) && (nums[i+1] == nums[i])){
                i++;
            }
            
        }
        return closetsum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumClosest tsc = new ThreeSumClosest();
		int[] nums = {1,1,1,0};
		System.out.println(tsc.threeSumClosest(nums, 100));
 	}

}
