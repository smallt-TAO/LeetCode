// LeetCode, Binary Tree Postorder Traversal
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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        const TreeNode *curt, *pre;
        stack<const TreeNode*> s;
        curt = root;
        
        do {
            while (curt != nullptr) { // go left.
                s.push(curt);
                curt = curt -> left;
            }
            pre = nullptr;
            while (!s.empty()) {
                curt = s.top();
                s.pop();
                // right child is not exit or trversal
                if (curt -> right == pre) {
                    result.push_back(curt -> val);
                    pre = curt; // save the pre node
                } else {
                    // push again
                    s.push(curt);
                    // handler the right tree
                    curt = curt -> right;
                    break;
                }
            }
        } while (!s.empty());
        
        return result;
    }
};