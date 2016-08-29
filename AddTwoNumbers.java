
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	
	private class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node3 = null;
        int carry = 0;
        int sum = 0;
        if(l1 == null && l2 == null){
            return null;
        }else if(l1 != null && l2 == null){
            return l1;
        }else if(l1 == null && l2 != null){
            return l2;
        }else{
            ListNode head = null;
            while(node1!=null | node2!=null | carry != 0){
                if(node1 != null && node2 != null){
                    sum = node1.val + node2.val + carry;
                    if(sum >= 10){
                        sum = sum -10;
                        carry = 1;
                    }else{
                        carry = 0;
                    }
                    if(head == null){
                        head = new ListNode(sum);
                        node3 = head;
                    }else{
                        ListNode node = new ListNode(sum);
                        node3.next = node;
                        node3 = node;
                    }
                    node1 = node1.next;
                    node2 = node2.next;
                }else if(node1 !=null && node2 == null){
                    sum = node1.val + carry;
                    if(sum >= 10){
                        sum = sum -10;
                        carry = 1;
                    }else{
                        carry = 0;
                    }
                    if(head == null){
                        head = new ListNode(sum);
                        node3 = head;
                    }else{
                        ListNode node = new ListNode(sum);
                        node3.next = node;
                        node3 = node;
                    }
                    node1 = node1.next;
                }else if(node1 == null && node2 != null){
                    sum = node2.val + carry;
                    if(sum >= 10){
                        sum = sum -10;
                        carry = 1;
                    }else{
                        carry = 0;
                    }
                    if(head == null){
                        head = new ListNode(sum);
                        node3 = head;
                    }else{
                        ListNode node = new ListNode(sum);
                        node3.next = node;
                        node3 = node;
                    }
                    node2 = node2.next;
                }else if(node1 == null && node2 == null && carry != 0){
                	ListNode node = new ListNode(carry);
                    node3.next = node;
                    node3 = node;
                	carry = 0;
                	
                }
            }
            return head;
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers a2 = new AddTwoNumbers();
		
		
	}

}
