package Assignment3;

public class PartitionList {
	static class ListNode {
		 public int val;
		 public ListNode next;
		 ListNode(int x) { val = x; next = null; }
		 ListNode(int x,ListNode next) { val = x; this.next = next; }
	}
	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// input keys
		//int[] keys = { 5,4,3,2,1 };
		//int value = 5;
		int[] keys = { 2,5,2,3,4,1 };
		int value = 3;
		//int[] keys = { 1 };
		//int value = 1;

		ListNode head = null;
		for (int key: keys) {
			head = new ListNode(key,head);
		}
		printList(head);
		
		printList(partition1(head,value));

	}
	
	// Helper function to print given linked list
		public static void printList(ListNode head)
		{
			ListNode temp = head;
			while (temp != null)
			{
				System.out.print(temp.val + " -> ");
				temp = temp.next;
			}

			System.out.println("null");
		}
	public static ListNode partition1(ListNode A, int B) {
        ListNode lessThanHead = null;
        ListNode lessThanTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        
        ListNode head = A;
        
        while(head != null){
        	ListNode next = head.next;
            if(head.val < B){
                if(lessThanHead == null){
                    lessThanHead = head;
                }else{
                	lessThanTail.next = head;
                }
                lessThanTail = head;
                lessThanTail.next = null;
                
            }else if(head.val >= B){
                if(greaterHead == null ){
                	greaterHead = head;
                }else{
                	greaterTail.next = head;
                }
                greaterTail = head;
                greaterTail.next = null;
            }
            head = next;
        }
        
        if(lessThanHead == null) {
        	return greaterHead;
        }
        
        if(greaterHead != null) {
        	lessThanTail.next = greaterHead;
        }
        
        /*head = lessThanHead;
        ListNode temp = head;
        
        while(temp!=null && temp.next!=null){
            temp = temp.next;
        }
        temp.next = equalsHead;
        while(temp!=null && temp.next!=null){
            temp = temp.next;
        }
        temp.next = greaterHead;
        return head;*/
        
        return lessThanHead;
    }
	public static ListNode partition(ListNode A, int B) {
        ListNode lessThanHead = null;
        ListNode lessThanTail = null;
        //ListNode equalsHead = null;
        //ListNode equalsTail = null;
        ListNode greaterHead = null;
        ListNode greaterTail = null;
        
        ListNode head = A;
        
        while(head != null){
            if(head.val < B){
                if(lessThanHead == null && lessThanTail == null){
                    lessThanHead = lessThanTail = new ListNode(head.val);
                    //lessThanHead = lessThanTail = head;
                }else{
                    lessThanTail.next = new ListNode(head.val);
                	//lessThanTail.next = head;
                	lessThanTail = lessThanTail.next;
                }
            }/*else if(head.val == B){
                if(equalsHead == null && equalsTail == null){
                	equalsHead = equalsTail = new ListNode(head.val);
                	//equalsHead = equalsTail = head;
                }else{
                    equalsTail.next = new ListNode(head.val);
                	//equalsTail.next = head;
                    equalsTail = equalsTail.next;
                }
            }*/else if(head.val >= B){
                if(greaterHead == null && greaterTail == null){
                    greaterHead = greaterTail = new ListNode(head.val);
                	//greaterHead = greaterTail = head;
                }else{
                    greaterTail.next = new ListNode(head.val);
                	//greaterTail.next = head;
                    greaterTail = greaterTail.next;
                }
            }
            head = head.next;
        }
        
        if(lessThanHead == null) {
        	return greaterHead;
        }
        
        if(greaterHead != null) {
        	lessThanTail.next = greaterHead;
        }
        
        /*head = lessThanHead;
        ListNode temp = head;
        
        while(temp!=null && temp.next!=null){
            temp = temp.next;
        }
        temp.next = equalsHead;
        while(temp!=null && temp.next!=null){
            temp = temp.next;
        }
        temp.next = greaterHead;
        return head;*/
        
        return lessThanHead;
    }

}
