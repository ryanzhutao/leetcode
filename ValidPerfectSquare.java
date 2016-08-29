
public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {
		if(num == 1){
			return true;
		}
        int sqrt = getSqrt(num);
        if(sqrt * sqrt == num){
        	return true;
        }else{
        	return false;
        }
    }
    
    public int getSqrt(int num){
        int low = 1;
        int high = num/2 + 1;
        return binarysearch(low, high, num);
    }
    
    private int binarysearch(int low, int high, int x){
    	 while(high >= low){
             int mid = (low + high)/2;
             //get the 
             int sqrt = x /mid;
             if((mid <= sqrt) && (x/(mid+1)<(mid + 1))){
                 return mid;
             }else if(sqrt > mid){
                 low = mid + 1;
             }else{
                 high = mid -1;
             }
         }
         return high;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPerfectSquare vps = new ValidPerfectSquare();
		System.out.println(vps.isPerfectSquare(9));
	}

}
