import java.util.ArrayList;
import java.util.List;


public class CountingBits {

	
	public int[] countBits(int num) {
        int[] res = new int[num + 1];
        String s = Integer.toString(num,2);
        int i = 0;
        int len = s.length();
        int val = 0;
        List<Integer> list = new ArrayList<Integer>();
        //len = 1
        list.add(0);
        int j = 0;
        int numbits;
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        List<Integer> tmp = null;
        if(num >= 1){
        	//len = 1
        	list.add(1);
        	for(i = 2; i <= len -1; i++){
        		tmp = new ArrayList<Integer>(list);
        		for(j = 0; j < tmp.size(); j++){
        			numbits = tmp.get(j);
        			list.add(numbits + 1);
        			
        		}
        		tmp = null;
        	}
        	if(num > 1){
	        	    //last round
	        	for(i = 1; i < len; i++){
	        		sb.append("0");
	        	}
	        	int lowbound = Integer.parseInt(sb.toString(), 2);
	        	tmp = new ArrayList<Integer>(list);
	        	for(i= 0; i <= (num-lowbound); i++){
	        		numbits = tmp.get(i);
	    			list.add(numbits + 1);
	        	}
        	}
        	tmp = null;
        }
        for(i = 0; i < list.size(); i++){
        	res[i] = list.get(i);
        }
        list = null;
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountingBits cb = new CountingBits();
		int[] arr = cb.countBits(5);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
	}

}
