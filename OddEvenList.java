
public class OddEvenList {
	private class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) { val = x; }
		 }
	
	public ListNode oddEvenList(ListNode head) {
		if(head == null){
            return null;
        }
        ListNode evenhead = null;
        ListNode even = null;
        ListNode evennext = null;
        ListNode oddhead = head;
        ListNode odd = oddhead;
        while(odd!= null){  
            if(odd.next != null){
            	evennext = odd.next;
                if(evenhead == null){
                    evenhead = evennext;
                    even = evenhead;
                }else{
                    even.next = evennext;
                    even = even.next;
                }
                odd.next = odd.next.next;
                if(odd.next != null){
                    odd = odd.next;
                }
            }else{
            	break;
            }
        }
        
        if(even != null){
            even.next = null;
        }
        odd.next = evenhead;
        return oddhead;
        
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
