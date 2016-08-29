
public class ValidNumber {

	public boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        char[] arrays = s.toCharArray();
        int cntdot = 0;
        int cnte = 0;
        int cntnum = 0;
        String[] strs;
        int posdot = 0;
        int pose = 0;
        boolean sign = false;
        
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i] == '.'){
                cntdot++;
                posdot = i;
            }else if(arrays[i] == 'e'){
                cnte++;
                pose = i;
            }else if(arrays[i] == '+' | arrays[i] == '-'){
                if(i!=0){
                	if(arrays[i-1]!='e'){
                		return false;
                	}
                }
                if(i==0){
                	sign = true;
                }
            }else if(arrays[i] == ' '){
                return false;
            }
            else{
                if(('0' <= arrays[i]) && (arrays[i]<='9')){
                    cntnum++;
                }else{
                	return false;
                }
            }
        }
        //only has e
        if(cntnum == 0){
        	return false;
        }
        if(cnte == 1 && cntdot == 0){
            strs = s.split("e");
            if(strs.length!=2){
                return false;
            }else{
            	if(sign){
            		return (strs[0].length() > 1 && isNum(strs[1]));
            	}else{
            		return (strs[0].length() > 0 && isNum(strs[1]));
            	}
            }
        }else if(cntdot==1 && cnte == 0){
        	//only has dot
            strs = s.split("\\.");
           // System.out.println(strs.length);
            if(strs.length == 1){
                return (strs[0].length() > 0);
            }else if(strs.length == 2){
                if(strs[0].length()==0){
                    return (strs[1].length() > 0);
                }else{
                    //System.out.println(strs[0] + " " + strs[1]);
                    return (strs[0].length() > 0 && strs[1].length() > 0);
                }
            }else{
                return false;
            }
            //has both e and dot
        }else if(cntdot== 1 && cnte==1){
        	if(posdot > pose){
        		return false;
        	}else{
	        	strs = s.split("\\.");
	        	if(strs.length!=2){
	        		return false;
	        	}else{
		        	
		        		String[] strse = s.split("e");
		        		// .e1(n) 0.28e1(y)
	        			if(strse[0].length()==1){
	        				return false;
	        			}
		        		if(strse.length == 2){
		        			if(strse[1].length()==0){
		        				return false;
		        			}else{
		        				return true;
		        			}
		        		}else{
		        			return false;
		        		}
		        	
	        	}
        	}
        }else if(cntdot== 0 && cnte==0){
        	return true;
        }else{
        	return false;
        }
    }
	
	private boolean isNum(String s){
		char[] chars = s.toCharArray();
		int i = 0;
		if(chars[0] == '+' || chars[0] == '-'){
			if(chars.length == 1){
				return false;
			}else{
				for(i = 1; i < chars.length; i++){
					if(!(('0' <= chars[i]) && (chars[i]<='9'))){
						return false;
					}
				}
				
			}
		}else{
			for(i = 0; i < chars.length; i++){
				if(!(('0' <= chars[i]) && (chars[i]<='9'))){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("4e+1831773"));
	}

}
