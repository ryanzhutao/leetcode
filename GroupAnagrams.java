import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
        int i = 0;
        String sortstr;
        List<List<String>> result = new ArrayList<List<String>>();
        Hashtable<String, ArrayList<String>> table = new Hashtable<String, ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        Set<String> keyset;
        boolean isfound = false;
        
        list.add(strs[0]);
        table.put(getSort(strs[0]), list);
        String key = null;
        Iterator<String> iter = null;
        for(i = 1; i < strs.length; i++){
            sortstr = getSort(strs[i]);
            list = table.get(sortstr);
            if(list == null){
            	list = new ArrayList<String>();
            }
            list.add(strs[i]);
            table.put(sortstr, list);
        }
        keyset = table.keySet();
        iter = keyset.iterator();
        while(iter.hasNext()){
        	key = iter.next();
        	list = table.get(key);
        	Collections.sort(list);
        	result.add(list);
        }
        return result;
    }
    
    private String getSort(String str){
    	char[] chararr = str.toCharArray();
        Arrays.sort(chararr);
        String res = new String(chararr);
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"tea","","eat","","tea",""};
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> list = ga.groupAnagrams(strs);
	}

}
