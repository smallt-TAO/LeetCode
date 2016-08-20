// LeetCode, Copy List with Random Pointer
// Time complexity O(n)
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode result = null;
        RandomListNode pold = head, pnew = result, poldNext = null;
        while (pold != null) {
            poldNext = pold.next;
            pnew = new RandomListNode(pold.label);
            pold.next = pnew;
            pnew.next = poldNext;
            
            if (result == null) result = pnew;
            pold = poldNext;
        }
        // set the new pointer of new list.
        pold = head;
        while (pold != null) {
            if (pold.random != null)
                pold.next.random = pold.random.next;
            pold = pold.next.next;
        }
        // reload the old list and new list.
        pold = head;
        pnew = result;
        while (pnew.next != null) {
            pold.next = pnew.next;
            pold = pold.next;
            pnew.next = pold.next;
            pnew = pnew.next;
        }
        pold.next = null;
        pnew.next = null;
        return result;
    }
}
