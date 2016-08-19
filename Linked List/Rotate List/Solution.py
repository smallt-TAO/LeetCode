# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def rotateRight(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if head == None or k == 0:
            return head
        len = 1
        cur = head
        while cur.next != None:
            len += 1
            cur = cur.next
        k = len - k % len
        cur.next = head
        for i in range(k):
            cur = cur.next
        head = cur.next
        cur.next = None
        return head
        

