import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle2 {

	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int[] cur = {1};
        int[] prev = {1};
        for(i = 1; i <= rowIndex; i++){
            cur = new int[i + 1];
            for(j = 0; j <= i; j++){
                if(j == 0 | j == i){
                    cur[j] = 1;
                }else{
                    cur[j] = prev[j -1] + prev[j];
                }
            }
            prev = cur;
        }
        for(int item: cur){
            result.add(item);
        }
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
