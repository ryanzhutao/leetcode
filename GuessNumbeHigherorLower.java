
public class GuessNumbeHigherorLower {

	public int guessNumber(int n) {
        return guessHelper(0, n);
    }
    /**
    public int guessHelper(int low, int high){
        int mid = low/2 + (high-low)/2;
        int judge = guess(mid);
        if(judge == 0){
            return mid;
        }else if(judge == -1){
            return guessHelper(mid+1, high);
        }else{
            return guessHelper(low, mid-1);
        }
    }*/
    
    public int guessHelper(int low, int high){
        int mid = -1;
        int judge = 0;
        while(low<=high){
            mid = low + (high-low)/2;
            judge = guess(mid);
            if(judge == 1){
                low = mid+1;
            }else if (judge == -1){
                high = mid-1;
            }else{
                break;
            }
            
        }
        return mid;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
