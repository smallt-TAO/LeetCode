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
var insertionSortList = function(head) {
    dummy = new ListNode(0);
    while (head !== null) {
        node = dummy;
        next = head.next;
        while (node.next !== null && node.next.val < head.val) {
            node = node.next;
        }
        head.next = node.next;
        node.next = head;
        head = next;
    }
    
    return dummy.next;
};