// LeetCode, Remove Nth Node From End of List
// Time complexity O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null)
                return null;
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}

