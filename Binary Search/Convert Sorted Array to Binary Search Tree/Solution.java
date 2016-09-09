// LeetCode, Convert Sorted Array to Binary Search Tree
// Time complexity O(n)
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
     public static TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public static TreeNode sortedArrayToBST(int num[],int start, int end){
        if(start > end ) return null;
        if(start == end) return new TreeNode(num[start]);
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);
        return root;
    }
}