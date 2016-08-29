
public class MajorityElement2 {

	public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int maj2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int i = 0;
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0){
            return res;
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] == maj1){
                cnt1 ++;
            }else if(nums[i] == maj2){
                cnt2 ++;
            }else if(cnt1 == 0){
                maj1 = nums[i];
                cnt1 = 1;
            }else if(cnt2 == 0){
                maj2 = nums[i];
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = cnt2 = 0;
        for(i = 0; i < nums.length; i++){
            if(nums[i] == maj1){
                cnt1++;
            }else if(nums[i] == maj2){
                cnt2++;
            }
        }
        if(cnt1 > (nums.length/3)){
            res.add(maj1);
        }
        if(cnt2 > (nums.length/3)){
            res.add(maj2);
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
