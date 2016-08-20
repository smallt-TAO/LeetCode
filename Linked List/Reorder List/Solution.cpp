// LeetCode, Reorder List
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
    void reorderList(ListNode* head) {
        if (head == NULL) return;
        
        vector<ListNode*> nodes;
        ListNode* iter = head;
        while (iter != NULL) {
            nodes.push_back(iter);
            iter = iter->next;
        }
        int len = nodes.size();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            nodes[left]->next = nodes[right];
            nodes[right--]->next = nodes[++left];
        }
        nodes[left]->next = NULL;
    }
};
