// LeetCode, Remove Duplicates from Sorted List II
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
    ListNode* deleteDuplicates(ListNode* head) {
        if (!head || !head->next) return head;
        
        ListNode *Head = new ListNode(-1);
        Head->next = head;
        ListNode *pre = Head;
        ListNode *cur = head;
        while (cur && cur->next) {
            if (cur->val == cur->next->val) {
                while(cur->next && cur->val == cur->next->val) {
                    cur = cur->next;
                }
                pre->next = cur->next;
                cur = cur->next;
            } else {
                pre = pre->next;
                cur = cur->next;
            }
        }
        return Head->next;
    }
};
