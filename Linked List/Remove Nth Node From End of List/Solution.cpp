// LeetCode, Remove Nth Node From End of List
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (n <= 0) return NULL;
        
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        ListNode *p = new ListNode(0);
        p = dummy;
        for (int i = 0; i < n; i++) {
            if (head == NULL)
                return NULL;
            head = head->next;
        }
        while (head != NULL) {
            head = head->next;
            p = p->next;
        }
        p->next = p->next->next;
        return dummy->next;
    }
};


