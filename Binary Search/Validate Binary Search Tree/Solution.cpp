// LeetCode, Validate Binary Search Tree
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
private:
    TreeNode *lastNode = NULL;
public:
    bool isValidBST(TreeNode* root) {
        if (root == NULL) {
            return true;
        }
        if (!isValidBST(root -> left)) {
            return false;
        }
        if (lastNode != NULL && lastNode -> val >= root -> val) {
            return false;
        }
        lastNode = root;
        return isValidBST(root -> right);
    }
};