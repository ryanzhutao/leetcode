
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1;
        int j = n -1;
        int k = m + n - 1;
        while(i >= 0 && j>=0){
        	if(nums1[i] > nums2[j]){
        		nums1[k--] = nums1[i--];
        	}else if(nums1[i] < nums2[j]){
        		nums1[k--] = nums2[j--];
        	}else{
        		nums1[k--] = nums2[j--];
        		nums1[k--] = nums1[i--];
        	}
        }
        while(j>=0){
        	nums1[k--] = nums2[j--];
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortedArray msa = new MergeSortedArray();
		//int[] nums1 = {1,2,3,4,5,0};
		//int[] nums2 = {3};
		//msa.merge(nums1, 5, nums2, 1);
		int[] nums1 = {0};
		int[] nums2 = {1};
		
		msa.merge(nums1, 0, nums2, 1);
	}

}
