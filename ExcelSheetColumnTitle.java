
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		int digit = n;
        int reminder = 0;
        String title = "";
        reminder = 0;
        while(digit> 0){
        	
            reminder = (digit-1) % 26;
            digit = (digit-1)/26;
            title = convertNumToChar(reminder) + title;
            
        }
        return title;
    }
    
    private char convertNumToChar(int num){
    	char c = (char) (num + 'A');
        return c;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle(52));
		//System.out.println(esct.convertToTitle(52));
	}

}
