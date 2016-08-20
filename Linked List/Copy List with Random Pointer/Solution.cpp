// LeetCode, Copy List with Random Pointer
// Time complexity O(n)
/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (head == NULL) return NULL;
        RandomListNode *result = NULL;
        RandomListNode *pold = head, *pnew = result, *poldNext = NULL;
        while (pold) {
            poldNext = pold->next;
            pnew = new RandomListNode(pold->label);
            pold->next = pnew;
            pnew->next = poldNext;
            
            if (result == NULL) result = pnew;
            pold = poldNext;
        }
        // set the new pointer of new list.
        pold = head;
        while (pold) {
            if (pold->random)
                pold->next->random = pold->random->next;
            pold = pold->next->next;
        }
        // reload the old list and new list.
        pold = head;
        pnew = result;
        while (pnew->next) {
            pold->next = pnew->next;
            pold = pold->next;
            pnew->next = pold->next;
            pnew = pnew->next;
        }
        pold->next = NULL;
        pnew->next = NULL;
        return result;
    }
};
