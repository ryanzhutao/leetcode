import java.util.ArrayList;
import java.util.List;


public class Permutation {

	/**
	 * @param args
	 */
	public List<List<Integer>> permute(int[] nums) {
		if(nums.length == 0){
			return null;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> first = new ArrayList<Integer>();
		first.add(nums[0]);
		result.add(first);
		for(i = 1; i < nums.length; i++){
			List<List<Integer>> newresult = new ArrayList<List<Integer>>();
			for(j = 0; j < result.size(); j++) {
				List<Integer> item = result.get(j);
				for (k = 0; k <= result.get(j).size(); k++) {
					List<Integer> newitem = new ArrayList<Integer>(item);
					newitem.add(k, nums[i]);
					newresult.add(newitem);
				}
			}
			result = newresult;
			newresult = null;
		}
		return result;
    }
    
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutation p = new Permutation();
		int[] num = {1, 2, 3};
		int i = 0;
		int j = 0;
		List<List<Integer>> result = p.permute(num);
		//ArrayList<ArrayList<Integer>> result = p.permute2(num);
		
		for(i = 0; i< result.size(); i++) {
			for(j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j));
			}
			System.out.println("");
		}
		
	}

}
