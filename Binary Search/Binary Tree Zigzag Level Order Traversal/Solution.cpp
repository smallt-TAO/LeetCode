// LeetCode, Binary Tree Zigzag Level Order Traversal
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if (root == nullptr) return result;
        
        queue<TreeNode*> q;
        bool left_to_right = true;
        vector<int> level;
        
        q.push(root);
        q.push(nullptr);
        while (!q.empty()) {
            TreeNode* cur = q.front();
            q.pop();
            if (cur) {
                level.push_back(cur -> val);
                if (cur -> left) q.push(cur -> left);
                if (cur -> right) q.push(cur -> right);
            } else {
                if (left_to_right) {
                    result.push_back(level);
                } else {
                    reverse(level.begin(), level.end());
                    result.push_back(level);
                }
                level.clear();
                left_to_right = !left_to_right;
                
                if (q.size() > 0) q.push(nullptr);
            }
        }
        
        return result;
    }
};