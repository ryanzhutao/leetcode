


public class RotateRight {
	
	
	private class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	      }
	 }
	ListNode head;
	
	public void construct()
	{
		head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		head.next = node1;
		/**
		ListNode node2 = new ListNode(3);
		node1.next = node2;
		ListNode node3 = new ListNode(4);
		node2.next = node3;
		ListNode node4 = new ListNode(5);
		node3.next = node4;
		*/
	}
	
	public ListNode rotateRight(int n) {
        int i = 0;
        ListNode oldhead = head;
        ListNode node = head;
        ListNode tail = null;
        
        if(head == null)
            return null;
        int length = 1;
        if(head.next == null)
            return head;
        if(n == 0)
            return head;
        while(node.next!=null) {
            length ++;      
            node=node.next;
        }
        n = n%length;
        if(n == 0)
            return head;
        tail = node;
        node = head;
        for(i=1; i<=length-n-1; i++) {
            node=node.next;
        }
        head = node.next;
        node.next=null;
        tail.next = oldhead;
        return head;
    }
	
	public void print() {
		ListNode node = head;
		while(node!=null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RotateRight rr = new RotateRight();
		rr.construct();
		rr.rotateRight(2);
		rr.print();
	
	}

}
