import java.util.ArrayList;
import java.util.List;


public class ZigZagConversion {

	public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        StringBuilder sb = new StringBuilder();
        List<Character>[] lists = new ArrayList[numRows];
        for(i = 0; i < numRows; i++){
            lists[i] = new ArrayList<Character>();
        }
        char[] chararray = s.toCharArray();
        int patternlen = 2*(numRows -1);
        for(i = 0; i < chararray.length; i++){
            k = i % patternlen;
            for(j = 0; j < numRows; j++){
                if(j == k){
                    lists[k].add(chararray[i]);
                    break;
                }
            }
            for(j = numRows; j < patternlen; j++){
                if(j == k){
                    lists[patternlen-k].add(chararray[i]);
                    break;
                }
            }
        }
        for(i = 0; i < numRows; i++){
            List<Character> list = lists[i];
            for(j = 0; j < list.size(); j++){
                sb.append(list.get(j));
            }
        }
        return sb.toString();
    }
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
