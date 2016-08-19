// LeetCode, Rotate List
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
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == NULL || k == 0) return head;
        
        int len = 1;
        ListNode *p = head;
        while (p->next) {
            len++;
            p = p->next;
        }
        k = len - k % len;
        
        p->next = head; // head and tail and together.
        for (int i = 0; i < k; i++) {
            p = p->next;
        }
        head = p->next;
        p->next = NULL;
        return head;
    }
};

