import java.util.HashSet;
import java.util.Set;


public class IsUgly {

	/**
	 * @param args
	 */
	public boolean isUgly(int num) {
        int[] divisors = {2, 3, 5}; 
        if(num == 1){
            return true;
        }else if(num < 1){
            return false;
        }else{
            for(int divisor: divisors){
                while((num % divisor) == 0){
                    num = num/divisor;
                }
            }
            if(num == 1){
                return true;
            }else{
                return false;
            }
        }
        
    }
	
	public boolean isHappy(int n) {
		//use set to find repeated one
		Set<Integer> set = new HashSet<Integer>();
        while(n!=1){
        	if(set.contains(n)){
        		return false;
        	}else{
        		set.add(n);
        	}
        	n = getSum(n);
        }
        return true;
    }
	
	private int getSum(int n){
		 String str = Integer.toString(n);
	     char[] chars = str.toCharArray();
	     int sum = 0;
	     int len = str.length();
	     int i = 0;
	     int[] bits = new int[len];
	     for(i = 0; i < len; i++){
	        bits[i] = Integer.parseInt(String.valueOf(chars[i]));
	        sum+=bits[i]*bits[i];
	     }
	     return sum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
