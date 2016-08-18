// LeetCode, Add Two Numbers
// Time complexity O(m + n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while (true) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            point.val = carry % 10;
            carry /= 10;
            if (l1 != null || l2 != null || carry != 0) {
                point = (point.next = new ListNode(0));
            } else break;
        } 
        return head;
    }
}