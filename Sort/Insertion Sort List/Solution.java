// LeetCode, Insertion Sort List
// Time complexity O(n^2)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode minHead = new ListNode(Integer.MIN_VALUE);
        ListNode last = head;
        while (last != null) {
            ListNode nextNode = last.next;
            ListNode insertNode = minHead;
            while (insertNode.next != null) {
                if (last.val < insertNode.next.val)
                    break;
                insertNode = insertNode.next;
            }
            last.next = insertNode.next;
            insertNode.next = last;
            last = nextNode;
        }
        return minHead.next;
    }
}