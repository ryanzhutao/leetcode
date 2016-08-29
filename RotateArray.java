
public class RotateArray {

	public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k > 0){
        	reverse(nums, 0, nums.length -k -1);
        	reverse(nums, nums.length -k, nums.length -1);
        	reverse(nums, 0, nums.length -1);
        }
    }
	
	void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++; end--;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		RotateArray ra = new RotateArray();
		ra.rotate(nums, 3);
	}

}
