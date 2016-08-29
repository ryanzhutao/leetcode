import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<List<Integer>> permutation = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<>();
        permutation.add(empty);
        HashSet<String> set = new HashSet<String>();
        int i = 0;
        String name = "";
        for(i = 0; i < nums.length; i++){
            List<List<Integer>> tmp = new ArrayList<List<Integer>>(permutation);
            for(List<Integer> list: tmp){
                list.add(nums[i]);
                permutation.add(list);
            }
        }
        
        for(List<Integer> list1: permutation){
        	for(Integer num: list1){
				System.out.print(num + " ");
			}
			System.out.println("");
            if(list1.size()==4){
                if(getSum(list1) == target){
                    //sort
                    name = "";
                    Collections.sort(list1);
                    for(Integer num: list1){
                        name+= num + "-";
                    }
                    System.out.println(name);
                    //use name as key to check if it exists
                    if(!set.contains(name)){
                    	set.add(name);
                        result.add(list1);
                    }
                }
            }
        }
        return result;
    }
    
    private int getSum(List<Integer> list){
        int sum = 0;
        for(Integer num : list){
            sum+=num;
        }
        return sum;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FourSum sum = new FourSum();
		int[] nums = {1,0,-1,0,-2,2};
		List<List<Integer>> result = sum.fourSum(nums, 0);
		for(List<Integer> list: result){
			for(Integer num: list){
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}

}
