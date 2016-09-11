// LeetCode, Maximum Depth of Binary Tree
// Time complexity O(n)
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        
        int left = maxDepth(root -> left);
        int right = maxDepth(root -> right);
        return left > right ? left + 1 : right + 1;
    }
};