
public class SumofTwoIntegers {

	public int getSum(int a, int b) {
        int i = 0;
        int alower = 0;
        int blower = 0;
        int carry = 0;
        int result = 0;
        for(i = 0; a>0 || b>0; i++){
            alower = a &1;
            blower = b &1;
            result |= (alower ^ blower ^ carry) << i;
            carry = (alower & carry) | (blower & carry) | (alower & blower);
            a >>= 1;
            b >>= 1;
        }
        if(carry == 1){
        	result |= carry << i;
        }
        return result;
    }
	
	public int getSum1(int a, int b) {
		while (b != 0) {
			int c = a & b; //carry
			a ^= b; //add 
			b = c << 1;
		}
		return a;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumofTwoIntegers si = new SumofTwoIntegers();
		System.out.println(si.getSum(-1, 1));
	}

}
