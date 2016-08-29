
public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int i = 0;
        if(words.length != pattern.length()){
            return false;
        }
        HashMap<String, Character> map = new HashMap<String, Character>();
        for(i = 0; i < pattern.length(); i++){
            String s = words[i];
            Character c = map.get(s);
            if(c == null){
                map.put(s, pattern.charAt(i));
            }else{
                if(c != pattern.charAt(i)){
                    return false;
                }
                
            }
        }
        Object[] objvalues = map.values().toArray();
        char[] values = new char[objvalues.length];
        for(i = 0; i < objvalues.length; i++){
            values[i] = (char)(objvalues[i]);
        }
        Arrays.sort(values);
        char pre = values[0];
        for(i = 1; i < values.length; i++){
            char current = values[i];
            if(pre == current){
                return false;
            }else{
                pre = current;
            }
        }
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
