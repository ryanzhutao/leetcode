import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class LargestNumber {

	/**
	private class Number{
        int num;
        int length;
        int extendednum;
        
        public Number(int n, int l){
            num = n;
            length = l;
        }
        public int getNum(){
            return num;
        }
        public int getLength(){
            return length;
        }
        public void setExtendednum(int el){
            int numzero = 0;
            int i = 0;
            extendednum = num;
            if(length < el){
                numzero = el - length;
                for(i = 0; i < numzero; i++){
                    extendednum = extendednum * 10;
                }
            }
        }
        public int getExtendednum(){
        	return extendednum;
        }
    }
	ArrayList<Number>[] lists;
	int[] maxlen;
	
    public String largestNumber(int[] nums) {
    	int i = 0;
    	int j = 0;
        String result = "";
        int maxl;
        
        catergory(nums);
        //extend
        for(ArrayList<Number> list : lists){
        	maxl = maxlen[i];
        	for(j = 0; j < list.size(); j++){
        		list.get(j).setExtendednum(maxl);
        	}
        	i++;
        }
        //sort
        sort();
    	for(i = 8; i >= 0; i--){
    		ArrayList<Number> list = lists[i];
    		for(j = 0; j < list.size(); j ++){
    			result = result + list.get(j).getNum();
    		}
    	}
        return result;
    }
    
    public void catergory(int[] nums){
    	lists = new ArrayList[9];
        maxlen = new int[9];
        int size = nums.length;
        int i = 0;
        int length = 0;
        for(i = 0; i < 9; i++){
        	lists[i] = new ArrayList<Number>();
        }
        for(i = 0; i < size; i++){
            String str = Integer.toString(nums[i]);
            length = str.length();
            Number n = new Number(nums[i], length);
            if(str.charAt(0) == '1'){
            	lists[0].add(n);
            	if(length > maxlen[0]){
            		maxlen[0] = length;
            	}
            }else if(str.charAt(0) == '2'){
            	lists[1].add(n);
            	if(length > maxlen[1]){
            		maxlen[1] = length;
            	}
            }else if(str.charAt(0) == '3'){
            	lists[2].add(n);
            	if(length > maxlen[2]){
            		maxlen[2] = length;
            	}
            }else if(str.charAt(0) == '4'){
            	lists[3].add(n);
            	if(length > maxlen[3]){
            		maxlen[3] = length;
            	}
            }else if(str.charAt(0) == '5'){
            	lists[4].add(n);
            	if(length > maxlen[4]){
            		maxlen[4] = length;
            	}
            }else if(str.charAt(0) == '6'){
            	lists[5].add(n);
            	if(length > maxlen[5]){
            		maxlen[5] = length;
            	}
            }else if(str.charAt(0) == '7'){
            	lists[6].add(n);
            	if(length > maxlen[6]){
            		maxlen[6] = length;
            	}
            }else if(str.charAt(0) == '8'){
            	lists[7].add(n);
            	if(length > maxlen[7]){
            		maxlen[7] = length;
            	}
            }else if(str.charAt(0) == '9'){
            	lists[8].add(n);
            	if(length > maxlen[8]){
            		maxlen[8] = length;
            	}
            }
        }
    }
    
    
    public void sort(){
    	int i = 0;
    	Comparator<Number> comparator = new Comparator<Number>() {
			public int compare(Number n1, Number n2) {
				int result;
				result = n1.getExtendednum() - n2.getExtendednum();
				if(result < 0){
					result = 1;
				}else if(result > 0){
					result = -1;
				}else{
					result = n1.getLength() - n2.getLength();
					if(result < 0){
						result = - 1;
					}else if(result > 0){
						result = 1;
					}
				}
				return result;
			}
		};
		for(i = 0; i < lists[2].size(); i++){
			System.out.print(lists[2].get(i).getExtendednum() + " ");
		}
		System.out.println("");
		for(ArrayList<Number> list: lists){
			Collections.sort(list, comparator);
		}
		for(i = 0; i < lists[2].size(); i++){
			System.out.print(lists[2].get(i).getExtendednum() + " ");
		}
		System.out.println("");
    }
    */
   
	/**
	 * @param args
	 */
	
	public String largestNumber(int[] nums) {
		int i = 0;
        String result = "";
        ArrayList<String> list = new ArrayList<String>();
        int numzero = 0;
        for(int num : nums){
        	list.add(Integer.toString(num));
        	if(num == 0){
        	    numzero ++;
        	}
        }
        if(numzero == nums.length){
            return "0";
        }
        Comparator<String> comparator = new Comparator<String>() {
			public int compare(String s1, String s2) {
				String s12 = s1 + s2;
				String s21 = s2 + s1;
				return s21.compareTo(s12);
			}
        };
        Collections.sort(list, comparator);
        for(i = 0; i < list.size(); i++){
        	result+= list.get(i);
        }
    
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestNumber ln = new LargestNumber();
		int[] nums = {3, 30, 34, 5, 9};
		//int[] nums = {3, 30, 31, 312};
		System.out.println(ln.largestNumber(nums));
	}

}
