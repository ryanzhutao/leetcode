
public class IntegerBreak {

	public int integerBreak(int n) {
		int result = 1;
		if(n == 2 | n == 3){
			return n-1;
		}
		while(n > 4){
			result= result *3;
			n = n -3;
		}
		result = result *n;
		return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
