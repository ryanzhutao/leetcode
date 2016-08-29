
public class PartitionList {
	
	private class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
	}
	
	 public ListNode partition1(ListNode head, int x) {
		 ListNode xnode = head;
	        ListNode node = head;
	        ListNode tmp;
	        if(head == null){
	            return head;
	        }
	        while(xnode.next!=null){
	            if(xnode.next.val == x){
	                break;
	            }
	            xnode = xnode.next;
	        }
	        ListNode xnodepre = xnode;
	        xnode = xnode.next;
	        if(xnode == null){
	            return head;
	        }
	        node = xnode;
	        //scan from the one after xnode, find less x and add it after prexnode
	        while(node.next!=null){
	            if(node.next.val < x){
	            	tmp = node.next;
	                node.next = node.next.next;
	                tmp.next = null;
	                xnodepre.next = tmp;
	                xnodepre = xnodepre.next;
	            }else{
	                node = node.next;
	            }
	        }
	        //scan from first, find greater than inser into between xnode and xnode.next
	        ListNode sechalf = xnode;
	        node.next = head;
	        ListNode newhead = node;
	        while(node.next != null){
	        	if(node.next.val > x){
	        		tmp = node.next;
	        		node.next = node.next.next;
	        		tmp.next = xnode.next;
	        		xnode.next = tmp;
	        		xnode = xnode.next;
	        	}
	        	else{
	                node = node.next;
	            }
	        }
	        xnodepre.next = sechalf;
	        return newhead.next;
             
	    }
	 
	 public ListNode partition(ListNode head, int x) {
		 if(head == null){
			 return head;
		 }
		 ListNode firsthalf = null;
		 ListNode secondhalf = null;
		 ListNode node = head;
		 ListNode node1 = null;
		 ListNode node2 = null;
		 while(node!= null){
			 ListNode nextnode = node.next;
			 if(node.val < x){
				 if(firsthalf == null){
					 firsthalf = new ListNode(node.val);
					 node1 = firsthalf;
				 }else{
					 node.next = null;
					 node1.next = node;
					 node1 = node1.next;
				 }
			 }else{
				 if(secondhalf == null){
					 secondhalf = new ListNode(node.val);
					 node2 = secondhalf;
				 }else{
					 node.next = null;
					 node2.next = node;
					 node2 = node2.next;
				 }
			 }
			 node = nextnode;
		 }
		 if(secondhalf != null & firsthalf !=null){
			 node1.next =  secondhalf;
			 node2.next = null;
		 }
		 if(firsthalf == null){
			 return secondhalf;
		 }else{
			 return firsthalf;
		 }
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
