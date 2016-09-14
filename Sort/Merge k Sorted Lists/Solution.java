// LeetCode, Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
    
        return mergeK(lists, 0, lists.length-1);
    }

    private ListNode mergeK(ListNode[] lists, int low, int high) {
        if(low == high)
            return lists[low];
        if(low + 1 == high)
            return mergeTwo(lists[low], lists[high]);
        
        int mid = low + (high - low) / 2;
        return mergeTwo(mergeK(lists, low, mid), mergeK(lists, mid+1, high));
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode head, it;
        if(l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
    
        it = head;
    
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val <= l2.val) {
                    it.next = l1;
                    l1 = l1.next;
                } else {
                    it.next = l2;
                    l2 = l2.next;
                }
            } else if(l1 != null) {
                it.next = l1;
                l1 = l1.next;
            } else {
                it.next = l2;
                l2 = l2.next;
            }
            it = it.next;
        }
        return head;
    }
}