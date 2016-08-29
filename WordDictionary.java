import java.util.ArrayList;


public class WordDictionary {

	/**
	 * @param args
	 */
	private class Node{
        private char c;
        private ArrayList<Node> childlist;
        private boolean isend;
        public Node(char c){
            this.c = c;
        }
        public Node(){
            
        }
    }

    Node root;
    // Adds a word into the data structure.
    public void addWord(String word) {
        int i = 0;
        int j = 0;
        boolean isfound = false;
        char[] array = word.toCharArray();
        if(root == null){
            root = new Node();
        }
        Node node = root;
        for(i = 0; i < array.length; i++){
            ArrayList<Node> clist = node.childlist;
            isfound = false;
            if(clist == null){  
                break;
            }else{
                for(j = 0; j < clist.size(); j++){
                    Node child = clist.get(j);
                    if(array[i] == child.c){
                        node = child;
                        isfound = true;
                        break;
                    }
                }
                if(isfound == false){
                    break;
                }
            }
        }
        if(isfound == false){
            for(j = i; j < array.length; j++){
                Node newnode = new Node(array[j]);
                node.childlist = new ArrayList<Node>();
                node.childlist.add(newnode);
                node = newnode;
            }
            node.isend = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        char[] array = word.toCharArray();
        if(root == null){
            return false;
        }
        return recursiveSearch(array, 0, root);
    }
    
    public boolean recursiveSearch(char[] array, int i, Node node){
    	ArrayList<Node> clist = node.childlist;
        int j = 0;
        //leaf node
        if(node == null){
            return false;
        }
        if(i == array.length){
           
            return node.isend;
            
        }
        if(node.childlist != null){
	        if(array[i] == '.'){
	            //recurisive search child
	            for(j = 0; j < clist.size(); j++){
	                if( recursiveSearch(array, i+1, clist.get(j))){
	                	return true;
	                }
	            }
	            return false;
	        }else{
	            for(j = 0; j < clist.size(); j++){
	                Node child = clist.get(j);
	                if(array[i] == child.c){
	                    return recursiveSearch(array, i+1, child);
	                }
	            }
	        }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".ad"));
		System.out.println(wordDictionary.search("b.."));
	}

}
