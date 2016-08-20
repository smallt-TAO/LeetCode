# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reorderList(self, head):
        """
        :type head: ListNode
        :rtype: void Do not return anything, modify head in-place instead.
        """
        if head is None or head.next is None:
            return
        fast = head;
        slow = head;
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        fast = slow.next
        slow.next = None
        next = fast.next
        fast.next = None
        while next:
            q = next.next
            next.next = fast
            fast = next
            next = q
        tail = head
        while fast:
            next = fast.next
            fast.next = tail.next
            tail.next = fast
            tail = tail.next.next
            fast = next
