import java.util.ArrayList;
import java.util.List;


public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
        int i = 0;
        int j = 0;
        int m = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> empty = new ArrayList<Integer>();
        result.add(empty);
        for(i = 0; i < k; i++){
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            //if num is greater than last
            for(j = 0; j < result.size(); j++){
                List<Integer> list = result.get(j);
                //get the last one
                if(list.size() > 0){
	                int last = list.get(list.size() -1);
	                for(m = 1; m <= n; m++){
	                    if(m > last){
	                        List<Integer> newlist = new ArrayList<Integer>(list);
	                        newlist.add(m);
	                        tmp.add(newlist);
	                    }
	                }
                }else{
                	for(m = 1; m <= n; m++){
	                     List<Integer> newlist = new ArrayList<Integer>(list);
	                     newlist.add(m);
	                     tmp.add(newlist); 
	                }
                }
            }
            result = tmp;
            tmp = null;
        }
        return result;
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations com = new Combinations();
		List<List<Integer>> lists = com.combine(4, 3);
		for(List<Integer> list: lists){
			for(int num : list){
				System.out.print(num + " ");
			}
			System.out.println("");
		}
	}

}
