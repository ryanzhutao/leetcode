
public class ReverseLinkedList2 {
	
	private class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public ListNode reverseBetween(ListNode head, int m, int n) {
		 if(m == n){
	            return head;
	        }
	        int num = n - m + 1;
	        int nswap = num/2;
	        int i = 0;
	        int mmove = m - 1;
	        int moves = 0;
	        ListNode start = head;
	        ListNode end = null;
	        int tmp = 0;
	        //move to mnode
	        while(mmove > 0 && start!=null){
	            start = start.next; 
	            mmove --;
	        }
	        for(i = 0; i <nswap; i++){
	            end = start;
	            moves = (n-m) -2*i;
	            while(moves >0 && end!=null){
	                end = end.next;
	                moves--;
	            }
	            //swap
	            tmp = start.val;
	            start.val = end.val;
	            end.val = tmp;
	            start = start.next;
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
