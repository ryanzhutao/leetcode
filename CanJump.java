
public class CanJump {

	public boolean canJump(int[] nums) {
        int i = 0;
        int maxcover = 0;
        boolean canjump = false;
        if(nums.length == 1){
        	return true;
        }
        for(i = 0; i < nums.length -1; i++){
            //can not reach current position
            if(maxcover < i){
                canjump = false;
                break;
            }
            if(nums[i] + i >= maxcover){
                maxcover = nums[i] + i;
            }
            if(maxcover >= (nums.length-1)){
                canjump = true;
                break;
            }
        }
        return canjump;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {3,2,1,0,4};
		//int[] num = {2,3,1,1,4};
		CanJump cj = new CanJump();
		System.out.println(cj.canJump(num));
	}

}
