
public class RemoveDuplicatesfromSortedList2 {

	
	public ListNode deleteDuplicates(ListNode head) {
		int dup = 0;
        if(head == null){
            return head;
        }
        //make a dummy head in case head is removed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        ListNode lastdiff = dummy;
        while(node.next!=null && node.next.next!=null){
            if(node.next.val == node.next.next.val){
                node = node.next;
                dup = node.val;
                //System.out.println(lastdiff.val + " " + node.val + " " + node.next.val);
                while(node.next.next!=null){
                	if(node.next.next.val == dup){
                		node = node.next;
                	}else{
                		break;
                	}
                }
                lastdiff.next = node.next.next;
                node = lastdiff;
            }else{
            	//System.out.println("diff: " + lastdiff.val);
                node = node.next;
                lastdiff = node;
            }            
        }
        
        return dummy.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesfromSortedList2 rd = new RemoveDuplicatesfromSortedList2();
		int[] array = {1, 2, 3, 3, 4, 4, 5};
		int i = 0;
		ListNode head = new ListNode(array[0]);
		ListNode node = head;
		for(i = 1; i < array.length; i++){
			ListNode newnode = new ListNode(array[i]);
			node.next = newnode;
			node = node.next;
		}
		
		node.next = null;
		head = rd.deleteDuplicates(head);
		node = head;
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}

}
