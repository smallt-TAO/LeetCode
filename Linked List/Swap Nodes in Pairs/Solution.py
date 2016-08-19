# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = ListNode(0)
        dummy.next = head
        head = dummy
        while head.next != None and head.next.next != None:
            n1 = head.next
            n2 = n1.next
            # change the sequeue.
            head.next = n2
            n1.next = n2.next
            n2.next = n1
            # move to next pair.
            head = n1;
        return dummy.next
        

