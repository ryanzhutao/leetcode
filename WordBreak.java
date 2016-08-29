import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
        Hashtable<Integer, Set<String>> hash = new Hashtable<Integer, Set<String>>();
        Iterator<String> itr = dict.iterator();
        int length;
        String str;
        Set<String> subset;
        int i = 0;
        int count = 0;
        while(itr.hasNext()) {
        	str = itr.next();
            length = str.length();
            if(length <= s.length()){
            	Integer len = new Integer(length);
	            if(hash.containsKey(len)) {
	            	subset = hash.get(len);
	            	subset.add(str);
	            	hash.put(len, subset);
	            }
	            else {
	            	subset = new HashSet<String>();
	            	subset.add(str);
	            	hash.put(len, subset);
	            }
            }
        }
        
        for(i = 0; i < s.length(); ) {
        	Iterator<Integer> lenitr = hash.keySet().iterator();
        	count = 0;
        	while (lenitr.hasNext()) {
        		length = lenitr.next();
        		if(i+length <= s.length()) {
	        		String substr = s.substring(i, i+length);
	        		System.out.println(i + " " + substr + " " + length);
	        		subset = hash.get(new Integer(length));
	        		Iterator<String> stritr = subset.iterator();
	        		while (stritr.hasNext()) {
	        			if(substr.equals(stritr.next())) {
	        				i += length;
	        			}
	        			else {
	        				count ++;
	        			}
	        		}
        		} else {
        			count += hash.get(length).size();
        		}
        	}
        	System.out.println("count " + count + "size " + dict.size());
        	if(count == dict.size())
        		return false;
        }
        return true;
    }
	
	public boolean wordBreak1(String s, Set<String> dict) {
		int length = s.length();
	    boolean[] can = new boolean[length+1];
	    can[0] = true;
	    for (int i = 1; i <= length; i++) {
	        for (int j = 0; j < i; j++) {
	            if (can[j] && dict.contains(s.substring(j, i))) {
	                can[i] = true;
	                break;
	            }
	        }
	    }
	    return can[length];
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak wb = new WordBreak();
		String s = "abcd";
		String[] dict = {"a","abc","b","cd"};
		Set<String> set = new HashSet<String>(Arrays.asList(dict));
		System.out.println(wb.wordBreak1(s, set));
	}

}
