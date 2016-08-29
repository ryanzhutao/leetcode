import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
        int i = 0;
        int j = 0;
        int cnt = (n-1) * 2;
        String ts = "";
        List<String> result = new ArrayList<String>();
        if(n <= 0){
            return result;
        }
        result.add("(");
        for(i = 0; i < cnt; i++){
            List<String> tmp = new ArrayList<String>();
            for(j = 0; j < result.size(); j++){
                tmp.add(result.get(j) + "(");
                tmp.add(result.get(j) + ")");
            }
            result = tmp;
            tmp = null;
        }
        List<String> tmp = new ArrayList<String>();
        for(String s : result){
        	ts = s + ")";
        	if(check(ts)){
        		tmp.add(ts);
        	}
        }
        return tmp;
    }
	
	private boolean check(String s){
		char[] chars = s.toCharArray();
		int i = 0;
		int cnt = 0;
		//skip the first
		for(i = 0; i < chars.length; i++){
			if(chars[i]=='('){
				cnt--;
			}else if (chars[i]==')'){
				cnt++;
			}
			
			if(cnt > 0){
				return false;
			}
		}
		if(cnt==0){
			return true;
		}else{
			return false;
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses gp = new GenerateParentheses();
		List<String> list = gp.generateParenthesis(3);
		for(String s: list){
			System.out.println(s);
		}
	}

}
