
public class Numberof1Bits {

	public int hammingWeight(int n) {
		int res = 0;
		String str;
		int max = Integer.MAX_VALUE;
        if(n >= max){
            int tmp = n - max;
            str = Integer.toBinaryString(tmp);
            res = count(str) + 1;
        }else{
        	str = Integer.toBinaryString(n);
        	res = count(str);
        }
        return res;
    }
	
	private int count(String s){
		int cnt = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i)== '1'){
				cnt++;
			}
		}
		return cnt;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits nb = new Numberof1Bits();
		System.out.println(nb.hammingWeight(-5));
	}

}
