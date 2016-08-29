
public class AddBinary {

	/**
	 * @param args
	 */
	public String addBinary(String a, String b) {
        int i = 0;
        int diff = 0;
        int alen = a.length();
        int blen = b.length();
        int carry = 0;
        int len = Math.max(alen, blen);
        if(alen < blen){
            diff = blen - alen;
            for(i = 0; i < diff; i++){
                a = "0" + a;
            }
        }else if(alen > blen){
            diff = alen - blen;
            for(i = 0; i < diff; i++){
                b = "0" + b;
            }
        }
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        String result = "";
        int bita = 0;
        int bitb = 0;
        int sum = 0;
        for(i = len -1; i >=0; i--){
            bita = Integer.parseInt(String.valueOf(chara[i]));
            bitb = Integer.parseInt(String.valueOf(charb[i]));
            sum = bita + bitb + carry;
            if(sum == 2){
                sum = 0;
                carry =1;
            }
            result = sum + result;
        }
        if(carry == 1){
            result = carry + result;
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
