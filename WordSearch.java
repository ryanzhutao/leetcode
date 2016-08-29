
public class WordSearch {

	boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        char[] wordarray = word.toCharArray();
        //find the first
        int i = 0;
        int j = 0;
        int nrow = board.length;
        int ncol = board[0].length;
        visited = new boolean[nrow][ncol];
        boolean exist = false;
       
        for(i = 0; i < nrow; i++){
            for(j = 0; j < ncol; j++){
                if(wordarray[0] == board[i][j]){
                	resetVisit(board);
                    exist = existHelper(board, 0, word, i, j);
                    
                    if(exist == true){
                    	return true;
                    }
                }
            }
        }
        //not even find the first char
        return false;
        
    }
    
    private void resetVisit(char[][] board){
    	int i = 0;
    	int j = 0;
    	int nrow = board.length;
        int ncol = board[0].length;
    	for(i = 0; i < nrow; i++){
            for(j = 0; j < ncol; j++){
                visited[i][j] = false;
            }
        }
    }
    
    private boolean existHelper(char[][] board, int i, String word, int row, int col){
        boolean isexisted;
        if(i == word.length()){
            return true;
        }
        int nrow = board.length;
        int ncol = board[0].length;
        char c = word.charAt(i);
        
        if(row <0 || col <0 || row == nrow || col == ncol) return false;
        if(visited[row][col] == true){
        	return false;
        }
        
        if(c == board[row][col]){
        	//System.out.println(row + " " + col);
        	visited[row][col] = true;
            isexisted = existHelper(board, i+1, word, row, col+1) || existHelper(board, i+1, word, row +1, col) ||
                		existHelper(board, i+1, word, row, col-1) || existHelper(board, i+1, word, row-1, col);
            if(isexisted == false){
                visited[row][col] = false;
            }
            return isexisted;
        }else{
            return false;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch ws = new WordSearch();
		//char[][] board={{'a','b'},{'c','d'}};
		//System.out.println(ws.exist(board, "cdba"));
		char[][] board={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		System.out.println(ws.exist(board, "ABCESEEEFS"));
	}

}
