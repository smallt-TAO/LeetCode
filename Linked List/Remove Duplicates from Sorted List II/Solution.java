// LeetCode, Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode Head = new ListNode(-1);
        Head.next = head;
        ListNode pre = Head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return Head.next;
    }
}
