import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class ReconstructItinerary {

	List<String> list = null;
	HashMap<String, List<String>> table = null;
	public List<String> findItinerary(String[][] tickets) {
        list = new ArrayList<String>();
        table = new HashMap<String, List<String>>();
        int i = 0;
        List<String> to = null;
        String from;
        String newfrom;
        //put into hashtable
        for(i = 0; i < tickets.length; i++){
        	String[] pair = tickets[i];
        	to = table.get(pair[0]);
        	if(to == null){
        		to = new ArrayList<String>();
        	}
        	to.add(pair[1]);
        	table.put(pair[0], to);
        }
        //sort
        Set<String> keys = table.keySet();
        for(String key: keys){
        	List<String> value = table.get(key);
        	if(value.size()>1){
        		Collections.sort(value);
        	}
        	table.put(key, value);
        }
        from = "JFK";
        dfs(from);
        return list;
    }
	
	public void dfs(String from){
		List<String> tos = table.get(from);
		while(tos!=null && tos.size()>0){
			dfs(tos.remove(0));
		}
		list.add(0,from);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReconstructItinerary ri = new ReconstructItinerary();
		//String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		List<String> list = ri.findItinerary(tickets);
		for(String s: list){
			System.out.print(s + " ");
		}
	}

}
