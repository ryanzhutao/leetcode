
public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
        int prev;
        if(nums.length <= 1){
            return nums.length;
        }
        int i = 0;
        prev = nums[0];
        int newlen = 1;
        int j = 0;
        int cnt = 1;
        int dup = 0;
        for(i=1; i<(nums.length-dup); i++){
            if(cnt == nums.length + 1){
                break;
            }
            if(nums[i]!=prev){
                newlen++;
            }else{
                dup++;
                for(j = i; j < nums.length-1; j++){
                    nums[j] = nums[j+1];
                }
                i--;
            }
            cnt++;
            prev = nums[i];
        }
        return newlen;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
