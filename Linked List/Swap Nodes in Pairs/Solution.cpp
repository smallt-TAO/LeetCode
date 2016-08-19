// LeetCode, Swap Nodes in Pairs
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
    ListNode* swapPairs(ListNode* head) {
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        
        head = dummy;
        while (head->next != NULL && head->next->next != NULL) {
            ListNode *n1 = head->next;
            ListNode *n2 = n1->next;
            // change the list.
            head->next = n2;
            n1->next = n2->next;
            n2->next = n1;
            // move to next pair.
            head = n1;
        }
        return dummy->next;
    }
};


