import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Subsets2 {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		int i = 0;
        int j = 0;
        List<List<Integer>> result = new ArrayList<>();
        //add empty
        List<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        Arrays.sort(nums);
        int size = nums.length;
        if(size == 0){
            return result;
        }
      
        
        for(i = 0; i < size; i++){
            List<List<Integer>> tmp = new ArrayList<List<Integer>>(result);
            for(j = 0; j < tmp.size(); j++){
                List<Integer> list = new ArrayList<>(tmp.get(j));
                //add original
                list.add(nums[i]);
                if(!result.contains(list)){
                	result.add(list);
                }
                
            }    
        }
        
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,5,5,5,5};
		Subsets2 subset = new Subsets2();
		List<List<Integer>> result = subset.subsetsWithDup(nums);
		
		for(List<Integer> list: result){
			for(Integer item: list){
				System.out.print(item + " ");
			}
			System.out.println("");
		}
		
	}

}
