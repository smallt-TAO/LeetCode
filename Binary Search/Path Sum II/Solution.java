// LeetCode, Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList();
        List<Integer> list = new ArrayList<Integer>();
        pathSumRecur(root, sum, lists, list);
        return lists;
    }
    
    public void pathSumRecur(TreeNode root, int sum, List<List<Integer>> lists, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> newList = new ArrayList<Integer>(list);
            lists.add(newList);
        }
        pathSumRecur(root.left, sum - root.val, lists, list);
        pathSumRecur(root.right, sum - root.val, lists, list);
        
        list.remove(list.size() - 1);
    }
}