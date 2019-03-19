package Assignment3;


public class GetIntersectionList {
	/**
	 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1  a2
                   
                     c1  c2  c3
                   
B:     b1  b2  b3

begin to intersect at node c1.

 Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
	 * @author Home
	 *
	 */

	class ListNode {
		 public int val;
		 public ListNode next;
		 ListNode(int x) { val = x; next = null; }
		 ListNode(int x,ListNode next) { val = x; this.next = next; }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    int a_length = getLength(a);
	    int b_length = getLength(b);
	    int d = b_length - a_length;
	    
	    ListNode A = a;
	    ListNode B = b;
	    
	    if(a_length > b_length) {
	        ListNode temp = A;
	        A = B;
	        B = temp;
	        d = a_length - b_length;
	    }
	    
	    for(int i=0; i<d; i++) {
	        B = B.next;
	    }
	    
	    while(A != null && B != null) {
	        if(A == B) {
	            return A;
	        }
	        A = A.next;
	        B = B.next;
	    }
	    
	    return null;
	}
	
	public int getLength(ListNode a) {
	    int count = 0;
	    ListNode b = a;
	    
	    while(b != null) {
	        count++;
	        b = b.next;
	    }
	    
	    return count;
	}

}
