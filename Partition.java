
public class Partition {

	public class ListNode {
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
		/**
		head = new ListNode(1);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(2);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		*/
		head = new ListNode(1);
		ListNode n1 = new ListNode(1);
		head.next = n1;
		n1.next = null;
	}
	
	
	public void print()
	{
		ListNode node = head;
		while( node!=null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println("");
	}
	/**
	 * @param args
	 */
	public ListNode partition(int x) {
        ListNode node = head;
       
        ListNode tail = head;
        if(head == null)
            return null;
  
        while(node.next!=null) {
            node = node.next;
        }
        tail = node;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode newtail = tail;
        node = newhead;
        while(node!=tail) {
            if(node.next.val >= x) {
            	System.out.println(node.val+ " " + node.next.val);
                ListNode nnext = node.next.next;
                newtail.next = node.next; 
                node.next = nnext;
                newtail = newtail.next;
                newtail.next = null;
                
            }
            else
            	node = node.next;
        }
        head = newhead.next;
        newhead = null;
        return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Partition p = new Partition();
		p.construct();
		p.print();
		p.partition(0);
		p.print();

	}

}
