import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
        if((s.length()) > 12 | (s.length() < 4) )
            return null;
        List<String> result = new ArrayList<String>();
        isIpAddress(s, 0, 0, result, "");
        return result;
    }
    
    public void isIpAddress(String s, int start, int step, List<String> result, String ip) {
        int i = 0;
        if(step == 4 && start == s.length()) {
            result.add(ip);
        }
        else if(step < 4 && start < s.length()) {
            for (i = 1; i <= 3; i++) {
                if(start+i <= s.length()) {
                    String substr = s.substring(start, start+i);
                 
                    if(Integer.parseInt(substr) <=255) {
                    	if(i==1 | (i>1 && substr.charAt(0)!='0')) {
	                        if(step < 3) {
	                            isIpAddress(s, start+i, step + 1, result, ip + substr + ".");
	                        }else if(step == 3)
	                        {
	                            isIpAddress(s, start+i, step + 1, result, ip + substr);
	                        }
                    	}
                    }
                }
            }
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "010010";
		RestoreIPAddresses rip = new RestoreIPAddresses();
		ArrayList<String> list = (ArrayList<String>) rip.restoreIpAddresses(s);
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
