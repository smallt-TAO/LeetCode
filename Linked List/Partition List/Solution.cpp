// LeetCode, Partition List
// Time complexity O(n)
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        if (head == NULL) {
            return NULL;
        }
        
        ListNode *leftDummy = new ListNode(0);
        ListNode *rightDummy = new ListNode(0);
        ListNode *left = leftDummy, *right = rightDummy;
        
        while (head != NULL) {
            if (head->val < x) {
                left->next = head;
                left = head;
            } else {
                right->next = head;
                right = head;
            }
            head = head->next;
        }
        right->next = NULL;
        left->next = rightDummy->next;
        return leftDummy->next;
    }
};