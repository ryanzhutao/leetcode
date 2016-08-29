
public class StringMultiple {

	/**      
	 *        1   2   3  #i(0, 1, 2)
	 *        *   4   5  #j(0, 1) 
	 *  --------------------
	 *            1   5
	 *        1   0
	 *    0   5
	 *        1   2
	 *    0   8
	 * 0  4
	 * ----------------------  
	 #(0, 1,  2,  3,  4)    
	 * num1[i]*num[j] = num[i+j, i+j+1]
	 * 
	 * @return
	 */
	public String multiply(String num1, String num2) {
        int size1 = num1.length();
        int size2 = num2.length();
        String resultstr = "";
        int bit1 = 0;
        int bit2 = 0;
        int carry = 0;
        int i = 0;
        int j = 0;
        int tmp = 0;
        //save the sum for every bit
        if(num1.equals("0") | num2.equals("0")){
        	return "0";
        }
        int[] result = new int[size1 + size2];
        for(i = 0; i < size1; i++){
        	for(j = 0; j < size2; j++){
        		bit1 = num1.charAt(i) - '0';
        		bit2 = num2.charAt(j) - '0';
        		tmp = bit1 * bit2;
        		result[i+j] += tmp/10;
        		result[i+j+1] += tmp%10;
        		
        	}
        }
        for(i = size1 + size2 -1; i >0; i--){
        	tmp = result[i] + carry;
        	carry = tmp/10;
        	resultstr = (tmp%10) + resultstr;
        }
        //first bit
        tmp = result[i] + carry;
        if(tmp != 0){
        	resultstr = tmp + resultstr;
        }
        
        return resultstr;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
