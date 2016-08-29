
public class NumArray {

	int[] sums;
    public NumArray(int[] nums) {
        int i = 0;
        sums = nums;
        for(i = 1; i < nums.length; i++){
            sums[i]+= sums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sums[j];
        }else{
            return sums[j]-sums[i-1];
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2, 0, 3, -5, 2,-1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0,2));
		System.out.println(numArray.sumRange(2,5));
		System.out.println(numArray.sumRange(0,5));
	}

}
