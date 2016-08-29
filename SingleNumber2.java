
public class SingleNumber2 {

	public int singleNumber(int[] nums) {
		int i = 0;
        int j = 0;
        int[] counter = new int[32];
        int res = 0;
        for(i = 0; i< nums.length; i++){
            for(j = 0; j < 32; j++){
               if(((nums[i] >> j) & 1) == 1){
            	   counter[j] ++;
               }
            }
        }
        for(j = 0; j< 32; j++){
            counter[j] = counter[j]%3;
            if(counter[j] != 0){
                res = res | (1 << j);
            }
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
