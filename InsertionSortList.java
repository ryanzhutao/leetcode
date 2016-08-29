
public class InsertionSortList {

	private class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode node = head;
        ListNode p = null;
        while(node.next!=null){
            //compare and insert
            ListNode next = node.next.next;
            p = head;
            //node.next.val < head
            if(node.next.val < head.val){
                node.next.next = head;
                head = node.next;
                node.next = next;
            }else{
                //node.next.val >= head
                while(node.next.val >= p.val && p!=node){
                    p = p.next;
                }
                //insert into before
                if(p!=node){
                    node.next.next = p.next;
                    p.next = node.next;
                    node.next = next;
                }else{
                    //node.val is the biggest
                    node = node.next;
                }
            }
            
        }
        return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
