import java.util.ArrayList;


public class BullsandCows {

	public String getHint(String secret, String guess) {
		int bull = 0;
		int cow = 0;
        char[] secretchar = secret.toCharArray();
        char[] guesschar = guess.toCharArray();
        int[] countguess = new int[10];
        int[] countsecret = new int[10];
        ArrayList<Integer> bullpos = new ArrayList<Integer>();
        int i = 0;
        int index = 0;
        for(i = 0; i < guesschar.length; i++){
        	if(guesschar[i] == secretchar[i]){
        		bull ++;
        		bullpos.add(i);
        	}else{
        		index = guesschar[i] - '0';
            	countguess[index] ++;
        	}
        }
        for(i = 0; i < secretchar.length; i++){
        	if(!bullpos.contains(i)){
        		index = secretchar[i] - '0';		
        		countsecret[index] ++;
        	}
        }
        for(i = 0; i < 10; i++){
        	if(countguess[i] <= countsecret[i]){
        		cow = cow + countguess[i];
        	}else{
        		cow = cow + countsecret[i];
        	}
        }
        return bull + "A" + cow + "B";
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BullsandCows bc = new BullsandCows();
		System.out.println(bc.getHint("0111", "1234"));
	}

}
