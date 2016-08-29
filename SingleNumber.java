import java.util.Arrays;


public class SingleNumber {

	
	public int singleNumber(int[] A) {
		int i;
		if(A.length == 1)
			return A[0];
		else if(A.length > 1)
		{
			Arrays.sort(A);
			if(A[A.length-1] != A[A.length-2])
				return A[A.length-1];
			for( i = 0; i < A.length-1; i = i+2 ) {
				if( A[i] != A[i+1]) {
					return A[i];
				}		
			}
		}
		return -1;
    }
	
	public int singleNumber1(int[] A) {
		int result = 0;
	    for (int i = 0; i < A.length; i++)
	    {
	        result ^=A[i];
	    }
	    return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber sn = new SingleNumber();
		
		int[] array = new int[19999];
		for(int i = 0; i<19997; i= i+2) {
			array[i] = i/2;
			array[i+1] = i/2;
			
		}
		array[19998]=10000;
	
		//int[] array = {1, 2, 3, 4, 3, 2, 1};
		System.out.println(sn.singleNumber1(array));
	}

}
