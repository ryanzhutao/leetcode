
public class Sqrt {

	public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int low = 1;
        int high = x/2 + 1;
        return binarysearch(low, high, x);
    }
    
    public int binarysearch(int low, int high, int x){
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
		Sqrt sqrt = new Sqrt();
		System.out.println(sqrt.mySqrt(2));
	}

}
