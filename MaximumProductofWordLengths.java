
public class MaximumProductofWordLengths {

	 public int maxProduct(String[] words) {
	        int len = words.length;
	        int num1 = 0;
	        int num2 = 0;
	        int i = 0;
	        int j = 0;
	        if(len == 0){
	            return 0;
	        }
	        int max = 0;
	        int[] array = new int[len];
	        for(i = 0; i < len; i++){
	            String word = words[i];
	            array[i] = 0;
	            char[] chararray = word.toCharArray();
	            for(char c : chararray){
	                array[i]|= 1<<(c-'a');
	            }
	        }
	        for(i = 0; i < len; i++){
	            num1 = array[i];
	            for(j = i+1; j < len; j++){
	                num2 = array[j];
	                if((num1 & num2) == 0){
	                    if((words[i].length()*words[j].length())>max){
	                        max = words[i].length()*words[j].length();
	                    }
	                }
	            }
	        }
	        return max;
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
