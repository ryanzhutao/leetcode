import java.util.ArrayList;


public class RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int size = nums.length;
        int i = 0;
        int j = 0;
        if(size <= 2){
            return size;
        }else{
            int count = 0;
            for(i = 2; i < size - count; i++){
                if(nums[i] == nums[i -1] && nums[i] == nums[i-2]){
                    for(j = i; j < size - count -1; j++){
                        nums[j] = nums[j + 1];
                    }
                    i--;
                    count ++;
                }
            }
            for(i = 0; i< size - count; i++){
            	System.out.print(nums[i]);
            }
            return (size - count);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,2,2};
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.removeDuplicates(nums);
		
	}

}
