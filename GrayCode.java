import java.util.ArrayList;
import java.util.List;


public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> numlist = new ArrayList<Integer>();
        List<String> strlist= new ArrayList<String>();
        int i = 0;
        int j = 0;
        if(n <=0){
        	numlist.add(0);
        	return numlist;
        }
        String newstr = "";
        //add empty
        strlist.add("");
        for(i = 0; i < n; i++){
        	List<String> newstrlist = new ArrayList<String>();
        	//add "0"
        	for(j = 0; j < strlist.size(); j++){
        		newstr = "0" + strlist.get(j);
        		newstrlist.add(newstr);
        	}
        	//reverse add "1"
        	for(j = strlist.size()-1; j>=0; j--){
        		newstr = "1" + strlist.get(j);
        		newstrlist.add(newstr);
        	}
        	strlist = newstrlist;
        }
        for(String str : strlist){
        	numlist.add(binary2Int(str));
        }
        return numlist;
    }
	
	public int binary2Int(String binarystr){
		return Integer.parseInt(binarystr, 2);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode gc = new GrayCode();
		List<Integer> numlist = gc.grayCode(0);
		for(int num: numlist){
			System.out.println(num);
		}
	}

}
