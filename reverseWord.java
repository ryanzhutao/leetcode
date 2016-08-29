
public class reverseWord {

	
	public String reverseWords(String s) {
        int i;
        String[] array = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (i = array.length-1; i > 0; i--) {
            sb.append(array[i]+" ");
        }
        sb.append(array[0]);
        return sb.toString();
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		reverseWord rw = new reverseWord();
		System.out.println(rw.reverseWords(s));
	}

}
