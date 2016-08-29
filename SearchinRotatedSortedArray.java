
public class SearchinRotatedSortedArray {
	/**
	 * sorted:  0 1 2 3 4 5 6 7 8
	 * case1: 2 3 4 5 6 7 8 0 1
	 * case2: 7 8 0 1 2 3 4 5 6
	 * case1: nums[mid] = 6; left is sorted, nums[end] < nums[start] < nums[mid]; if(nums[start]<target<nums[mid]), go left, else go to right
	 * case2: nums[mid] = 2; right is sorted, nums[mid] < nums[end] < nums[start]; if(nums[mid]<target<nums[end], go to right, else go left)
	 * @return
	 */
	public int search(int[] nums, int target) {
		int index = -1;
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        index = binarysearch(nums, target, start, end);
        return index;
    }
	
	public int binarysearch(int[] nums, int target, int start, int end){
		if(end >= start){
			int mid = (start + end)/2;
			if(target == nums[mid]){
				return mid; 
			}
			//right is sorted
			//if(nums[mid] < nums[end] && nums[end] < nums[start]){
			if(nums[mid] < nums[end]){
				if(nums[mid]<target && target<=nums[end]){
					 return binarysearch(nums, target, mid + 1, end);
				}else{
					 return binarysearch(nums, target, start, mid -1);
				}
			}
			//left is sorted
			else{
				if(nums[start]<=target && target<nums[mid]){
					 return binarysearch(nums, target, start, mid -1);
				}else{
					 return binarysearch(nums, target, mid + 1, end);
				}
				
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3 ,1};
		SearchinRotatedSortedArray ss = new SearchinRotatedSortedArray();
		System.out.println(ss.search(arr, 1));
	}

}
