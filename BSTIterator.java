import java.util.Stack;


public class BSTIterator {

	/**
	 * idea: http://yuanhsh.iteye.com/blog/2173429
	 * @author Tao Zhu
	 *
	 */
	private class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	}
	
	Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushleft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if(node.right!=null){
            pushleft(node.right);
        }
        return node.val;
    }
    
    public void pushleft(TreeNode node){
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
