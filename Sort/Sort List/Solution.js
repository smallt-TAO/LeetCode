/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    if (head === null) {
        return head;
    }
    return mergeSort(head);
    
    function mergeSort(items) {
        if (items.next === null) {
            return items;
        }
        var left = items;
        var right = getMid(items);
        return merge(mergeSort(left), mergeSort(right));
    }
    
    function merge(left, right) {
        var merge_result;
        if (left === null) {
            return right;
        } else if (right === null) {
            return left;
        }
        if (left.val < right.val) {
            lead = left;
            left = left.next;
        } else {
            lead = right;
            right = right.next;
        }
        var tmp = lead;
        while (left !== null && right !== null) {
            if (left.val < right.val) {
                tmp.next = left;
                tmp = left;
                left = left.next;
            } else {
                tmp.next = right;
                tmp = right;
                right = right.next;
            }
        }
        if (left !== null) {
            tmp.next = left;
        } else {
            tmp.next = right;
        }
        return lead;
    }
    
    function getMid(first) {
        var fast = first.next;
        var slow = first.next;
        var prev = first;
        while (true) {
            if (fast !== null)
                fast = fast.next;
            else
                break;
            if (fast !== null)
                fast = fast.next;
            else
                break;
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;  // cut
        return slow;
    }
};