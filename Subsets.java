import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        int i = 0;
        int j = 0;
        if(size == 0){
            return null;
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        results.add(empty);
        for(i = 0; i < size; i++){
            List<List<Integer>> last = new ArrayList<List<Integer>>(results); 
            for(j = 0; j < last.size(); j++){
                List<Integer> newitem = new ArrayList<Integer>(last.get(j));
                newitem.add(nums[i]);
                Collections.sort(newitem);
                results.add(newitem);
            }
        }
        return results;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4, 1, 0};
		int i = 0;
		int j = 0;
		Subsets sb = new Subsets();
		ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) sb.subsets(num);
		for(i = 0; i< result.size(); i++) {
			for(j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j));
			}
			System.out.println("");
		}
	}

}
