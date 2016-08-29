import java.util.ArrayList;
import java.util.List;

public class PathSum {

	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        checkSum(root, 0, sum, new ArrayList<Integer>(), result);
        return result;
        
    }
    
    public void checkSum(TreeNode root, int parsum, int sum, ArrayList<Integer> list, List<List<Integer>> result) {
        int currentsum;
        if(root == null) {
            return;
        }
        currentsum = parsum + root.val;
        list.add(root.val);
        if(root.left==null && root.right ==null){
            if(sum == currentsum) {
                result.add(list);
            }
            
        }        
        if(root.left!=null)
            checkSum(root.left, currentsum, sum, list, result);
        if(root.right!=null)
            checkSum(root.right, currentsum, sum, list, result);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
