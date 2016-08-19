// LeetCode, Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            head = reverseKNodes(head, k);
        }
        return dummy.next;
    }
    // reverse the next k nodes AFTER head: 
    // head->n1->n2..->nk->.. 
    // => head->nk->nk-1...->n1->..
    // return n1 (the next head)
    ListNode reverseKNodes(ListNode head, int k) {
        ListNode node = head;
        for (int i = 0; i < k; i++) {
            if (node.next == null) {
                return node;
            }
            node = node.next;
        }
        
        ListNode n1 = head.next;
        ListNode cur = n1;
        ListNode next = cur.next;
        for (int i = 0; i < k - 1; i++) {
            if (next == null) {
                n1.next = null;
                break;
            }
            ListNode temp = next.next;
            next.next = cur;
            cur = next;
            next = temp;
        }
        head.next = cur;
        n1.next = next;
        return n1;
    }
}



