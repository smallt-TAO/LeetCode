// LeetCode, Reverse Linked List II
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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (m >= n || head == NULL) {
            return head;
        }
        
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == NULL) {
                return NULL;
            }
            head = head->next;
        }
        
        ListNode *premNode = head;
        ListNode *mNode = head->next;
        ListNode *nNode = mNode, *postnNode = mNode->next;
        for (int i = m; i < n; i++) {
            if (postnNode == NULL) {
                return NULL;
            }
            ListNode *temp = postnNode->next;
            postnNode->next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode->next = postnNode;
        premNode->next = nNode;
        return dummy->next;
    }
};