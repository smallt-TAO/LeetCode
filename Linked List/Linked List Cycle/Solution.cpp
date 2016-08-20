// LeetCode, Linked List Cycle
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
    bool hasCycle(ListNode *head) {
        if (head == NULL || head->next == NULL) {
            return false;
        }
        ListNode *fast, *slow;
        fast = head->next;
        slow = head;
        while (fast != slow) {
            if (fast == NULL || fast->next == NULL)
                return false;
            fast = fast->next->next;
            slow = slow->next;
        }
        return true;
    }
};
