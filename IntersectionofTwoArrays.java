import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class IntersectionofTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
        //sort the two arrays
        int[] result = {};
        int i = 0;
        int prev = 0;
        List<Integer> list = new ArrayList<Integer>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 || len2 == 0){
            return result;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //compare max and min to see if there is interction
        if(nums1[0] > nums2[len2-1]){
            return result;
        }else if(nums2[0] > nums1[len1-1]){
            return result;
        }else{
            if(len1 <= len2){
                prev = nums1[0];
                if(binarySearch(prev, nums2, 0, len2-1)){
                    list.add(prev);
                }
                for(i = 1; i< len1; i++){
                    if(nums1[i]!= prev){
                        if(binarySearch(nums1[i], nums2, 0, len2-1)){
                            list.add(nums1[i]);
                        }
                    }
                }
            }else{
                prev = nums2[0];
                if(binarySearch(prev, nums1, 0, len1-1)){
                    list.add(prev);
                }
                for(i = 1; i< len2; i++){
                    if(nums2[i]!= prev){
                        if(binarySearch(nums2[i], nums1, 0, len1-1)){
                            list.add(nums2[i]);
                        }
                    }
                }
            }
        }
        result = list.toArray(new Integer[list.size()]);
        return result;
    }
    
    private boolean binarySearch(int target, int[] array, int low, int high){
        if(high >= low){
            int mid = low + (high-low)/2;
            if(target == array[mid]){
                return true;
            }else{
                if(target < array[mid]){
                    return binarySearch(target, array, low, mid -1);
                }else{
                    return binarySearch(target, array, mid+1, high);
                }
            }
        }    
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
