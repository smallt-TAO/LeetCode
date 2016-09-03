// LeetCode, Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();

        leftStack.push(root.left);
        rightStack.push(root.right);

        while (leftStack.size() > 0 && rightStack.size() > 0){
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val == right.val){
                leftStack.push(left.right);
                leftStack.push(left.left);
                rightStack.push(right.left);
                rightStack.push(right.right);
            }else return false;
        }
        return true;
    }
}