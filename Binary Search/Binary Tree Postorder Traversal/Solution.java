// LeetCode, Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode pre = null; // previously traversed node
        TreeNode curt = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        do {
            while (curt != null) {
                s.push(curt);
                curt = curt.left;
            }
            pre = null;
            while (!s.empty()) {
                curt = s.pop();
                // right child is not exit or trversal
                if (curt.right == pre) {
                    result.add(curt.val);
                    pre = curt; // save the pre node
                } else {
                    // push again
                    s.push(curt);
                    // handler the right tree
                    curt = curt.right;
                    break;
                }
            }
        } while (!s.empty());
        
        return result;
    }
}