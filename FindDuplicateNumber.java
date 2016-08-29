
public class FindDuplicateNumber {

	/**
	 * The main idea is the same with problem Linked List Cycle II
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(fast!= slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
