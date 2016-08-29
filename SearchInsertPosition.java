
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
        return searchInsertHelp(nums, target, 0, nums.length -1);
    }
    
    
    private int searchInsertHelp(int[] nums, int target, int low, int high){
        if(high <= low){
            if(target > nums[low]){
                return low + 1;
            }else{
                return low;
            }
        }else{
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                return searchInsertHelp(nums, target, low, mid-1);
            }else{
                return searchInsertHelp(nums, target, mid+1, high);
            }
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
