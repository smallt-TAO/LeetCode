// LeetCode, Binary Tree Maximum Path Sum
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
    int ans;
    int solve_dp(TreeNode *root) {
        if (root == NULL) 
            return 0;
        
        int sum = root->val;
        int lf = 0, rt = 0;
        if (root->left)
            lf = solve_dp(root->left);
            
        if (root->right)
            rt = solve_dp(root->right);
            
        if (lf > 0) sum += lf;
        if (rt > 0) sum += rt;
        
        ans = max(ans, sum);
        return max(0, max(lf, rt)) + root->val;
    }
    
    int maxPathSum(TreeNode* root) {
        if (!root) return 0;
        ans = -0x7fffffff;
        solve_dp(root);
        return ans;
    }
};