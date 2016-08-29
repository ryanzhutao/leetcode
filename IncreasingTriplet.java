
public class IncreasingTriplet {

	public boolean increasingTriplet(int[] nums) {
        int i = 0;
        if(nums.length <=1){
            return false;
        }
        int smallest = Integer.MAX_VALUE;
        int secsmallest = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++){
            if(nums[i] <= smallest){
                smallest = nums[i];
            }else if(nums[i] <= secsmallest){
            	secsmallest = nums[i];
            }else{
                return true;
            }
        }  
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IncreasingTriplet triple = new IncreasingTriplet();
		//int[] nums = {1, 2, 3, 4, 5};
		int[] nums = {5,1,5,5,2,5,4};
		//int[] nums = {2, 4, -2, 3};
		System.out.println(triple.increasingTriplet(nums));
	}

}
