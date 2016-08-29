
public class ConvertSortedArraytoBinarySearchTree {

	private class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	/**
	 * @param args
	 */
	
	 public TreeNode sortedArrayToBST(int[] nums) {
	        TreeNode root = recursiveAddNode(nums, 0, nums.length -1);
	        return root;
	    }
	    
	    public TreeNode recursiveAddNode(int[] nums, int low, int high){
	        if(high >= low){
	            int mid = low + (high-low)/2;
	            TreeNode node = new TreeNode(nums[mid]);
	            node.left = recursiveAddNode(nums, low, mid -1);
	            node.right = recursiveAddNode(nums, mid +1, high);
	            return node;
	        }else{
	            return null;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
