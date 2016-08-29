import java.util.ArrayList;


public class ConvertSortedListtoBinarySearchTree {

	private class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
		
		 public class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
		 
		 
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        ListNode node = head;
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        TreeNode root = buildTree(list, 0, list.size() -1);
        return root;
    }
    
    private TreeNode buildTree(List<Integer> list, int low, int high){
        if(high >= low){
            int mid = low + (high -low)/2;
            int val = list.get(mid);
            TreeNode node = new TreeNode(val);
            node.left = buildTree(list, low, mid -1);
            node.right = buildTree(list, mid + 1, high);
            return node;
        }else{
            return null;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
