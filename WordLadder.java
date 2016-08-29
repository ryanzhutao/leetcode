import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;



public class WordLadder {

	/**
	 * @param args
	 */
	private class Node{
		String str;
		int len;
		public Node(String str, int len) {
			super();
			this.str = str;
			this.len = len;
		}
	}
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Node p = new Node(beginWord, 1);
		wordList.add(endWord);
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(p);
		int len = 0;
		while(!queue.isEmpty())
		{
			p = queue.poll();
			len = p.len;
			if(p.str.equals(endWord)){
				return len;
			}
			//find neighbors
			List<String> neighbors = findNeighbors(wordList, p.str);
			//remove from dict and push them into queue
			for(String neighbor: neighbors){
				wordList.remove(neighbor);
				Node n = new Node(neighbor, len + 1);
				queue.offer(n);
			}
		}
		return 0;
    }
	/*
	 * search all the worklist
	 */
	List<String> findNeighbors1(Set<String> wordList, String str){
		List<String> result = new ArrayList<String>();
		int diff = 0;
		char[] strarr = str.toCharArray();
		int i = 0;
		for(String word: wordList){
			diff = 0;
			char[] wordarr = word.toCharArray();
			for(i = 0; i < strarr.length; i++){
				if(strarr[i]!= wordarr[i]){
					diff++;
				}
			}
			if(diff == 1){
				result.add(word);
			}
		}
		return result;
	}
	
	/*
	 * check one char variation is in the set
	 */
	List<String> findNeighbors(Set<String> wordList, String str){
		List<String> result = new ArrayList<String>();
		char[] strarr = str.toCharArray();
		int i = 0;
		int j = 0;
		for (i = 0; i < strarr.length; i++) {
			for(j = 0; j <=25; j++){
				char var = (char)('a' + j);
				if (strarr[i] != var) {
					char[] chararrvar = new char[strarr.length];
					chararrvar = Arrays.copyOf(strarr, strarr.length);
					chararrvar[i] = var;
					String strvar = new String(chararrvar);		
					if(wordList.contains(strvar)){
						result.add(strvar);
					}
				}
			}
		}

		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder wl = new WordLadder();
		Set<String> set = new HashSet<String>();
		/**
		set.add("a");
		set.add("b");
		set.add("c");
		System.out.println(wl.ladderLength("a", "c", set));
		*/
		/**
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = {"hot","dot","dog","lot","log"};
		*/
		String beginWord = "hot";
		String endWord = "dog";
		String[] wordList = {"hot","dog"};
		for(String word: wordList){
			set.add(word);
		}
		System.out.println(wl.ladderLength(beginWord, endWord, set));
		
	}
	
	
	
	
}
