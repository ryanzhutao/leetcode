import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SubstringwithConcatenationofAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int i = 0;
        Integer count = null;
        String substr = null;
        if(s.length() == 0 || words.length == 0){
            return list;
        }
        for(String word: words){
            count = map.get(word);
            if(count == null){
                map.put(word, 1);
            }else{
                map.put(word, count+1);
            }
        }
        
        int len = words[0].length();
        int totallen = len* words.length;
        for(i = 0; i <= s.length()-totallen; i++){
            substr = s.substring(i, i+totallen);
            if(isConcatenation(substr, map, len)){
                list.add(i);
            }
        }
        return list;
    }
    
    
    private boolean isConcatenation(String s, HashMap<String, Integer> map, int len){
 
        int i = 0;
        String substr = null;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>(map);
        Integer count = null;
        for(i = 0; i <= s.length()-len; i = i+len){
            substr = s.substring(i, i+len);
            count = map1.get(substr);
            if(count == null){
                return false;
            }else{
	            if(count == 0){
	                return false;
	            }
	            map1.put(substr, count-1);
            }
        }
      
        for(Integer value: map1.values()){
        	if(value!=0){
        		return false;
        	}
        }
       
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		SubstringwithConcatenationofAllWords swcw = new SubstringwithConcatenationofAllWords();
		List<Integer> list = swcw.findSubstring(s, words);
		for(Integer num: list){
			System.out.println(num);
		}
	}

}
