// LeetCode, Sort List
// Time complexity O(nlgn)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static  ListNode sortList(ListNode head) {
	    if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;
	    while(fast.next != null && fast.next.next != null){
	    	slow = slow.next;
	    	fast = fast.next.next;
	    }
	    ListNode list2 = slow.next;
	    slow.next = null;
	    head = sortList(head);
	    list2 = sortList(list2);
    	return merge(head, list2);
	}
	
	private static ListNode merge(ListNode list1, ListNode list2) {
		if(list1 == null) return list2;
		if(list2 == null) return list1;
		ListNode newHead = new ListNode(0);
		ListNode last = newHead;
		last = newHead;
		while(list1 != null && list2 != null){
			if(list1.val < list2.val){
				last.next = list1;
				list1 = list1.next;
			}else{
				last.next = list2;
				list2 = list2.next;
			}
			last = last.next;
		}
		if(list1 != null) last.next = list1;
		else if(list2 != null) last.next = list2;
		return newHead.next;
	}
}