
public class FindMinimuminRotatedSortedArray {

	/**
	 * @param args
	 */
	 public int findMin(int[] nums) {
	        return binarysearch(nums, 0, nums.length-1);
	    }
	    
	    public int binarysearch(int[] nums, int low, int high){
	        int mid = 0;
	        if(high == low){
	            return nums[high];
	        }else{
	            mid = low + (high - low)/2;
	            if(nums[mid] > nums[high]){
	                return binarysearch(nums, mid +1, high);
	            }else{
	                return binarysearch(nums, low, mid);
	            }
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
