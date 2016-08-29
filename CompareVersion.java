
public class CompareVersion {

	/**
	 * @param args
	 */
	public int compareVersion(String version1, String version2) {
        int[] v1;
        int[] v2;
        int i = 0;
        int len = 0;
        int result = -2;
        if(version1.contains(".")){
            String[] v1arr = version1.split("\\.");
            len = v1arr.length;
            v1 = new int[len];
            for(i = 0; i < len; i++){
                v1[i] = Integer.parseInt(v1arr[i]);
            }
        }else{
            v1 = new int[1];
            v1[0] = Integer.parseInt(version1);
        }
        if(version2.contains(".")){
           String[] v2arr = version2.split("\\.");
            len = v2arr.length;
            v2 = new int[len];
            for(i = 0; i < len; i++){
                v2[i] = Integer.parseInt(v2arr[i]);
            }
        }else{
             v2 = new int[1];
             v2[0] = Integer.parseInt(version2);
        }
        //System.out.println(v1.length + " " + v2.length);
        len = v1.length <= v2.length?v1.length:v2.length;
        
        for(i = 0; i < len; i++){
            if(v1[i] == v2[i]){
                result = 0;
            }else if(v1[i] > v2[i]){
                result = 1;
                break;
            }else{
                result = -1;
                break;
            }
        }
        if(result == 0){
            if(v1.length == v2.length){
                result = 0;
            }else if(v1.length < v2.length){
                for(i = v1.length; i< v2.length; i++){
                    if(v2[i]!= 0){
                        result = -1;
                        break;
                    }
                }
            }else{
                for(i = v2.length; i< v1.length; i++){
                    if(v1[i]!= 0){
                        result = 1;
                        break;
                    }
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompareVersion cv = new CompareVersion();
		System.out.println(cv.compareVersion("1", "1.1"));
	}

}
