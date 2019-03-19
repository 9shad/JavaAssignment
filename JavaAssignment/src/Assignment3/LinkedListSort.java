package Assignment3;

public class LinkedListSort {
	
	/**
	 * 
	 * Sort a linked list in O(n log n) time using constant space complexity.

Example :

Input : 1 -> 5 -> 4 -> 3

Returned list : 1 -> 3 -> 4 -> 5
	 * 
	 * 
	 * 
	 * @param args
	 */

	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     public int val;
	 *     public ListNode next;
	 *     ListNode(int x) { val = x; next = null; }
	 * }
	 */
	
	/**
	 * Lets look at merge sort. Traverse the linked list to find the mid point of the list. Now sort the first half and second half separatly by calling the function on them. Then merge the 2 lists
	 * @param args
	 */
	public static void main(String[] args) {
		
		// input keys
		int[] keys = { 1,5,4,3 };

		ListNode head = null;
		for (int key: keys) {
			head = new ListNode(key,head);
		}

		// sort the list
		head = mergeSort(head);

		// print the sorted list
		printList(head);
		
		
	}
	
	
	// Sort given linked list using Merge sort algorithm
	public static ListNode mergeSort(ListNode head)
	{
		// Base case -- length 0 or 1
		if (head == null || head.next == null) {
			return head;
		}

		// Split head into two sublists
		ListNode mid = getMid(head);
		ListNode nextToMid = mid.next;
		mid.next = null; //important step

		// Recursively sort the sublists
		// Left part of the linked list
        ListNode left = mergeSort(head);
        // Right part of the linked list
        ListNode right = mergeSort(nextToMid);
		// answer = merge the two sorted lists together
		return merge(left, right);
		
	}
	
	private static ListNode merge2ListsInPlace(ListNode left,ListNode right){
        ListNode new_head = null , sortingPtr = null;
        if(left.val < right.val){
            sortingPtr = left;
            new_head = left; 
            left = sortingPtr.next;
        }else{
            sortingPtr = right;
            new_head = right;
            right = sortingPtr.next;
        }
        
        while(left!=null && right!=null){
            if(left.val < right.val){
                sortingPtr.next = left;
                sortingPtr = left;
                left = sortingPtr.next;
            }else{
                sortingPtr.next = right;
                sortingPtr = right;
                right = sortingPtr.next;
            }    
        }
        
        if(left == null){
            sortingPtr.next = right;
        }else if(right == null){
            sortingPtr.next = left;
        }
        
        return new_head;
    }
	
	
	// Takes two lists sorted in increasing order, and merge their nodes
	// together to make one big sorted list which is returned
	public static ListNode merge(ListNode left, ListNode right)
	{
		// Base cases
		if (left == null)
			return right;

		else if (right == null)
			return left;

		ListNode result;

		// Pick either front or back, and recur
		if (left.val <= right.val)
		{
			result = left;
			result.next = merge(left.next, right);
		}
		else
		{
			result = right;
			result.next = merge(left, right.next);
		}

		return result;
	}
	
	/*
	Split the nodes of the given list into front and back halves,
	If the length is odd, the extra node should go in the front list.
	It uses the fast/slow pointer strategy
	*/
	private static ListNode getMid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Advance 'fast' two nodes, and advance 'slow' one node
		/*while (fast != null)
		{
			fast = fast.next;
			if (fast != null)
			{
				slow = slow.next;
				fast = fast.next;
			}
		}*/
        
        return slow;
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

}

class ListNode {
	 public int val;
	 public ListNode next;
	 ListNode(int x) { val = x; next = null; }
	 ListNode(int x,ListNode next) { val = x; this.next = next; }
}
