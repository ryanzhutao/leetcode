
public class ReverseNodesinkGroup {

	private class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	/**
	 * @param args
	 */
	
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newhead = null;
        int i = 0;
        int j = 0;
        int pivotal = 0;
        int tmp = 0;
        if(head == null){
            return null;
        }
        if(k <= 1){
            return head;
        }
        int[] array = new int[k];
        ListNode node = head;
        ListNode node1 = null;
        ListNode newnode = null;
        //copy into array
        while(node != null){
            array[i] = node.val;
            i++;
            
            if(i==k){
                pivotal = k/2;
                //reverse the array
                for(j = 0; j < pivotal; j++){
                    tmp = array[j];
                    array[j] = array[k -1 -j];
                    array[k -1 -j] = tmp;
                }
                //add the sorted to newhead
                for(i = 0; i < k; i++){
                    if(newhead == null){
                        newhead = new ListNode(array[i]);
                        node1 = newhead;
                    }else{
                        newnode = new ListNode(array[i]);
                        node1.next = newnode;
                        node1 = node1.next;
                    }
                }
                i = 0;
            }
            node = node.next;
        }
        //add the remaining
        for(j = 0; j< i; j++){
            if(newhead == null){
                newhead = new ListNode(array[j]);
                node1 = newhead;
            }else{
                newnode = new ListNode(array[j]);
                node1.next = newnode;
                node1 = node1.next;
            }
        }
        return newhead;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		ReverseNodesinkGroup rng = new ReverseNodesinkGroup();
		ListNode list = new ListNode(i);
		ListNode node = list;
		for(i = 2; i <=5; i++){
			ListNode newnode = new ListNode(i);
			node.next = newnode;
			node = node.next;
		}
		ListNode head = rng.reverseKGroup(list, 2);
		node = head;
		while(node!=null){
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

}
