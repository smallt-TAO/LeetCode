// LeetCode, Convert Sorted List to Binary Search Tree
// Time complexity O(n^2)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
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
    TreeNode *sortedListToBST(ListNode *head) {
        if (head == NULL) {
            return NULL;
        }
        int size = getListSize(head);
        return convertHelper(head, size);
    }
    
    int getListSize(ListNode *head) {
        int size = 0;
        while (head != NULL) {
            head = head -> next;
            size++;
        }
        return size;
    }
    
    TreeNode *convertHelper(ListNode *&head, int size) {
        if (size == 0) {
            return NULL;
        }
        
        TreeNode *root = new TreeNode(0);
        root -> left = convertHelper(head, size / 2);
        root -> val = head -> val; 
        head = head -> next;
        root -> right = convertHelper(head, size - size / 2 - 1);
        return root;
    }
};