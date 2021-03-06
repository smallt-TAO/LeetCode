// LeetCode, Merge k Sorted Lists
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
    ListNode *mergeKLists(vector<ListNode *> &lists) {

        ListNode* tmp_node = NULL;
        ListNode* tar_node = NULL;
        ListNode* new_node = NULL;
        ListNode* result = NULL;
        for (int i = 0; i < lists.size(); ++i) {
            tmp_node = lists[i];
            if (NULL == tmp_node) {
                continue;
            }
            if (NULL == result) {
                result = new ListNode(tmp_node->val);
                tmp_node = tmp_node->next;
            } else {
                if (result->val > tmp_node->val) {
                    new_node = new ListNode(tmp_node->val);
                    new_node->next = result;
                    result = new_node;
                    tmp_node = tmp_node->next;
                }
            }
            tar_node = result;
            while (tmp_node != NULL) {
                while (NULL != tar_node->next && tar_node->next->val < tmp_node->val) {
                    tar_node = tar_node->next;
                }
                if (NULL == tar_node->next) {
                    new_node = new ListNode(tmp_node->val);
                    tar_node->next = new_node;
                } else {
                    new_node = new ListNode(tmp_node->val);
                    new_node->next = tar_node->next;
                    tar_node->next = new_node;
                }
                tmp_node = tmp_node->next;
            }
        }
        return result;
    }
};
