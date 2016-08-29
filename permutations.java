import java.util.List;
import java.util.ArrayList;

public class permutations {

	public ArrayList<ArrayList<Integer>> permute1(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        int j = 0;
        int k = 0;
        if(num.length == 0)
        	return result;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(num[0]);
        result.add(first);
        for(i = 1; i < num.length; i++) {
        	 ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
        	 for(j = 0; j< result.size(); j++) {
        		 ArrayList<Integer> tmp = result.get(j);
        		 for(k = 0; k <= tmp.size(); k ++) {
        			tmp.add(k, num[i]);
        			ArrayList<Integer> list = new ArrayList<Integer>(tmp);
        			current.add(list);
        			tmp.remove(k);
        		 }
        	 }
        	 result = current;
        	 current = null;
        }
        return result;
    }
    
	
	public ArrayList<ArrayList<Integer>> permute2(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        makePermute2(num, 0, num.length, result);
        return result;
    }
   
	
	private void makePermute2(int[]num, int start, int lenth, ArrayList<ArrayList<Integer>> result) {
		int j;
		if(start == lenth) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int n: num) {
				list.add(n);
			}
			result.add(list);
		}
		for(j = start; j < lenth; j++) {
			swap(num, start, j);
			makePermute2(num, start+1, lenth, result);
			swap(num, start, j);
		}
	}
	
	private void swap(int[] num, int i, int j) {
		int tmp;
		tmp = num[j];
		num[j] = num[i];
		num[i] = tmp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutations p = new permutations();
		int[] num = {1, 2, 3};
		int i = 0;
		int j = 0;
		ArrayList<ArrayList<Integer>> result = p.permute1(num);
		//ArrayList<ArrayList<Integer>> result = p.permute2(num);
		for(i = 0; i< result.size(); i++) {
			for(j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j));
			}
			System.out.println("");
		}
	}

}
