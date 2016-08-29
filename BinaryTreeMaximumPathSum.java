
public class BinaryTreeMaximumPathSum {

	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
		 TreeNode(int x) { val = x; }
	 }
	
	int maxlen;
    public int maxPathSum(TreeNode root) {
        maxlen = Integer.MIN_VALUE;
        int len = maxPathSumHelper(root);
        return maxlen;
    }
    
    /**
     * Two pathes: with or without least common ancesstor
     * 1. Node only
	2. L-sub + Node
	3. R-sub + Node
	4. L-sub + Node + R-sub

	Keep trace the four path and pick up the max one in the end.
     */
    private int maxPathSumHelper(TreeNode node){
        int left = 0;
        int right = 0;
        int len = 0;
        if(node == null){
            return 0;
        }else{
            if(node.left!=null){
                left = maxPathSumHelper(node.left);
            }
            if(node.right!=null){
                right = maxPathSumHelper(node.right);
            }
            len = node.val;
            if(left > 0){
                len = len + left;
            }
            if(right > 0){
                len = len + right;
            }
            maxlen = Math.max(len, maxlen);
            return Math.max(node.val, Math.max((left + node.val), (right + node.val)));
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
