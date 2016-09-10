// LeetCode, Convert Sorted List to Binary Search Tree
// Time complexity O(n)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode current;
    
    private int getListLength (ListNode head) {
        int size = 0;
        
        while (head != null) {
            size++;
            head = head.next;
        }
        
        return size;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int size;
        
        current = head;
        size = getListLength(head);
        
        return sortedListToBSTHelper(size);
    }
    
    public TreeNode sortedListToBSTHelper(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}