# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        p = dummy
        for i in range(n):
            head = head.next
        while head is not None:
            head = head.next
            p = p.next
        p.next = p.next.next
        return dummy.next
        

