// LeetCode, Minimum Depth of Binary Tree
// Time complexity O(n^2)
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
    int ans;
    int solve_dp(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        
        if (root -> left == NULL && root -> right == NULL) {
            return 1;
        }
        
        int lf = 0x7fffffff, rt = 0x7fffffff;
        if (root -> left)
            lf = solve_dp(root -> left);
            
        if (root -> right)
            rt = solve_dp(root -> right);
            
        return min(lf, rt) + 1;
    }
    
    int minDepth(TreeNode *root) {
        if (!root) return 0;
        return solve_dp(root);
    }
};